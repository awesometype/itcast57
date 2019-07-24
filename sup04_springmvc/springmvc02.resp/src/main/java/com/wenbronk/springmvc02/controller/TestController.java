package com.wenbronk.springmvc02.controller;

import com.wenbronk.springmvc02.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author wenbronk
 * @Date 2019-07-14
 */
@Controller
@RequestMapping("/hi")
public class TestController {

    @RequestMapping("/testReturningString")
    public String testReturningString() {
        System.out.println("testReturingString");
        return "success";
    }

    @RequestMapping("/testReturingStringWithModel")
    public String testReturingStringWithModel(Model model) {
        System.out.println("testReturingStringWithModel");

        User user = new User();
        user.setUsername("vini");
        user.setAge(18);

        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testReturingVoidByRequest")
    public void testReturingVoidByRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        System.out.println("testReturingVoidByRequest");

        User user = new User();
        user.setUsername("vini");
        user.setAge(18);
        model.addAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
    }

    @RequestMapping("/testReturingVoidByResponse")
    public void testReturingVoidByResponse(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("testReturingVoidByResponse");

        User user = new User();
        user.setUsername("vini");
        user.setAge(18);

        model.addAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView");

        User user = new User();
        user.setUsername("vini");
        user.setAge(18);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testKeyWordForword")
    public String testKeyWordForword() {
        System.out.println("testKeyWordForword");

        User user = new User();
        user.setUsername("vini");
        user.setAge(18);
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testKeyWordRedirect")
    public String testKeyWordRedirect() {
        System.out.println("testKeyWordRedirect");
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user) {
        System.out.println(user);

        user.setUsername("wenbronk");
        user.setAge(27);
        return user;
    }

}
