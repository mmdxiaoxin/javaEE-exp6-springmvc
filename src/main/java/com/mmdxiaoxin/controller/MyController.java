package com.mmdxiaoxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello"; // 视图的逻辑名称，将由视图解析器解析为实际的视图
    }
}
