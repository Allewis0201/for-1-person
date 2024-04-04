package com.estsoft.for1person.controller;


import com.estsoft.for1person.dto.CommonViewResponse;
import com.estsoft.for1person.dto.ReviewViewResponse;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PageController {
    private ArticleService articleService;
    private ReviewService reviewService;
    private VipService vipService;
    private CommentService commentService;
    private UserService userService;

    private UserRepository userRepository;

    public PageController(ArticleService articleService, ReviewService reviewService, VipService vipService, CommentService commentService, UserService userService, UserRepository userRepository) {
        this.articleService = articleService;
        this.reviewService = reviewService;
        this.vipService = vipService;
        this.commentService = commentService;
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping("/commons")
    public String getCommons(Model model, Authentication authentication)
    {
        List<CommonViewResponse> articles = articleService.getAllArticle().stream()
                .map(Article::toViewResponse)
                .toList();

        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        model.addAttribute("list",articles);

        return "bulletinboard";
    }

    @GetMapping("/reviews")
    public String getReviews(Model model, Authentication authentication)
    {
        List<ReviewViewResponse> articles = articleService.getAllReview().stream()
                .map(Review::toViewResponse)
                .toList();

        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        model.addAttribute("list",articles);

        return "review-board";
    }


}
