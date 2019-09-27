package com.wenbronk.test.manager_cms;

import com.wenbronk.manager_cms.ManagerCmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-06 11:33
 * description:
 */
@SpringBootTest(classes = {ManagerCmsApplication.class})
@RunWith(SpringRunner.class)
public class RestTemplateTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testConfig() {
        ClientHttpRequestFactory requestFactory = restTemplate.getRequestFactory();
        System.out.println();
    }

    @Test
    public void testGetForObject() {
        String forObject = restTemplate.getForObject("https://www.baidu.com", String.class);
        System.out.println(forObject);
    }

}
