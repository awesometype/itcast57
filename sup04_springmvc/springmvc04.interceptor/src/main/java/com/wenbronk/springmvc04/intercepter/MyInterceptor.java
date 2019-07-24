package com.wenbronk.springmvc04.intercepter;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author wenbronk
 * @Date 2019-07-19
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 进入controller之前
     * 如果发生异常， 可以直接跳转error界面， 权限界面等
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("my interceptor pre invoke ");
        if (!StringUtils.isEmpty(request.getParameter("pre"))) {
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        }
        // 返回true表示放行
        return StringUtils.isEmpty(request.getParameter("interceptor"));
    }

    /**
     * controller返回之后
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("my intercpetor post invoke");
        if (!StringUtils.isEmpty(request.getParameter("post"))) {
            request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        }
    }

    /**
     * 完全结束之后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("my interceptor aftercompletion invoke");
    }
}
