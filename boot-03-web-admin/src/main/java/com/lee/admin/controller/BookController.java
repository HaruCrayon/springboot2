package com.lee.admin.controller;

import com.lee.admin.bean.Book;
import com.lee.admin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LiJing
 * @version 1.0
 */
@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @ResponseBody
    @GetMapping("/book")
    public Book getBookById(Integer id) {

        return bookService.getBookById(id);
    }

    @ResponseBody
    @PostMapping("/book")
    public Book saveBook(Book book) {
        bookService.saveBook(book);

        return book;
    }
}
