package com.estsoft.for1person.controller;


import com.estsoft.for1person.dto.ArticleViewResponse;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.dto.CommonViewResponse;
import com.estsoft.for1person.dto.ReviewViewResponse;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
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

    @Autowired
    private UserRepository userRepository;

    public PageController(ArticleService articleService, ReviewService reviewService, VipService vipService, CommentService commentService, UserService userService, UserRepository userRepository) {
        this.articleService = articleService;
        this.reviewService = reviewService;
        this.vipService = vipService;
        this.commentService = commentService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/newArticleBulletin")
    public String newArticleBulletin(@RequestParam(required = false) Long articleId, Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        if(articleId == null){
            model.addAttribute("article", new ArticleViewResponse());
        }
        else{
            Article article = articleService.findArticleId(articleId);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "writeBulletin";
    }

    @GetMapping("/newArticleReview")
    public String newArticleReview(@RequestParam(required = false) Long articleId, Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        if(articleId == null){
            model.addAttribute("article", new ArticleViewResponse());
        }
        else{
            Review article = articleService.findReviewId(articleId);
            model.addAttribute("article", new ReviewViewResponse(article));
        }
        return "writeReview";
    }

    @GetMapping("/common/{articleId}")
    public String showArticleCommon(@PathVariable Long articleId, Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        Article article  = articleService.findArticleId(articleId);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "detailCommon";
    }

    @GetMapping("/review/{reviewId}")
    public String showArticleReview(@PathVariable Long reviewId, Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());
        Review article  = articleService.findReviewId(reviewId);
        model.addAttribute("article", new ReviewViewResponse(article));
        return "detailReview";
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
