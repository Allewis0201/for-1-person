package com.estsoft.for1person.controller;

import com.estsoft.for1person.dto.AddUserRequest;
import com.estsoft.for1person.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    private final UserService userService;
    private final PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder){
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request); // 회원가입(저장)
        return "redirect:/login"; // 회원가입 처리 후 로그인 페이지로 이동
    }

    @PostMapping("/delete-account")
    public String deleteId(Authentication authentication) {
        String userId = authentication.getName();
        userService.deleteById(userId);
        return "redirect:/logout";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @GetMapping("/checkUsername")
    @ResponseBody
    public Map<String, Boolean> checkUsername(@RequestParam("userId") String userId) {
        boolean isAvailable = !userService.existsByUserId(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isAvailable", isAvailable);
        return response;
    }

    @GetMapping("/checkNickname")
    @ResponseBody
    public Map<String, Boolean> checkNickname(@RequestParam("nickname") String nickname) {
        boolean isAvailable = !userService.existsByNickname(nickname);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isAvailable", isAvailable);
        return response;
    }
    @PostMapping("/updateInfo")
    public String updateInfo( @RequestParam("password") String password, Authentication authentication){
        String userId = authentication.getName();
        String changePassword = encoder.encode(password);
        userService.updateProfile(userId,changePassword);
        return "redirect:/myInformation";
    }

    @PostMapping("/updateAuthor")
    public String updateAuthor(@RequestParam("changeAuthor") Integer changeAuthor, Authentication authentication){
        String userId = authentication.getName();
        userService.updateAuthor(userId, changeAuthor);
        return "redirect:/admin";
    }

}
