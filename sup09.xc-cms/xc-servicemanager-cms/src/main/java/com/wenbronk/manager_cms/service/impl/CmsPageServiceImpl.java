package com.wenbronk.manager_cms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.wenbronk.framework.exception.ExceptionCast;
import com.wenbronk.framework.repository.cms.CmsPageRepository;
import com.wenbronk.framework.repository.cms.CmsTemplateRepository;
import com.wenbronk.manager_cms.config.RabbitMQAutoConfiguration;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsTemplate;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.wenbronk.framework.model.response.*;
import com.wenbronk.manager_cms.service.CmsPageService;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-08-16 11:03
 * description:
 */
@Service
@Transactional
@Slf4j
public class CmsPageServiceImpl implements CmsPageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Autowired
    private CmsTemplateRepository cmsTemplateRepository;

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) throws Exception {

        CmsPage cmsPage = new CmsPage();
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        if (StringUtils.isNotEmpty(queryPageRequest.getTemplateId())) {
            cmsPage.setTemplateId(queryPageRequest.getTemplateId());
        }
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }

        if (page <= 0) {
            page = 1;
        }

        if (size <= 0) {
            size = 10;
        }

        // 构建example
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());

        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Pageable pageable = PageRequest.of(--page, size);
        Page<CmsPage> pages = cmsPageRepository.findAll(example, pageable);

        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setList(pages.getContent());
        queryResult.setTotal(pages.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public CmsPageResult add(CmsPage cmsPage) {
        if (cmsPage == null) {
            ExceptionCast.cast(CmsCode.CMS_COURSE_PERVIEWISNULL);
        }

        CmsPage queryResult = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        if (queryResult != null) {
            ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        // 初始化id
        cmsPage.setPageId(null);
        cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, cmsPage);
    }

    @Override
    public CmsPage findById(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        //返回空
        return null;
    }

    @Override
    public CmsPageResult update(String id, CmsPage cmsPage) {
        CmsPage byId = this.findById(id);
        if (byId == null) {
            ExceptionCast.cast(CmsCode.CMS_CMS_PAGE_NOTEXISTS);
        }

        // 更新模板id
        byId.setTemplateId(cmsPage.getTemplateId());
        byId.setSiteId(cmsPage.getSiteId());
        byId.setPageAliase(cmsPage.getPageAliase());
        byId.setPageName(cmsPage.getPageName());
        byId.setDataUrl(cmsPage.getDataUrl());
        byId.setPageWebPath(cmsPage.getPageWebPath());
        byId.setPagePhysicalPath(cmsPage.getPagePhysicalPath());
        //执行更新
        CmsPage save = cmsPageRepository.save(byId);
        if (save != null) {
            //返回成功
            CmsPageResult cmsPageResult = new CmsPageResult(CommonCode.SUCCESS, save);
            return cmsPageResult;
        }
        //返回失败
        return new CmsPageResult(CommonCode.FAIL,null);
    }

    @Override
    public ResponseResult delete(String id) {
        CmsPage cmsPage = this.findById(id);
        if (cmsPage != null) {
            cmsPageRepository.delete(cmsPage);
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }

    /**
     * 页面静态化
     */
    @Override
    public String getPageHtml(String pageId) {
        CmsPage cmsPage = this.findById(pageId);
        if (cmsPage == null) {
            ExceptionCast.cast(CmsCode.CMS_CMS_PAGE_NOTEXISTS);
        }

        // 获取 template
        String template = getTemplateById(cmsPage.getTemplateId());
        if (StringUtils.isEmpty(template)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        // 获取数据
        Map model = getModelByDataUrl(cmsPage.getDataUrl());
        if(model == null){
            //获取页面模型数据为空
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAISNULL);
        }
        return gernicHtml(template, model);
    }

    /**
     * 执行静态化
     */
    public String gernicHtml(String content, Map model) {
        String html = null;
        try {
            StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
            stringTemplateLoader.putTemplate("lunbotu", content);

            Configuration configuration = new Configuration(Configuration.getVersion());
            configuration.setTemplateLoader(stringTemplateLoader);

            // 获取模版
            Template template = configuration.getTemplate("lunbotu");
            html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }

    /**
     * 获取页面数据
     */
    public Map getModelByDataUrl(String url) {
        // 通过 dataUrl 获取data
        if(StringUtils.isEmpty(url)){
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_DATAURLISNULL);
        }
        ResponseEntity<Map> entity = restTemplate.getForEntity(url, Map.class);
        return entity.getBody();
    }


    /**
     * 从gridFS中获取template
     */
    public String getTemplateById(String templateId) {
        Optional<CmsTemplate> cmsTemplateOptional = cmsTemplateRepository.findById(templateId);
        if (!cmsTemplateOptional.isPresent()){
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_TEMPLATEISNULL);
        }
        CmsTemplate cmsTemplate = cmsTemplateOptional.get();
        // 模版文件id
        String templateFileId = cmsTemplate.getTemplateFileId();
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(templateFileId)));
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());

        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        String content = null;
        try {
            content = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
        } catch (IOException e) {
            log.error("catch exception " + e.getMessage());
            ExceptionCast.cast(CommonCode.FAIL);
        }
        return content;
    }

    /**
     * 页面发布
     */
    @Override
    public ResponseResult postPage(String pageId) throws IOException {
        // 执行静态化
        String pageHtml = this.getPageHtml(pageId);
        if (StringUtils.isEmpty(pageHtml)) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_HTMLISNULL);
        }

        // 获取page
        Optional<CmsPage> cmsPageOptional = cmsPageRepository.findById(pageId);
        if (!cmsPageOptional.isPresent()) {
            ExceptionCast.cast(CommonCode.FAIL);
        }

        CmsPage cmsPage = cmsPageOptional.get();
        // 保存静态化文件
        saveHtml(cmsPage, pageHtml);

        // 发送消息
        sendPostPage(cmsPage);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    private void sendPostPage(CmsPage cmsPage) {
        JSONObject msg = new JSONObject();
        msg.put("pageId", cmsPage.getPageId());

        //获取站点id作为routingKey
        String siteId = cmsPage.getSiteId();
        //发布消息
        this.rabbitTemplate.convertAndSend(RabbitMQAutoConfiguration.EX_ROUTING_CMS_POSTAGE,siteId, msg);
    }

    public CmsPage saveHtml(CmsPage cmsPage, String content) throws IOException {

        // 存储之前xian删除
        String htmlFileId = cmsPage.getHtmlFileId();
        if(StringUtils.isNotEmpty(htmlFileId)){
            gridFsTemplate.delete(Query.query(Criteria.where("_id").is(htmlFileId)));
        }

        //保存html文件到GridFS
        InputStream inputStream = IOUtils.toInputStream(content, "utf-8");
        String fileId = gridFsTemplate.store(inputStream, cmsPage.getPageName()).toString();
        //将文件id存储到cmspage中
        cmsPage.setHtmlFileId(fileId);
        cmsPageRepository.save(cmsPage);
        return cmsPage;
    }


}
