package com.genius.webmvc.controller;

import com.genius.webmvc.exception.CustomException;
import com.genius.webmvc.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    LoginService loginService;

    // test for see http header data
    @GetMapping
    String main(@RequestHeader Map<String, String> httpHeader) {
        log.info("HTTP Header: " + httpHeader);
        return "login";
    }

    // test for apply custom exception
    @PostMapping
    String login(HttpSession session, @RequestParam String name, @RequestParam String password) throws CustomException {
       try {
           boolean result = loginService.login(name, password);
           session.setAttribute("loginStatus", "Login Success.");
       } catch (CustomException err) {
           return "redirect:/login";
       }

//       return "redirect:/";
        return "redirect:/book";
    }
}
