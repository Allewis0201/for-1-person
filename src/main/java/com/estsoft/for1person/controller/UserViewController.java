package com.estsoft.for1person.controller;

import com.estsoft.for1person.dto.UserViewResponse;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.service.ArticleService;
import com.estsoft.for1person.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserRepository userRepository;
    private final ArticleService articleService;
    private final CommentService commentService;


    //==================================================================================================================
    // 로그인 페이지로 이동
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //==================================================================================================================
    // 회원가입 페이지로 이동
    @GetMapping("/membership")
    public String membership() {
        return "membership";
    }

    //==================================================================================================================
    // 메인 페이지로 이동
    @GetMapping("/mainScreen")
    public String mainScreen(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        return "mainScreen";
    }

    //==================================================================================================================
    // 계정 정보 페이지로 이동
    @GetMapping("/myInformation")
    public String myInformation(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        return "myInformation";
    }

    //==================================================================================================================
    // 관리 페이지로 이동
    @GetMapping("/admin")
    public String admin(Model model, Authentication authentication, @RequestParam(required = false) String searchType,
                        @RequestParam(required = false) String searchKey) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        model.addAttribute("total", userRepository.countAllUsers());

        if (searchType != null && searchKey != null && !searchKey.isEmpty()) {
            List<User> result = new ArrayList<>();
            if ("searchId".equals(searchType)) {
                if (userRepository.findByUserId(searchKey).isPresent()) {
                    result.add(userRepository.findByUserId(searchKey).get());
                }
            } else if ("searchNickname".equals(searchType)) {
                if (userRepository.findByNickname(searchKey).isPresent()) {
                    result.add(userRepository.findByNickname(searchKey).get());
                }
            }

            if (result.isEmpty()) {
                model.addAttribute("message", "존재하지 않는 회원입니다.");
            } else {
                model.addAttribute("userList", result);
                return "adminpage";
            }
        }
        List<User> userList = userRepository.findAll();

        List<UserViewResponse> resultList = userList.stream()
                .map(User::toViewResponse)
                .toList();

        List<UserViewResponse> resultList2 = articleService.getAllArticleByUserId(resultList);
        List<UserViewResponse> resultList3 = commentService.getAllCommentByUserId(resultList2);

        model.addAttribute("userList", resultList3);
        return "adminpage";
    }
    //==================================================================================================================
}