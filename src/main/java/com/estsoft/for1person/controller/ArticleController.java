package com.estsoft.for1person.controller;

import com.estsoft.for1person.dto.AddArticleRequest;
import com.estsoft.for1person.dto.AddReviewRequest;
import com.estsoft.for1person.dto.AddVipRequest;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


// 게시글 CRUD 및 게시글 좋아요 CRD 기능 컨트롤러

// 게시판 (목록, 상세보기, 글쓰기, 댓글, 글 수정, 글 삭제)
// 유저 정보 관리를 어떻게 하는지에 따라서 달라짐 (user_id가 필요 없을 수도)

@RestController
public class ArticleController {


    private final ArticleService articleService;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //============================================================================================================
    // 게시판 모든 목록 리스트로 반환(일반, 리뷰, VIP)
    @GetMapping("/api/common")
    public ResponseEntity<List<Article>> getAllArticle() {
        return ResponseEntity.ok().body(articleService.getAllArticle());
    }

    @GetMapping("/api/review")
    public ResponseEntity<List<Review>> getAllReview() {
        return ResponseEntity.ok().body(articleService.getAllReview());
    }

    @GetMapping("/api/vip")
    public ResponseEntity<List<Vip>> getAllVip() {
        return ResponseEntity.ok().body(articleService.getAllVip());
    }

    //============================================================================================================
    // 게시판 모든 목록 페이지로 반환(일반, 리뷰, VIP)
    @GetMapping("/api/common2")
    public ResponseEntity<Page<Article>> getAllArticle(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok().body(articleService.getAllArticlesPaged(page, size));
    }

    @GetMapping("/api/review2")
    public ResponseEntity<Page<Review>> getAllReview(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok().body(articleService.getAllReviewPaged(page, size));
    }

    @GetMapping("/api/vip2")
    public ResponseEntity<Page<Vip>> getAllVip(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok().body(articleService.getAllVipPaged(page, size));
    }

    //============================================================================================================
    // 게시글 1개 반환(일반, 리뷰, VIP)
    @GetMapping("/api/common/{article_id}")
    public ResponseEntity<Article> getArticle(@PathVariable("article_id") Long articleId) {
        return ResponseEntity.ok().body(articleService.getArticle(articleId));
    }

    @GetMapping("/api/review/{article_id}")
    public ResponseEntity<Review> getReview(@PathVariable("article_id") Long articleId) {
        return ResponseEntity.ok().body(articleService.getReview(articleId));
    }

    @GetMapping("/api/vip/{article_id}")
    public ResponseEntity<Vip> getVip(@PathVariable("article_id") Long articleId) {
        return ResponseEntity.ok().body(articleService.getVip(articleId));
    }

    //==================================================================================================================
    // 게시글 등록(일반, 리뷰, VIP)
    @PostMapping("/api/common/{user_id}")
    public ResponseEntity<?> createArticle(@PathVariable("user_id") String userId, @RequestParam("title") String title, @RequestParam("content") String content) {
        AddArticleRequest request = AddArticleRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(1).
                anonymous(false).
                build();

        articleService.createArticle(userId, request);
        return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/commons"));
    }

    @PostMapping("/api/review/{user_id}")
    public ResponseEntity<?> createReview(@PathVariable("user_id") String userId, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("score") Integer score) {
        AddReviewRequest request = AddReviewRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(2).
                anonymous(false).
                score(score).
                build();
        articleService.createReview(userId, request);
        return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/reviews"));
    }

    @PostMapping("/api/vip/{user_id}")
    public ResponseEntity<?> createVip(@PathVariable("user_id") String userId, @RequestParam("title") String title, @RequestParam("content") String content) {
        AddVipRequest request = AddVipRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(3).
                anonymous(false).
                build();

        articleService.createVip(userId, request);
        return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/vips"));
    }

