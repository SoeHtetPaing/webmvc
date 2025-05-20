package com.genius.webmvc.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("login")
@Slf4j
public class LoginController {
    @GetMapping
    String main(@RequestHeader Map<String, String> httpHeader) {
        log.info("HTTP Header: " + httpHeader);
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
