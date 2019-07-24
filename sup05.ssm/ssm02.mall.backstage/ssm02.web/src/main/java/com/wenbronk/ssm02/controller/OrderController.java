package com.wenbronk.ssm02.controller;

import com.github.pagehelper.PageInfo;
import com.wenbronk.ssm02.domain.Orders;
import com.wenbronk.ssm02.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String findAll(int page, int size, Model model) {
        List<Orders> orderList = orderService.findAll(page, size);

        // 分页插件
        PageInfo<Orders> pageInfo = new PageInfo<>(orderList);
        model.addAttribute("pageInfo", pageInfo);
        return "orders-page-list";
    }

    @RequestMapping("/findById")
    public String findById(String id, Model model) {
        Orders orders = orderService.findById(id);

        model.addAttribute("orders", orders);
        return "orders-show";
    }

}
