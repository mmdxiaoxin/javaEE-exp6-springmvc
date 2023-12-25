package com.mmdxiaoxin.controller;

import com.mmdxiaoxin.service.UsersService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(Model model) {
        // 在模型中添加一个属性，用于在页面上显示消息
        model.addAttribute("message", "不支持的请求!");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model, HttpSession session) {
        if (usersService.validateUser(username, password)) {
            // 登录成功，将用户名和密码放入Cookie
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "redirect:/book/list";
        } else {
            // 登录失败，返回登录页面，并在模型中添加错误消息
            model.addAttribute("message", "用户名或密码错误");
            return "login";
        }
    }
}


