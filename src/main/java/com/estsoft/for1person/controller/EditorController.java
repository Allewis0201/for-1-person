package com.estsoft.for1person.controller;


//import com.estsoft.for1person.domain.PhotoUtil;
import com.estsoft.for1person.dto.AddArticleRequest;
import com.estsoft.for1person.dto.AddReviewRequest;
import com.estsoft.for1person.dto.AddVipRequest;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.Optional;

@Slf4j
@RestController
public class EditorController {

    private ArticleService articleService;


    public EditorController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/api/post/imageUpload")
    public String handleImageUpload(@RequestParam("title") String title, @RequestParam("content") String content) {
        // 여기서 content 변수에는 사용자가 입력한 내용이 들어있습니다.
        // 이 내용을 데이터베이스에 저장하거나 다른 작업을 수행할 수 있습니다.

        log.info(title);
        log.info(content);

        return "Data received and stored.";
    }

    //==================================================================================================================
    // 아티클 생성(글 쓰기)
    // 아티클 내용을 받을 DTO 필요
    @PostMapping("/api/common/test")
    public String createArticleTest(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
        String userId = authentication.getName();
        AddArticleRequest request = AddArticleRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(1).
                anonymous(false).
                build();

        articleService.createArticle(userId, request);

        return "Data received and stored.";
    }

    @PostMapping("/api/review/test")
    public String createReviewTest(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
        String userId = authentication.getName();
        AddReviewRequest request = AddReviewRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(2).
                anonymous(false).
                score(3).
                build();
        articleService.createReview(userId, request);

        return "Data received and stored.";
    }

    @PostMapping("/api/vip/test")
    public String createVip(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
        String userId = authentication.getName();
        AddVipRequest request = AddVipRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(1).
                anonymous(false).
                build();

        articleService.createVip(userId, request);

        return "Data received and stored.";
    }

    //==================================================================================================================
    // 게시글 수정(일반, 리뷰, VIP)
    @PutMapping("/api/common/{article_id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("article_id") Long articleId, @RequestBody AddArticleRequest request, Authentication authentication) {
        String userId = authentication.getName();
        Article updateArticle = articleService.updateArticle(userId, articleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(updateArticle);
    }

    @PutMapping("/api/review/{article_id}")
    public ResponseEntity<Review> updateReview(@PathVariable("article_id") Long articleId, @RequestBody AddReviewRequest request, Authentication authentication) {
        String userId = authentication.getName();

        Review updateReview = articleService.updateReview(userId, articleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(updateReview);
    }

    @PutMapping("/api/vip/{article_id}")
    public ResponseEntity<Vip> updateVip(@PathVariable("article_id") Long articleId, @RequestBody AddArticleRequest request, Authentication authentication) {
        String userId = authentication.getName();

        Vip updateVip = articleService.updateVip(userId, articleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(updateVip);
    }

//    @PutMapping("/api/common/{article_id}")
//    public ResponseEntity<Article> updateArticle(@PathVariable("article_id") Long articleId, @RequestBody AddArticleRequest request, Authentication authentication) {
//        String userId = authentication.getName();
//        Article updateArticle = articleService.updateArticle(userId, articleId, request);
//        return ResponseEntity.status(HttpStatus.OK).body(updateArticle);
//    }
//
//    @PutMapping("/api/review/{article_id}")
//    public void updateReview(@PathVariable("article_id") Long articleId, @RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
//        String userId = authentication.getName();
//        AddReviewRequest request = AddReviewRequest.builder().
//                title(title).
//                content(content).
//                views(0L).
//                need(2).
//                anonymous(false).
//                score(3).
//                build();
//        articleService.updateReview(userId, articleId, request);
//    }
//
//    @PutMapping("/api/vip/{article_id}")
//    public void updateVip(@PathVariable("article_id") Long articleId, @RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
//        String userId = authentication.getName();
//        AddVipRequest request = AddVipRequest.builder().
//                title(title).
//                content(content).
//                views(0L).
//                need(1).
//                anonymous(false).
//                build();
//
//        articleService.updateVip(userId, articleId, request);
//    }

    //==================================================================================================================
    // 게시글 삭제(일반, 리뷰, VIP)
    @DeleteMapping("/api/common/{article_id}")
    public void deleteArticle(@PathVariable("article_id") Long articleId, Authentication authentication) {
        String userId = authentication.getName();
        articleService.deleteArticle(userId, articleId);
    }
    @DeleteMapping("/api/review/{article_id}")
    public void deleteReview(@PathVariable("article_id") Long articleId, Authentication authentication) {
        String userId = authentication.getName();
        articleService.deleteReview(userId, articleId);
    }

    @DeleteMapping("/api/vip/{article_id}")
    public void deleteVip(@PathVariable("article_id") Long articleId, Authentication authentication) {
        String userId = authentication.getName();
        articleService.deleteVip(userId, articleId);
    }

}
