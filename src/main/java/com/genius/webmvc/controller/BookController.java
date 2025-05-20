package com.genius.webmvc.controller;

import com.genius.webmvc.model.Book;
import com.genius.webmvc.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    BookService bookService;

    // test for give default data to view
    @ModelAttribute
    void setDefaultModel(Model model) {
        model.addAttribute("message", "");
    }

    // test for pass session data from login
    // test for see passed session id
    @GetMapping
    String main(Model model, @SessionAttribute("loginStatus") String sessionMsg, @CookieValue("JSESSIONID") String sessionID) {
        log.info("Session ID: " + sessionID);
        model.addAttribute("message", sessionMsg);
        return "index";
    }

    // test for R from CRUD
    @GetMapping("/book")
    String getAllBook(Model model) {
        List<Book> bookList = bookService.getAllBook();
        for (Book book : bookList) {
            log.info(book.toString());
        }
        model.addAttribute("bookList", bookList);

        return "book/home";
    }

    // test for R from CRUD
    @GetMapping("/book/search")
    String getBookBySyskey(Model model, @RequestParam("syskey") String searchSyskey) {
        List<Book> bookList = new ArrayList<>();

        if ("".equals(searchSyskey)) {
            bookList = bookService.getAllBook();
        } else {
            long syskey = Long.parseLong(searchSyskey);
            Book book = bookService.getBookBySyskey(syskey);
            if (book != null) {
                bookList.add(book);
                log.info(book.toString());
            } else {
                log.warn("No Book!");
            }
        }

        model.addAttribute("bookList", bookList);
        return "book/home";
    }

    // test for set session
    @GetMapping("book/session")
    String setSession(HttpSession session) {
        session.setAttribute("message", "Hello Session");
        return "index";
    }

    // test for read session
    @GetMapping("book/session/read")
    String getSession(@SessionAttribute String message, Model model) {
        model.addAttribute("message", message);
        return "index";
    }
}
