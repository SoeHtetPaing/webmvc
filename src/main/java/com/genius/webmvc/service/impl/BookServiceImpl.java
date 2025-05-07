package com.genius.webmvc.service.impl;

import com.genius.webmvc.dao.BookDao;
import com.genius.webmvc.model.Book;
import com.genius.webmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAllBook() {
        return bookDao.getAllBook();
    }

    @Override
    public Book getBookBySyskey(long syskey) {
        return bookDao.getBookBySyskey(syskey);
    }
}
