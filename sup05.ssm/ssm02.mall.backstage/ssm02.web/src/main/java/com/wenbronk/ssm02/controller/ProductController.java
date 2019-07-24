package com.wenbronk.ssm02.controller;

import com.wenbronk.ssm02.domain.Product;
import com.wenbronk.ssm02.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();

        model.addAttribute("productList", products);
        return "product-list1";
    }

    @RequestMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:findAll";
    }

}
