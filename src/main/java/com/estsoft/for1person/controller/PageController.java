package com.estsoft.for1person.controller;


import com.estsoft.for1person.dto.*;
import com.estsoft.for1person.entity.*;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import java.util.List;

@Controller
@Slf4j
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

    @GetMapping("/newArticleBulletin")
    public String newArticleBulletin(@RequestParam(required = false) Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        model.addAttribute("article", new ArticleViewResponse());
        return "writeBulletin";
    }



    @GetMapping("/newArticleReview")
    public String newArticleReview(@RequestParam(required = false) Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        model.addAttribute("article", new ReviewViewResponse());
        return "writeReview";
    }


    @GetMapping("/newArticleVip")
    public String newArticleVip(@RequestParam(required = false) Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        model.addAttribute("article", new VipViewResponse());
        return "writeVIP";
    }

    @GetMapping("/editArticleBulletin")
    public String editArticleBulletin(@RequestParam("articleId") Long articleId, Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        Article article = articleService.findArticleId(articleId);
        model.addAttribute("article", article.toViewResponse());
        return "editBulletin";
    }

    @GetMapping("/editArticleReview")
    public String editArticleReview(@RequestParam("articleId") Long articleId, Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        Review review = articleService.findReviewId(articleId);
        model.addAttribute("article", review.toViewResponse());
        return "editReview";
    }

    @GetMapping("/editArticleVip")
    public String editArticleVip(@RequestParam("articleId") Long articleId, Model model, Authentication authentication){
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        Vip vip = articleService.findVipId(articleId);
        model.addAttribute("article", vip.toViewResponse());
        return "editVip";
    }

    @GetMapping("/common/{articleId}")
    public String showArticleCommon(@PathVariable Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());


        articleService.increaseCommonView(articleId);
        Article article = articleService.findArticleId(articleId);
        model.addAttribute("article", article.toViewResponse());


        List<CommentCommonViewResponse> comments = commentService.getArticleCommonComment(articleId).stream()
                .map(CommentCommon::toViewResponse)
                .toList();
        model.addAttribute("comments",comments);

        Integer like = articleService.getLikeArticle(articleId).get();
        model.addAttribute("articleLike",like);

        Integer commentCount = commentService.getCommentCommonCount(articleId).get();
        model.addAttribute("commentCount",commentCount);


        return "detailCommon";
    }

    @GetMapping("/review/{reviewId}")
    public String showArticleReview(@PathVariable Long reviewId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());

        articleService.increaseReviewView(reviewId);
        Review article = articleService.findReviewId(reviewId);
        model.addAttribute("article", article.toViewResponse());


        List<CommentReviewViewResponse> comments = commentService.getArticleReviewComment(reviewId).stream()
                .map(CommentReview::toViewResponse)
                .toList();
        model.addAttribute("comments",comments);

        Integer like = articleService.getLikeReview(reviewId).get();
        model.addAttribute("reviewLike",like);

        Integer commentCount = commentService.getCommentReviewCount(reviewId).get();
        model.addAttribute("commentCount",commentCount);



        return "detailReview";
    }

    @GetMapping("/vip/{vipId}")
    public String showArticleVip(@PathVariable Long vipId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());

        articleService.increaseVipView(vipId);
        Vip vip = articleService.findVipId(vipId);
        model.addAttribute("article", vip.toViewResponse());


        List<CommentVipViewResponse> comments = commentService.getArticleVipComment(vipId).stream()
                .map(CommentVip::toViewResponse)
                .toList();
        model.addAttribute("comments",comments);

        Integer like = articleService.getLikeVip(vipId).get();
        model.addAttribute("vipLike",like);


        Integer commentCount = commentService.getCommentVipCount(vipId).get();
        model.addAttribute("commentCount",commentCount);



        return "detailVIP";
    }


//    @GetMapping("/commons2")
//    public String getCommons(Model model, Authentication authentication) {
//        List<CommonViewResponse> articles = articleService.getAllArticle().stream()
//                .map(Article::toViewResponse)
//                .toList();
//
//        List<CommonViewResponse> result = articleService.getAllLikeArticle(articles);
//        model.addAttribute("list", result);
//
//        String username = authentication.getName();
//        Optional<User> user = userRepository.findByUserId(username);
//        model.addAttribute("user", user.get());
//
//        return "bulletinboard";
//    }


    @GetMapping("/commons")
    public String getCommons(Model model, Authentication authentication,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "2") int size) {

        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.orElse(null));



        List<CommonViewResponse> articles = articleService.getAllArticle().stream()
                .map(Article::toViewResponse)
                .toList();

        List<CommonViewResponse> result = articleService.getAllLikeArticle(articles);



        //Page<Article> articlePage = articleService.getAllArticlesPaged(page, size);

        Page<CommonViewResponse> pageResult =  articleService.toPageFromList(result, page, size);



        model.addAttribute("list", pageResult.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageResult.getTotalPages());

        return "bulletinboard";
    }

