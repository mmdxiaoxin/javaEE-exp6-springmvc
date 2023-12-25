package com.mmdxiaoxin.controller;

import com.mmdxiaoxin.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BooksService booksService;

    @Autowired
    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @RequestMapping("/list")
    public String list(Model model) throws SQLException {
        model.addAttribute("list",booksService.list());
        return "list";
    }
}
