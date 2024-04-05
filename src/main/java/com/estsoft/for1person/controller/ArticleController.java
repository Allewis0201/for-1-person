package com.estsoft.for1person.controller;

import com.estsoft.for1person.dto.AddArticleRequest;
import com.estsoft.for1person.dto.AddReviewRequest;
import com.estsoft.for1person.dto.AddVipRequest;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    // 게시판 (목록, 상세보기, 글쓰기, 댓글, 글 수정, 글 삭제)
    // 유저 정보 관리를 어떻게 하는지에 따라서 달라짐 (user_id가 필요 없을 수도)

    // 모든 목록 출력
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
    // 하나의 아티클 상세 보기
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
    // 아티클 생성(글 쓰기)
    // 아티클 내용을 받을 DTO 필요
    @PostMapping("/api/common/{user_id}")
    public void createArticle(@PathVariable("user_id") String userId, @RequestParam("title") String title, @RequestParam("content") String content) {
        AddArticleRequest request = AddArticleRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(1).
                anonymous(false).
                build();

        articleService.createArticle(userId, request);
    }
    @PostMapping("/api/review/{user_id}")
    public void createReview(@PathVariable("user_id") String userId, @RequestParam("title") String title, @RequestParam("content") String content) {
        AddReviewRequest request = AddReviewRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(2).
                anonymous(false).
                score(3).
                build();
        articleService.createReview(userId, request);
    }
    @PostMapping("/api/vip/{user_id}")
    public void createVip(@PathVariable("user_id") String userId, @RequestParam("title") String title, @RequestParam("content") String content) {
        AddVipRequest request = AddVipRequest.builder().
                title(title).
                content(content).
                views(0L).
                need(1).
                anonymous(false).
                build();

        articleService.createVip(userId, request);
    }
    //==================================================================================================================
    // 아티클 수정
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

    //==================================================================================================================
    //게시글 좋아요 기능, 이미 좋아요 되어 있으면 좋아요 취소
    @PostMapping("/api/common/like/{user_id}/{article_id}")
    public void likeCommonArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeArticle(user_id, article_id);
    }
    @PostMapping("/api/review/like/{user_id}/{article_id}")
    public void likeReviewArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeReview(user_id, article_id);
    }
    @PostMapping("/api/vip/like/{user_id}/{article_id}")
    public void likeVipArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        articleService.likeVip(user_id, article_id);
    }

}
