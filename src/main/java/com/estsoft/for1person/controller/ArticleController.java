package com.estsoft.for1person.controller;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.service.ArticleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {

    private ArticleService articleService;
    // 게시판 (목록, 상세보기, 글쓰기, 댓글, 글 수정, 글 삭제)
    // 유저 정보 관리를 어떻게 하는지에 따라서 달라짐 (user_id가 필요 없을 수도)

    // 모든 목록 출력
    @GetMapping("/common")
    public ResponseEntity<List<Article>> getAllArticle() {
        return ResponseEntity.ok().body(articleService.getAllArticle());
    }
    @GetMapping("/review")
    public ResponseEntity<List<Review>> getAllReview() {
        return ResponseEntity.ok().body(articleService.getAllReview());
    }
    @GetMapping("/vip")
    public ResponseEntity<List<Vip>> getAllVip() {
        return ResponseEntity.ok().body(articleService.getAllVip());
    }
    //============================================================================================================
    // 하나의 아티클 상세 보기
    @GetMapping("/common/{article_id}")
    public ResponseEntity<Article> getArticle(@PathVariable("article_id") long articleId) {
        return ResponseEntity.ok().body(articleService.getArticle(articleId));
    }
    @GetMapping("/review/{article_id}")
    public ResponseEntity<Review> getReview(@PathVariable("article_id") long articleId) {
        return ResponseEntity.ok().body(articleService.getReview(articleId));
    }
    @GetMapping("/vip/{article_id}")
    public ResponseEntity<Vip> getVip(@PathVariable("article_id") long articleId) {
        return ResponseEntity.ok().body(articleService.getVip(articleId));
    }
    //==================================================================================================================
    // 아티클 생성(글 쓰기)
    // 아티클 내용을 받을 DTO 필요
    @PostMapping("/common/{user_id}")
    public void createArticle(@PathVariable("user_id") long userId) {
        articleService.createArticle(userId);
    }
    @PostMapping("/review/{user_id}")
    public void createReview(@PathVariable("user_id") long userId) {
        articleService.createReview(userId);
    }
    @PostMapping("/vip/{user_id}")
    public void createVip(@PathVariable("user_id") long userId) {
        articleService.createVip(userId);
    }
    //==================================================================================================================
    // 아티클 수정
    // 수정 내용을 담을 DTO 필요
    @PostMapping("/common/{user_id}/{article_id}")
    public void updateArticle(@PathVariable("user_id") long userId, @PathVariable("article_id") long articleId) {
        articleService.updateArticle(userId, articleId);
    }
    @PostMapping("/review/{user_id}/{article_id}")
    public void updateReview(@PathVariable("user_id") long userId, @PathVariable("article_id") long articleId) {
        articleService.updateReview(userId, articleId);
    }

    @PostMapping("/vip/{user_id}/{article_id}")
    public void updateVip(@PathVariable("user_id") long userId, @PathVariable("article_id") long articleId) {
        articleService.updateVip(userId, articleId);
    }

    // 아티클 삭제
    @DeleteMapping("/common/{user_id}/{article_id}")
    public void deleteArticle(@PathVariable("user_id") long userId, @PathVariable("article_id") long articleId, @PathVariable String article_id) {
        articleService.deleteArticle(userId, articleId);
    }
    @DeleteMapping("/review/{user_id}/{article_id}")
    public void deleteReview(@PathVariable("user_id") long userId, @PathVariable("article_id") long articleId, @PathVariable String article_id) {
        articleService.deleteReview(userId, articleId);
    }

    @DeleteMapping("/vip/{user_id}/{article_id}")
    public void deleteVip(@PathVariable("user_id") long userId, @PathVariable("article_id") long articleId, @PathVariable String article_id) {
        articleService.deleteVip(userId, articleId);
    }

}
