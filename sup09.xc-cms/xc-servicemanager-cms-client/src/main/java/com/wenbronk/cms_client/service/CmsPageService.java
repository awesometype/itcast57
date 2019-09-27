package com.wenbronk.cms_client.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.wenbronk.framework.exception.ExceptionCast;
import com.wenbronk.framework.repository.cms.CmsPageRepository;
import com.wenbronk.framework.repository.cms.CmsSiteRepository;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 13:49
 * description:
 */
@Service
public class CmsPageService {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Autowired
    private CmsSiteRepository cmsSiteRepository;

    @Autowired
    private GridFsTemplate  gridFsTemplate;

    @Autowired
    private GridFSBucket gridFSBucket;

    /**
     * 将页面保存到服务器到物理路径
     */
    public void savePageToServer(String pageId) {
        Optional<CmsPage> cmsPageOptional = cmsPageRepository.findById(pageId);
        if (!cmsPageOptional.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_CMS_PAGE_NOTEXISTS);
        }
        CmsPage cmsPage = cmsPageOptional.get();

        // 获取页面物理路径
        CmsSite cmsSite = getCmsSiteById(cmsPage.getSiteId());
        String pagePath = cmsSite.getSiteWebPath() + cmsPage.getPagePhysicalPath() + cmsPage.getPageName();

        // 获取静态页面
        String htmlFileId = cmsPage.getHtmlFileId();
        InputStream inputStream = this.getFileById(htmlFileId);
        if (inputStream == null) {
            ExceptionCast.cast(CmsCode.CMS_GENERATEHTML_HTMLISNULL);
        }

        // 文件保存在物理路径
        try (FileOutputStream outputStream = new FileOutputStream(pagePath)) {
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InputStream getFileById(String fileId) {
        try {
            GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
            GridFSDownloadStream downloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
            GridFsResource gridFsResource = new GridFsResource(gridFSFile, downloadStream);
            return gridFsResource.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CmsSite getCmsSiteById(String siteId) {
        Optional<CmsSite> byId = cmsSiteRepository.findById(siteId);
        return byId.orElse(null);
    }

}
