package com.mmdxiaoxin.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果用户未登录，跳转到 login 界面
        if (!isUserLoggedIn(request)) {
            response.sendRedirect("/login");
            return false;
        }

        return true; // 返回 true 表示放行请求
    }

    private boolean isUserLoggedIn(HttpServletRequest request) {
        return request.getSession().getAttribute("username") != null;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 如果是以 login 结尾的请求
        if (modelAndView != null && Objects.requireNonNull(modelAndView.getViewName()).endsWith("login")) {
            // 则直接重定向到首页不再显示登录页
            response.sendRedirect("/book/list");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
