package com.mmdxiaoxin.dao;

import com.mmdxiaoxin.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    List<Book> selectAll();

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
}