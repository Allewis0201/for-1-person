package com.estsoft.for1person.controller;


import com.estsoft.for1person.service.*;
import org.springframework.stereotype.Controller;

@Controller
public class PageController {
    private ArticleService articleService;
    private ReviewService reviewService;
    private VipService vipService;
    private CommentService commentService;
    private UserService userService;

    public PageController(ArticleService articleService, ReviewService reviewService, VipService vipService, CommentService commentService, UserService userService) {
        this.articleService = articleService;
        this.reviewService = reviewService;
        this.vipService = vipService;
        this.commentService = commentService;
        this.userService = userService;
    }
}
