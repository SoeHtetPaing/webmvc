package com.genius.webmvc.dao.impl;

import com.genius.webmvc.dao.BookDao;
import com.genius.webmvc.model.Book;
import com.genius.webmvc.util.CommonHandler;
import com.genius.webmvc.util.DateTimeHandler;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookDaoImpl implements BookDao {
    List<Book> bookList;

    public BookDaoImpl() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book(CommonHandler.getSyskey(), 1, DateTimeHandler.getCurrentTimestamp(), DateTimeHandler.getCurrentTimestamp(), "genius.iq", "", 1, "Java", "Java Author"));
        bookList.add(new Book(CommonHandler.getSyskey(), 2, DateTimeHandler.getCurrentTimestamp(), DateTimeHandler.getCurrentTimestamp(), "genius.iq", "", 1, "Spring", "Spring Author"));
    }

    @Override
    public List<Book> getAllBook() {
        return bookList;
    }

    @Override
    public Book getBookBySyskey(long syskey) {
        return bookList.stream().filter(book -> book.getSyskey() == syskey).findFirst().orElse(null);
    }
}