    //==================================================================================================================
    // 특정 게시글 추천 기능
    // (추천은 게시글당 동일 유저가 최대 1개까지만 가능)
    // (추천을 안 눌렀을 때 누르면 추천이 되고 추천이 눌러져있을 때 누르면 추천이 해제됨)
    @GetMapping("/api/common/like/{user_id}/{article_id}")
    public void likeCommonArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeArticle(user_id, article_id);

    }

    @GetMapping("/api/review/like/{user_id}/{article_id}")
    public void likeReviewArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeReview(user_id, article_id);


    }

    @GetMapping("/api/vip/like/{user_id}/{article_id}")
    public void likeVipArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeVip(user_id, article_id);
    }

    //==================================================================================================================
    // 특정 게시글 추천 수 반환
    @GetMapping("/api/common/like/{article_id}")
    public Integer getLikeCommonArticle(@PathVariable("article_id") Long article_id) {
        return articleService.getLikeArticle(article_id).get();
    }

    @GetMapping("/api/review/like/{article_id}")
    public Integer getLikeReviewArticle(@PathVariable("article_id") Long article_id) {
        return articleService.getLikeReview(article_id).get();
    }

    @GetMapping("/api/vip/like/{article_id}")
    public Integer getLikeVipArticle(@PathVariable("article_id") Long article_id) {
        return articleService.getLikeVip(article_id).get();
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


    // 게시글 생성(일반, 리뷰, VIP)
    // 생성 코드 중복되서 주석처리(해당 코드는 유저 아이디를 PathVariable로 받아오지않음
//    @PostMapping("/api/common/test")
//    public String createArticleTest(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
//        String userId = authentication.getName();
//        AddArticleRequest request = AddArticleRequest.builder().
//                title(title).
//                content(content).
//                views(0L).
//                need(1).
//                anonymous(false).
//                build();
//
//        articleService.createArticle(userId, request);
//
//        return "Data received and stored.";
//    }
//
//    @PostMapping("/api/review/test")
//    public String createReviewTest(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
//        String userId = authentication.getName();
//        AddReviewRequest request = AddReviewRequest.builder().
//                title(title).
//                content(content).
//                views(0L).
//                need(2).
//                anonymous(false).
//                score(3).
//                build();
//        articleService.createReview(userId, request);
//
//        return "Data received and stored.";
//    }
//
//    @PostMapping("/api/vip/test")
//    public String createVip(@RequestParam("title") String title, @RequestParam("content") String content, Authentication authentication) {
//        String userId = authentication.getName();
//        AddVipRequest request = AddVipRequest.builder().
//                title(title).
//                content(content).
//                views(0L).
//                need(1).
//                anonymous(false).
//                build();
//
//        articleService.createVip(userId, request);
//
//        return "Data received and stored.";
//    }


    // 뷰 DTO를 사용한 업데이트 함수(현재 사용하지 않음)
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


    // 아티클 수정 (현재 사용하지 않음)
    // 수정 내용을 담을 DTO 필요
//    @PostMapping("/api/common/{user_id}/{article_id}")
//    public void updateArticle(@PathVariable("user_id") String userId, @PathVariable("article_id") Long articleId) {
//        articleService.updateArticle(userId, articleId);
//    }
//    @PostMapping("/api/review/{user_id}/{article_id}")
//    public void updateReview(@PathVariable("user_id") String userId, @PathVariable("article_id") Long articleId) {
//        articleService.updateReview(userId, articleId);
//    }
//
//    @PostMapping("/api/vip/{user_id}/{article_id}")
//    public void updateVip(@PathVariable("user_id") String userId, @PathVariable("article_id") Long articleId) {
//        articleService.updateVip(userId, articleId);
//    }

    // 아티클 삭제
//    @DeleteMapping("/api/common/{user_id}/{article_id}")
//    public void deleteArticle(@PathVariable("user_id") Long userId, @PathVariable("article_id") Long articleId, @PathVariable String article_id) {
//        articleService.deleteArticle(userId, articleId);
//    }
//    @DeleteMapping("/api/review/{user_id}/{article_id}")
//    public void deleteReview(@PathVariable("user_id") Long userId, @PathVariable("article_id") Long articleId, @PathVariable String article_id) {
//        articleService.deleteReview(userId, articleId);
//    }
//
//    @DeleteMapping("/api/vip/{user_id}/{article_id}")
//    public void deleteVip(@PathVariable("user_id") Long userId, @PathVariable("article_id") Long articleId, @PathVariable String article_id) {
//        articleService.deleteVip(userId, articleId);
//    }

}

