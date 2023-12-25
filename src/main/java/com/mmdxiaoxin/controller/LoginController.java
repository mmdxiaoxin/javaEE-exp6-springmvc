package com.mmdxiaoxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        // 返回视图的逻辑视图名，会由视图解析器解析为实际的 JSP 页面路径
        return "login";
    }
}

