package com.genius.webmvc.service;

import com.genius.webmvc.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    Book getBookBySyskey(long syskey);
}
