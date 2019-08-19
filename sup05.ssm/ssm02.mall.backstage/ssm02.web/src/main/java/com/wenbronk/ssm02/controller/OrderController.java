package com.wenbronk.ssm02.controller;

import com.github.pagehelper.PageInfo;
import com.wenbronk.ssm02.domain.Orders;
import com.wenbronk.ssm02.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author wenbronk
 * @Date 2019-07-21
 */
@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(Integer page, Integer size) {
        List<Orders> orderList = orderService.findAll(page, size);

        // 分页插件
        PageInfo<Orders> pageInfo = new PageInfo<>(orderList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    @RequestMapping("/findById")
    public String findById(String id, Model model) {
        Orders orders = orderService.findById(id);

        model.addAttribute("orders", orders);
        return "orders-show";
    }

}
