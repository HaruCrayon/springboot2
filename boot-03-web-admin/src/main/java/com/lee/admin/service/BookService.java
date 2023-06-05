package com.lee.admin.service;

import com.lee.admin.bean.Book;

/**
 * @author LiJing
 * @version 1.0
 */
public interface BookService {
    Book getBookById(Integer id);

    void saveBook(Book book);
}
