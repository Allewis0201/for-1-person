package com.estsoft.for1person.controller;

import com.estsoft.for1person.dto.AddCommentRequest;
import com.estsoft.for1person.entity.CommentCommon;
import com.estsoft.for1person.entity.CommentReview;
import com.estsoft.for1person.entity.CommentVip;
import com.estsoft.for1person.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //==================================================================================================================
    // 게시판의 모든 댓글 목록 리스트로 반환 (일반, 리뷰, VIP)
    @GetMapping("/api/comment/common")
    public ResponseEntity<List<CommentCommon>> getAllCommentCommon() {
        return ResponseEntity.ok().body(commentService.getAllCommentCommon());
    }

    @GetMapping("/api/comment/review")
    public ResponseEntity<List<CommentReview>> getAllCommentReview() {
        return ResponseEntity.ok().body(commentService.getAllCommentReview());
    }

    @GetMapping("/api/comment/vip")
    public ResponseEntity<List<CommentVip>> getAllCommentVip() {
        return ResponseEntity.ok().body(commentService.getAllCommentVip());
    }

    //==================================================================================================================
    // 게시글의 댓글 1개 반환(일반, 리뷰, VIP)
    @GetMapping("/api/comment/common/{article_id}/{comment_id}")
    public ResponseEntity<CommentCommon> getCommonComment(@PathVariable("comment_id") Long commentId, @PathVariable Long article_id) {
        return ResponseEntity.ok().body(commentService.getCommentCommon(commentId));
    }

    @GetMapping("/api/comment/review/{article_id}/{comment_id}")
    public ResponseEntity<CommentReview> getReviewComment(@PathVariable("comment_id") Long commentId, @PathVariable Long article_id) {
        return ResponseEntity.ok().body(commentService.getCommentReview(commentId));
    }

    @GetMapping("/api/comment/vip/{article_id}/{comment_id}")
    public ResponseEntity<CommentVip> getVipComment(@PathVariable("comment_id") Long commentId, @PathVariable Long article_id) {
        return ResponseEntity.ok().body(commentService.getCommentVip(commentId));
    }

    //==================================================================================================================
    // 특정 게시글에 달린 모든 댓글 반환(일반, 리뷰, VIP)

    @GetMapping("/api/comment/common/{article_id}")
    public ResponseEntity<List<CommentCommon>> getArticleCommonComment(@PathVariable("article_id") Long articleId) {
        return ResponseEntity.ok().body(commentService.getArticleCommonComment(articleId));
    }

    @GetMapping("/api/comment/review/{article_id}")
    public ResponseEntity<List<CommentReview>> getArticleReviewComment(@PathVariable("article_id") Long articleId) {
        return ResponseEntity.ok().body(commentService.getArticleReviewComment(articleId));
    }


    @GetMapping("/api/comment/vip/{article_id}")
    public ResponseEntity<List<CommentVip>> getArticleVipComment(@PathVariable("article_id") Long articleId) {
        return ResponseEntity.ok().body(commentService.getArticleVipComment(articleId));
    }

    //==================================================================================================================
    // 댓글 쓰기 (일반, 리뷰, VIP)
    @PostMapping("/api/comment/common/{article_id}")
    public ResponseEntity<?> createCommentCommon(@PathVariable("article_id") Long articleId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.createCommentCommon(userId, articleId, request);
        return ResponseEntity.ok().body(Map.of("message", "Comment created successfully"));
    }

    @PostMapping("/api/comment/review/{article_id}")
    public ResponseEntity<?> createCommentReview(@PathVariable("article_id") Long articleId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.createCommentReview(userId, articleId, request);
        return ResponseEntity.ok().body(Map.of("message", "Comment created successfully"));
    }

    @PostMapping("/api/comment/vip/{article_id}")
    public ResponseEntity<?> createCommentVip(@PathVariable("article_id") Long articleId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.createCommentVip(userId, articleId, request);
        return ResponseEntity.ok().body(Map.of("message", "Comment created successfully"));
    }

    //==================================================================================================================
    // 댓글 수정 (일반, 리뷰, VIP)
    @PostMapping("/api/comment/common/{article_id}/{comment_id}")
    public ResponseEntity<?> updateCommentCommon(@PathVariable("article_id") Long articleId, @PathVariable("comment_id") Long commentId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.updateCommentCommon(userId, articleId, commentId, request);
        return ResponseEntity.ok().body(Map.of("message", "Comment created successfully"));
    }

    @PostMapping("/api/comment/review/{article_id}/{comment_id}")
    public void updateCommentReview(@PathVariable("article_id") Long articleId, @PathVariable("comment_id") Long commentId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.updateCommentReview(userId, articleId, commentId, request);
    }

    @PostMapping("/api/comment/vip/{article_id}/{comment_id}")
    public void updateCommentVip(@PathVariable("article_id") Long articleId, @PathVariable("comment_id") Long commentId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.updateCommentVip(userId, articleId, commentId, request);
    }

    //==================================================================================================================
    // 댓글 삭제 (일반, 리뷰, VIP)
    @DeleteMapping("/api/comment/common/{comment_id}")
    public void deleteCommonComment(@PathVariable("comment_id") Long commentId, Authentication authentication) {
        String userId = authentication.getName();
        commentService.deleteCommonComment(userId, commentId);
    }

    @DeleteMapping("/api/comment/review/{comment_id}")
    public void deleteReviewComment(@PathVariable("comment_id") Long commentId, Authentication authentication) {
        String userId = authentication.getName();
        commentService.deleteReviewComment(userId, commentId);
    }

    @DeleteMapping("/api/comment/vip/{comment_id}")
    public void deleteVipComment(@PathVariable("comment_id") Long commentId, Authentication authentication) {
        String userId = authentication.getName();
        commentService.deleteVipComment(userId, commentId);
    }

    //==================================================================================================================
    // 게시글 특정 댓글 추천 기능 (API는 만들었으나 실 적용을 하지 못함)
    // (추천은 댓글 당 동일 유저가 최대 1개까지만 가능)
    // (추천을 안 눌렀을 때 누르면 추천이 되고 추천이 눌러져있을 때 누르면 추천이 해제됨)
    @GetMapping("/common/like/{user_id}/{article_id}")
    public void recommendArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        commentService.recommendArticle(user_id, article_id);
    }

    @GetMapping("/review/like/{user_id}/{article_id}")
    public void recommendReview(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        commentService.recommendReview(user_id, article_id);

    }

    @GetMapping("/vip/like/{user_id}/{article_id}")
    public void recommendVip(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        commentService.recommendVip(user_id, article_id);
    }

    //==================================================================================================================
    // 특정 댓글 추천 수 반환
    // (API는 만들었으나 실 적용을 하지 못함)

    @GetMapping("/api/common/recommend/{article_id}")
    public Integer getLikeCommonArticle(@PathVariable("article_id") Long article_id) {
        return commentService.getRecommendArticle(article_id).get();
    }

    @GetMapping("/api/review/recommend/{article_id}")
    public Integer getLikeReviewArticle(@PathVariable("article_id") Long review_id) {
        return commentService.getRecommendReview(review_id).get();
    }

    @GetMapping("/api/vip/recommend/{article_id}")
    public Integer getLikeVipArticle(@PathVariable("article_id") Long vip_id) {
        return commentService.getRecommendVip(vip_id).get();
    }
    //==================================================================================================================
    // 게시글에 달린 댓글 수 반환 (일반, 리뷰, VIP)

    @GetMapping("/api/comment/common/count/{article_id}")
    public Integer getCommentCommonCount(@PathVariable("article_id") Long article_id) {
        return commentService.getCommentCommonCount(article_id).get();
    }

    @GetMapping("/api/comment/review/count/{article_id}")
    public Integer getCommentReviewCount(@PathVariable("article_id") Long article_id) {
        return commentService.getCommentReviewCount(article_id).get();
    }

    @GetMapping("/api/comment/vip/count/{article_id}")
    public Integer getCommentVipCount(@PathVariable("article_id") Long article_id) {
        return commentService.getCommentVipCount(article_id).get();
    }

    //==================================================================================================================


}
