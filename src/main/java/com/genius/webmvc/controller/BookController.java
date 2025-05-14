package com.genius.webmvc.controller;

import com.genius.webmvc.model.Book;
import com.genius.webmvc.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    String main(Model model, @SessionAttribute String loginStatus) {
        model.addAttribute("message", loginStatus);
        return "index";
    }

    @GetMapping("/book")
    String getAllBook() {
        List<Book> bookList = bookService.getAllBook();
        for (Book book : bookList) {
            log.info(book.toString());
        }
        return "index";
    }

    @GetMapping("book/{syskey}")
    String getBookBySyskey(@PathVariable long syskey) {
        Book book = bookService.getBookBySyskey(syskey);

        if (book != null) {
            log.info(book.toString());
        } else {
            log.warn("No Book!");
        }


        return "index";
    }

    @GetMapping("book/session")
    String setSession(HttpSession session) {
        session.setAttribute("message", "Hello Session");
        return "index";
    }

    @GetMapping("book/session/read")
    String getSession(@SessionAttribute String message, Model model) {
        model.addAttribute("message", message);
        return "index";
    }
}
