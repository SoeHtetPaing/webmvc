package com.genius.webmvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@RequestMapping("login")
@Slf4j
public class LoginController {
    @GetMapping
    String main() {
        return "login";
    }

    @PostMapping
    String login(HttpSession session, @RequestParam String name, @RequestParam String password) {
        log.info("username: " + name);
        log.info("password: " + password);

        if(name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            session.setAttribute("loginStatus", "Login Success");
            return "redirect:/";
        }

        return "login";
    }
}
