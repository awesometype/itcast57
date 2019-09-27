package com.wenbronk.xc.test.freemarker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-09 11:10
 * description:
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/freemarker")
    public ModelAndView getModel(Map<String, Object> map) {
        String dataUrl = "http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f";
        Map forObject = restTemplate.getForObject(dataUrl, Map.class);
        map.putAll(forObject);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("index_banner");
        return modelAndView;
    }
}
