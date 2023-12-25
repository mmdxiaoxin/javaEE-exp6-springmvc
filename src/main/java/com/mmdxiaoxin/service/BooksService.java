package com.mmdxiaoxin.service;

import com.mmdxiaoxin.model.Book;
import com.mmdxiaoxin.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BooksService {
    private final BookDao bookDAO;

    @Autowired
    public BooksService(BookDao bookDAO) {
        this.bookDAO = bookDAO;
    }

    // Get all books
    public List<Book> list() throws SQLException {
        return bookDAO.selectAll();
    }

    // Get book by ID
    public Book getById(int id) throws SQLException {
        return bookDAO.selectByPrimaryKey(id);
    }

    // Insert or update book
    public void save(Book book) throws SQLException {
        if (book.getId() == 0) {
            bookDAO.insert(book);
        } else {
            bookDAO.updateByPrimaryKeySelective(book);
        }
    }

    // Delete book
    public void delete(int id) throws SQLException {
        bookDAO.deleteByPrimaryKey(id);
    }
}
