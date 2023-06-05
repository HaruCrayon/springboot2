package com.lee.admin.bean;

import lombok.Data;

/**
 * @author LiJing
 * @version 1.0
 */
@Data
public class Book {
    private Integer bookId;
    private String bookName;
    private Integer price;
    private Integer stock;
}