//    @GetMapping("/reviews2")
//    public String getReviews(Model model, Authentication authentication) {
//        List<ReviewViewResponse> reviews = articleService.getAllReview().stream()
//                .map(Review::toViewResponse)
//                .toList();
//
//        List<ReviewViewResponse> result = articleService.getAllLikeReview(reviews);
//        model.addAttribute("list", result);
//
//        String username = authentication.getName();
//        Optional<User> user = userRepository.findByUserId(username);
//        model.addAttribute("user", user.get());
//
//
//        return "review-board";
//    }

    @GetMapping("/reviews")
    public String getReviews(Model model, Authentication authentication,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "2") int size) {



        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());


        List<ReviewViewResponse> reviews = articleService.getAllReview().stream()
                .map(Review::toViewResponse)
                .toList();

        List<ReviewViewResponse> result = articleService.getAllLikeReview(reviews);

        //Page<Review> reviewPage = articleService.getAllReviewPaged(page, size);

        Page<ReviewViewResponse> pageResult =  articleService.toPageFromList(result, page, size);

        model.addAttribute("list", pageResult.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageResult.getTotalPages());

        return "review-board";
    }



//    @GetMapping("/vips")
//    public String getVip(Model model, Authentication authentication) {
//        String username = authentication.getName();
//        Optional<User> user = userRepository.findByUserId(username);
//        if (user.get().getAuthor()<3){
//            return "redirect:/commons?error=accessForbidden";
//        }
//        model.addAttribute("user", user.get());
//
//        List<VipViewResponse> vips = articleService.getAllVip().stream()
//                .map(Vip::toViewResponse)
//                .toList();
//
//        List<VipViewResponse> result = articleService.getAllLikeVip(vips);
//        model.addAttribute("list", result);
//
//
//        return "vip-board";
//    }

    @GetMapping("/vips")
    public String getVips(Model model, Authentication authentication,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "2") int size) {

        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        if (user.get().getAuthor()<3){
            return "redirect:/commons?error=accessForbidden";
        }

        model.addAttribute("user", user.get());

        List<VipViewResponse> vips = articleService.getAllVip().stream()
                .map(Vip::toViewResponse)
                .toList();

        List<VipViewResponse> result = articleService.getAllLikeVip(vips);

        //Page<Vip> vipPage = articleService.getAllVipPaged(page, size);

        Page<VipViewResponse> pageResult =  articleService.toPageFromList(result, page, size);

        model.addAttribute("list", pageResult.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageResult.getTotalPages());


        return "vip-board";
    }


    @GetMapping("/deleteArticleCommon")
    public String deleteCommon(@RequestParam("articleId") Long articleId, Authentication authentication)
    {
        String userId = authentication.getName();

        commentService.deleteAllArticleComment(articleId);
        articleService.deleteLikeAllArticle(articleId);
        articleService.deleteArticle(userId,articleId);

        return "redirect:commons";
    }


    @GetMapping("/deleteArticleReview")
    public String deleteReview(@RequestParam("articleId") Long articleId, Authentication authentication)
    {
        String userId = authentication.getName();

        commentService.deleteAllReviewComment(articleId);
        articleService.deleteLikeAllReview(articleId);
        articleService.deleteReview(userId,articleId);

        return "redirect:reviews";
    }


    @GetMapping("/deleteArticleVip")
    public String deleteVip(@RequestParam("articleId") Long articleId, Authentication authentication)
    {
        String userId = authentication.getName();

        commentService.deleteAllVipComment(articleId);
        articleService.deleteLikeAllVip(articleId);
        articleService.deleteVip(userId,articleId);

        return "redirect:vips";
    }


    @GetMapping("/article/common/like/{user_id}/{article_id}")
    public String commonLike(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id)
    {
        articleService.likeArticle(user_id, article_id);

        return "redirect:/common/" + article_id;
    }

    @GetMapping("/article/review/like/{user_id}/{article_id}")
    public String reviewLike(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id)
    {
        articleService.likeReview(user_id, article_id);

        return "redirect:/review/" + article_id;
    }


    @GetMapping("/article/vip/like/{user_id}/{article_id}")
    public String vipLike(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id)
    {
        articleService.likeVip(user_id, article_id);

        return "redirect:/vip/" + article_id;
    }

}
