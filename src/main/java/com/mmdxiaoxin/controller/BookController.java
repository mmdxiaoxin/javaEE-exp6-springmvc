package com.mmdxiaoxin.controller;

import com.mmdxiaoxin.model.Book;
import com.mmdxiaoxin.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("result",booksService.list());
        return "list";
    }

    @RequestMapping("/add")
    public String add(Model model) throws SQLException {
        return "add";
    }

    @RequestMapping("/edit")
    public String save(@RequestParam int id, Model model) throws SQLException {
        // 根据图书ID获取图书信息
        Book book = booksService.getById(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @RequestMapping("/save")
    public String save(Book book) throws SQLException {
        // 保存或更新图书信息
        booksService.save(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int id) throws SQLException {
        // 根据图书ID删除图书信息
        booksService.delete(id);
        return "redirect:/book/list";
    }
}
