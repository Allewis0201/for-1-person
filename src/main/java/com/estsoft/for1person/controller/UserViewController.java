package com.estsoft.for1person.controller;

import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserViewController {

    private UserRepository userRepository;

    @Autowired
    public UserViewController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/membership")
    public String membership(){
        return "/membership";
    }

    @GetMapping("/main")
    public String index(){
        return "/main";
    }

    @GetMapping("/myInformation")
    public String myInformation(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        return "/myInformation";
    }

    @GetMapping("/admin")
    public String admin(Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        List<User> userList = userRepository.findAll();
        model.addAttribute("user", user.get());
        model.addAttribute("userList", userList);
        return "adminpage";
    }
}