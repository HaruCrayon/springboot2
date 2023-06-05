package com.lee.admin.mapper;

import com.lee.admin.bean.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author LiJing
 * @version 1.0
 */
@Mapper
public interface BookMapper {

    @Select("select * from t_book where book_id = #{id}")
    Book getBookById(Integer id);

//    void saveBook(Book book);

    @Insert("insert into t_book(book_name,price,stock) values(#{bookName},#{price},#{stock});")
    @Options(useGeneratedKeys = true, keyProperty = "bookId")
    void saveBook(Book book);
}
