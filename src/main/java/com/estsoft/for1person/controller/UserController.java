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
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private final UserService userService;
    private final PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder){
        this.userService = userService;
        this.encoder = encoder;
    }

    //==================================================================================================================
    // 회원가입 처리 후 로그인 뷰로 이동
    @PostMapping("/user")
    public String signup(AddUserRequest request){
        userService.save(request); // 회원가입(저장)
        return "redirect:/login"; // 회원가입 처리 후 로그인 페이지로 이동
    }
    //==================================================================================================================
    // 회원탈퇴 처리 후 로그아웃으로 이동
    @PostMapping("/delete-account")
    public String deleteId(Authentication authentication) {
        String userId = authentication.getName();
        userService.deleteById(userId);
        return "redirect:/logout";
    }

    //==================================================================================================================
    // 로그아웃 처리 후 로그인 뷰로 이동
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
    //==================================================================================================================
    // 회원가입 때 아이디 중복체크 기능
    @GetMapping("/checkUsername")
    @ResponseBody
    public Map<String, Boolean> checkUsername(@RequestParam("userId") String userId) {
        boolean isAvailable = !userService.existsByUserId(userId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isAvailable", isAvailable);
        return response;
    }

    //==================================================================================================================
    // 회원가입 때 닉네임 중복체크 기능
    @GetMapping("/checkNickname")
    @ResponseBody
    public Map<String, Boolean> checkNickname(@RequestParam("nickname") String nickname) {
        boolean isAvailable = !userService.existsByNickname(nickname);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isAvailable", isAvailable);
        return response;
    }

    //==================================================================================================================
    // 계정 정보 변경 후 내 정보 뷰로 이동
    @PostMapping("/updateInfo")
    public String updateInfo( @RequestParam("password") String password, Authentication authentication){
        String userId = authentication.getName();
        String changePassword = encoder.encode(password);
        userService.updateProfile(userId,changePassword);
        return "redirect:/myInformation";
    }

    //==================================================================================================================
    // 권한 변경 후 관리 뷰로 이동
    @PostMapping("/updateAuthor")
    public String updateUserAuthor(@RequestParam("userIdCollect") List<String> userIds, @RequestParam("changeAuthor") Integer changeAuthor, Authentication authentication) {
        for (String userId : userIds) {
            userService.updateAuthor(userId, changeAuthor);
        }
        return "redirect:/admin";
    }
    //==================================================================================================================
}
