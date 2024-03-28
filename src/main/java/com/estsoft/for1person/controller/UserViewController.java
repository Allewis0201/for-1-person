package com.estsoft.for1person.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "/signup";
    }

    @GetMapping("/main")
    public String index(){
        return "/main";
    }
}
