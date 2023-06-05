package com.lee.admin.service.impl;

import com.lee.admin.bean.Book;
import com.lee.admin.mapper.BookMapper;
import com.lee.admin.service.BookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJing
 * @version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    Counter counter;

    //增加定制 Metrics 信息
    public BookServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("bookService.saveBook.count");
    }

    public Book getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }

    public void saveBook(Book book) {
        counter.increment();
        bookMapper.saveBook(book);
    }
}
