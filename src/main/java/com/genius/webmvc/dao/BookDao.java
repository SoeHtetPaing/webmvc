package com.genius.webmvc.dao;

import com.genius.webmvc.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBook();
    Book getBookBySyskey (long syskey);
}
