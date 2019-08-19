package com.wenbronk.ssm02.controller;

import com.wenbronk.ssm02.domain.Syslog;
import com.wenbronk.ssm02.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * itcast57.com.wenbronk.ssm02.controller
 * wenbronk create at 2019/7/27 11:54
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Syslog> syslogList = sysLogService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sysLogs", syslogList);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }

}
