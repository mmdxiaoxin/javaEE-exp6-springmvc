package com.mmdxiaoxin.service;

import com.mmdxiaoxin.model.Book;
import com.mmdxiaoxin.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.mmdxiaoxin.util.DateUtil;

@Service
public class BooksService {
    private final BookDao bookDAO;

    @Autowired
    public BooksService(BookDao bookDAO) {
        this.bookDAO = bookDAO;
    }

    // Get all books
    public List<Book> list() throws SQLException {
        List<Book> books = bookDAO.selectAll();

        for (Book book : books) {
            formatPublishDate(book);
        }

        return books;
    }

    // Get book by ID
    public Book getById(int id) throws SQLException {
        Book book = bookDAO.selectByPrimaryKey(id);

        // Format the publishdate for the book
        formatPublishDate(book);

        return book;
    }

    // Insert or update book
    public void save(Book book) throws SQLException {
        if (book.getId() == null) {
            bookDAO.insert(book);
        } else {
            bookDAO.updateByPrimaryKeySelective(book);
        }
    }

    // Delete book
    public void delete(int id) throws SQLException {
        bookDAO.deleteByPrimaryKey(id);
    }

    private void formatPublishDate(Book book) {
        if (book != null && book.getPublishdate() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(book.getPublishdate());
            book.setFormattedPublishDate(formattedDate);
        }
    }

}
