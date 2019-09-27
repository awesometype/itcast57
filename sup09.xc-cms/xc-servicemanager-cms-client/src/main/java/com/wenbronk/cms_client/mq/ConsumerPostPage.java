package com.wenbronk.cms_client.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wenbronk.cms_client.service.CmsPageService;
import com.wenbronk.framework.repository.cms.CmsPageRepository;
import com.xuecheng.framework.domain.cms.CmsPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 15:06
 * description:
 */
@Component
@Slf4j
public class ConsumerPostPage {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Autowired
    private CmsPageService cmsPageService;

    @RabbitListener(queues = {"${xc.mq.queue}"})
    public void postPage(String msg) {
        // 解析消息
        JSONObject msgJson = JSON.parseObject(msg);
        String pageId = msgJson.getString("pageId");

        // 查询页面信息
        Optional<CmsPage> cmsPageOptional = cmsPageRepository.findById(pageId);
        cmsPageOptional.ifPresent(cmsPage -> {
            cmsPageService.savePageToServer(pageId);
        });
    }
}
