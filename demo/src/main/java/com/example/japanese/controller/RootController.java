package com.example.japanese.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String root(HttpSession session) {
        Object u = session.getAttribute("user");
        if (u == null) return "redirect:/login";
        return "main";
    }
}
