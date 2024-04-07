package com.estsoft.for1person.controller;


import com.estsoft.for1person.dto.*;
import com.estsoft.for1person.entity.*;
import com.estsoft.for1person.repository.ArticleRepository;
import com.estsoft.for1person.repository.ReviewRepository;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.repository.VipRepository;
import com.estsoft.for1person.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

    private ArticleRepository articleRepository;

    private ReviewRepository reviewRepository;
    private VipRepository vipRepository;

    public PageController(ArticleService articleService, ReviewService reviewService, VipService vipService, CommentService commentService, UserService userService, UserRepository userRepository, ArticleRepository articleRepository, ReviewRepository reviewRepository, VipRepository vipRepository) {
        this.articleService = articleService;
        this.reviewService = reviewService;
        this.vipService = vipService;
        this.commentService = commentService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
        this.reviewRepository = reviewRepository;
        this.vipRepository = vipRepository;
    }

    //==================================================================================================================
    // 일반 게시글 생성 뷰
    @GetMapping("/newArticleBulletin")
    public String newArticleBulletin(@RequestParam(required = false) Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        model.addAttribute("article", new ArticleViewResponse());
        return "writeBulletin";
    }

    //==================================================================================================================
    // 리뷰 게시글 생성 뷰
    @GetMapping("/newArticleReview")
    public String newArticleReview(@RequestParam(required = false) Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        model.addAttribute("article", new ReviewViewResponse());
        return "writeReview";
    }

    //==================================================================================================================
    // VIP 게시글 생성 뷰
    @GetMapping("/newArticleVip")
    public String newArticleVip(@RequestParam(required = false) Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        model.addAttribute("article", new VipViewResponse());
        return "writeVIP";
    }

    //==================================================================================================================
    // 일반 게시글 수정 뷰
    @GetMapping("/editArticleBulletin")
    public String editArticleBulletin(@RequestParam("articleId") Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        Article article = articleService.getArticle(articleId);
        model.addAttribute("article", article.toViewResponse());
        return "editBulletin";
    }

    //==================================================================================================================
    // 리뷰 게시글 수정 뷰
    @GetMapping("/editArticleReview")
    public String editArticleReview(@RequestParam("articleId") Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        Review review = articleService.getReview(articleId);
        model.addAttribute("article", review.toViewResponse());
        return "editReview";
    }

    //==================================================================================================================
    // VIP 게시글 수정 뷰
    @GetMapping("/editArticleVip")
    public String editArticleVip(@RequestParam("articleId") Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("userId", user.get().getUserId());
        model.addAttribute("user", user.get());
        Vip vip = articleService.getVip(articleId);
        model.addAttribute("article", vip.toViewResponse());
        return "editVip";
    }

    //==================================================================================================================
    // 일반 게시글 상세 뷰
    @GetMapping("/common/{articleId}")
    public String showArticleCommon(@PathVariable Long articleId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());


        articleService.increaseCommonView(articleId);
        Article article = articleService.getArticle(articleId);
        model.addAttribute("article", article.toViewResponse());


        List<CommentCommonViewResponse> comments = commentService.getArticleCommonComment(articleId).stream()
                .map(CommentCommon::toViewResponse)
                .toList();
        model.addAttribute("comments", comments);

        Integer like = articleService.getLikeArticle(articleId).get();
        model.addAttribute("articleLike", like);

        Integer commentCount = commentService.getCommentCommonCount(articleId).get();
        model.addAttribute("commentCount", commentCount);

        return "detailCommon";
    }

    //==================================================================================================================
    // 리뷰 게시글 상세 뷰

    @GetMapping("/review/{reviewId}")
    public String showArticleReview(@PathVariable Long reviewId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());

        articleService.increaseReviewView(reviewId);
        Review article = articleService.getReview(reviewId);
        model.addAttribute("article", article.toViewResponse());


        List<CommentReviewViewResponse> comments = commentService.getArticleReviewComment(reviewId).stream()
                .map(CommentReview::toViewResponse)
                .toList();
        model.addAttribute("comments", comments);

        Integer like = articleService.getLikeReview(reviewId).get();
        model.addAttribute("reviewLike", like);

        Integer commentCount = commentService.getCommentReviewCount(reviewId).get();
        model.addAttribute("commentCount", commentCount);


        return "detailReview";
    }

    //==================================================================================================================
    // Vip 게시글 상세 뷰
    @GetMapping("/vip/{vipId}")
    public String showArticleVip(@PathVariable Long vipId, Model model, Authentication authentication) {
        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());

        articleService.increaseVipView(vipId);
        Vip vip = articleService.getVip(vipId);
        model.addAttribute("article", vip.toViewResponse());


        List<CommentVipViewResponse> comments = commentService.getArticleVipComment(vipId).stream()
                .map(CommentVip::toViewResponse)
                .toList();
        model.addAttribute("comments", comments);

        Integer like = articleService.getLikeVip(vipId).get();
        model.addAttribute("vipLike", like);


        Integer commentCount = commentService.getCommentVipCount(vipId).get();
        model.addAttribute("commentCount", commentCount);

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

    //==================================================================================================================
    // 일반 게시판 전체 뷰
    @GetMapping("/commons")
    public String getCommons(Model model, Authentication authentication,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "2") int size,
                             @RequestParam(required = false) String searchType,
                             @RequestParam(required = false) String searchKey) {

        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.orElse(null));


        if (searchType != null && searchKey != null && !searchKey.isEmpty()) {
            List<CommonViewResponse> searchList = new ArrayList<>();
            if ("title".equals(searchType)) {

                List<Article> testList = articleRepository.findAllByTitle(searchKey);

                if (!testList.isEmpty()) {

                    for (Article test : testList) {
                        CommonViewResponse test2 = test.toViewResponse();
                        searchList.add(test2);
                    }

                }
            } else if ("author".equals(searchType)) {
                User findUser = userRepository.findByNickname(searchKey).get();
                List<Article> testList = articleRepository.findAllByUser(findUser);

                if (!testList.isEmpty()) {

                    for (Article test : testList) {
                        CommonViewResponse test2 = test.toViewResponse();
                        searchList.add(test2);
                    }
                }
            }

            List<CommonViewResponse> finalList = articleService.getAllLikeArticle(searchList);
            Page<CommonViewResponse> pageResult = articleService.toPageFromList(finalList, page, size);

            model.addAttribute("list", pageResult.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", pageResult.getTotalPages());


        } else {
            List<CommonViewResponse> articles = articleService.getAllArticle().stream()
                    .map(Article::toViewResponse)
                    .toList();

            List<CommonViewResponse> result = articleService.getAllLikeArticle(articles);

            //Page<Article> articlePage = articleService.getAllArticlesPaged(page, size);

            Page<CommonViewResponse> pageResult = articleService.toPageFromList(result, page, size);

            model.addAttribute("list", pageResult.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", pageResult.getTotalPages());
        }


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

    //==================================================================================================================
    // 리뷰 게시판 전체 뷰
    @GetMapping("/reviews")
    public String getReviews(Model model, Authentication authentication,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(defaultValue = "2") int size,
                             @RequestParam(required = false) String searchType,
                             @RequestParam(required = false) String searchKey) {


        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        model.addAttribute("user", user.get());




        if (searchType != null && searchKey != null && !searchKey.isEmpty()) {
            List<ReviewViewResponse> searchList = new ArrayList<>();
            if ("title".equals(searchType)) {

                List<Review> testList = reviewRepository.findAllByTitle(searchKey);

                if (!testList.isEmpty()) {

                    for (Review test : testList) {
                        ReviewViewResponse test2 = test.toViewResponse();
                        searchList.add(test2);
                    }

                }
            } else if ("author".equals(searchType)) {
                User findUser = userRepository.findByNickname(searchKey).get();
                List<Review> testList = reviewRepository.findAllByUser(findUser);

                if (!testList.isEmpty()) {

                    for (Review test : testList) {
                        ReviewViewResponse test2 = test.toViewResponse();
                        searchList.add(test2);
                    }
                }
            }

            List<ReviewViewResponse> finalList = articleService.getAllLikeReview(searchList);
            Page<ReviewViewResponse> pageResult = articleService.toPageFromList(finalList, page, size);

            model.addAttribute("list", pageResult.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", pageResult.getTotalPages());

        } else {
            List<ReviewViewResponse> reviews = articleService.getAllReview().stream()
                    .map(Review::toViewResponse)
                    .toList();

            List<ReviewViewResponse> result = articleService.getAllLikeReview(reviews);

            //Page<Review> reviewPage = articleService.getAllReviewPaged(page, size);

            Page<ReviewViewResponse> pageResult = articleService.toPageFromList(result, page, size);

            model.addAttribute("list", pageResult.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", pageResult.getTotalPages());
        }

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

    //==================================================================================================================
    // Vip 게시판 전체 뷰
    @GetMapping("/vips")
    public String getVips(Model model, Authentication authentication,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "2") int size,
                          @RequestParam(required = false) String searchType,
                          @RequestParam(required = false) String searchKey) {

        String username = authentication.getName();
        Optional<User> user = userRepository.findByUserId(username);
        if (user.get().getAuthor() < 3) {
            return "redirect:/commons?error=accessForbidden";
        }

        model.addAttribute("user", user.get());




        if (searchType != null && searchKey != null && !searchKey.isEmpty()) {
            List<VipViewResponse> searchList = new ArrayList<>();
            if ("title".equals(searchType)) {

                List<Vip> testList = vipRepository.findAllByTitle(searchKey);

                if (!testList.isEmpty()) {

                    for (Vip test : testList) {
                        VipViewResponse test2 = test.toViewResponse();
                        searchList.add(test2);
                    }

                }
            } else if ("author".equals(searchType)) {
                User findUser = userRepository.findByNickname(searchKey).get();
                List<Vip> testList = vipRepository.findAllByUser(findUser);

                if (!testList.isEmpty()) {

                    for (Vip test : testList) {
                        VipViewResponse test2 = test.toViewResponse();
                        searchList.add(test2);
                    }
                }
            }

            List<VipViewResponse> finalList = articleService.getAllLikeVip(searchList);
            Page<VipViewResponse> pageResult = articleService.toPageFromList(finalList, page, size);

            model.addAttribute("list", pageResult.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", pageResult.getTotalPages());

        } else {
            List<VipViewResponse> vips = articleService.getAllVip().stream()
                    .map(Vip::toViewResponse)
                    .toList();

            List<VipViewResponse> result = articleService.getAllLikeVip(vips);

            //Page<Vip> vipPage = articleService.getAllVipPaged(page, size);

            Page<VipViewResponse> pageResult = articleService.toPageFromList(result, page, size);

            model.addAttribute("list", pageResult.getContent());
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", pageResult.getTotalPages());
        }


        return "vip-board";
    }


    //==================================================================================================================
    // 일반 게시글 삭제 처리 후 일반 전체 게시판으로 이동
    @GetMapping("/deleteArticleCommon")
    public String deleteCommon(@RequestParam("articleId") Long articleId, Authentication authentication) {
        String userId = authentication.getName();

        commentService.deleteAllArticleComment(articleId);
        articleService.deleteLikeAllArticle(articleId);
        articleService.deleteArticle(userId, articleId);

        return "redirect:commons";
    }

    //==================================================================================================================
    // 리뷰 게시글 삭제 처리 후 리뷰 전체 게시판으로 이동
    @GetMapping("/deleteArticleReview")
    public String deleteReview(@RequestParam("articleId") Long articleId, Authentication authentication) {
        String userId = authentication.getName();

        commentService.deleteAllReviewComment(articleId);
        articleService.deleteLikeAllReview(articleId);
        articleService.deleteReview(userId, articleId);

        return "redirect:reviews";
    }

    //==================================================================================================================
    // Vip 게시글 삭제 처리 후 Vip 전체 게시판으로 이동
    @GetMapping("/deleteArticleVip")
    public String deleteVip(@RequestParam("articleId") Long articleId, Authentication authentication) {
        String userId = authentication.getName();

        commentService.deleteAllVipComment(articleId);
        articleService.deleteLikeAllVip(articleId);
        articleService.deleteVip(userId, articleId);

        return "redirect:vips";
    }

    //==================================================================================================================
    // 일반 게시글 추천 처리 후 일반 게시글 상세로 이동
    @GetMapping("/article/common/like/{user_id}/{article_id}")
    public String commonLike(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeArticle(user_id, article_id);

        return "redirect:/common/" + article_id;
    }

    //==================================================================================================================
    // 리뷰 게시글 추천 처리 후 리뷰 게시글 상세로 이동
    @GetMapping("/article/review/like/{user_id}/{article_id}")
    public String reviewLike(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeReview(user_id, article_id);

        return "redirect:/review/" + article_id;
    }

    //==================================================================================================================
    // Vip 게시글 추천 처리 후 Vip 게시글 상세로 이동
    @GetMapping("/article/vip/like/{user_id}/{article_id}")
    public String vipLike(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeVip(user_id, article_id);

        return "redirect:/vip/" + article_id;
    }

}
