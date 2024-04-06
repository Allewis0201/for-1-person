package com.estsoft.for1person.controller;

import com.estsoft.for1person.dto.UserViewResponse;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.service.ArticleService;
import com.estsoft.for1person.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserViewController {

    private UserRepository userRepository;
    private ArticleService articleService;
    private CommentService commentService;

    public UserViewController(UserRepository userRepository, ArticleService articleService, CommentService commentService) {
        this.userRepository = userRepository;
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/membership")
    public String membership() {
        return "membership";
    }

    @GetMapping("/mainScreen")
    public String mainScreen(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        return "mainScreen";
    }

    @GetMapping("/myInformation")
    public String myInformation(Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        return "myInformation";
    }

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
}