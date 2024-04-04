package com.estsoft.for1person.controller;

import com.estsoft.for1person.dto.AddCommentRequest;
import com.estsoft.for1person.entity.CommentCommon;
import com.estsoft.for1person.entity.CommentReview;
import com.estsoft.for1person.entity.CommentVip;
import com.estsoft.for1person.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;
    //==================================================================================================================
    // common comment 모든 목록 출력
    @GetMapping("/api/comment/common")
    public ResponseEntity<List<CommentCommon>> getAllCommentCommon() {
        return ResponseEntity.ok().body(commentService.getAllCommentCommon());
    }

    // review comment 모든 목록 출력
    @GetMapping("/api/comment/review")
    public ResponseEntity<List<CommentReview>> getAllCommentReview() {
        return ResponseEntity.ok().body(commentService.getAllCommentReview());
    }

    // common comment 모든 목록 출력
    @GetMapping("/api/comment/vip")
    public ResponseEntity<List<CommentVip>> getAllCommentVip() {
        return ResponseEntity.ok().body(commentService.getAllCommentVip());
    }
    //==================================================================================================================
    // common 하나의 댓글 상세 보기
    @GetMapping("/api/comment/common/{comment_id}")
    public ResponseEntity<CommentCommon> getCommonComment(@PathVariable("comment_id") Long commentId) {
        return ResponseEntity.ok().body(commentService.getCommentCommon(commentId));
    }
    // review 하나의 댓글 상세 보기
    @GetMapping("/api/comment/review/{comment_id}")
    public ResponseEntity<CommentReview> getReviewComment(@PathVariable("comment_id") Long commentId) {
        return ResponseEntity.ok().body(commentService.getCommentReview(commentId));
    }
    // vip 하나의 댓글 상세 보기
    @GetMapping("/api/comment/vip/{comment_id}")
    public ResponseEntity<CommentVip> getVipComment(@PathVariable("comment_id") Long commentId) {
        return ResponseEntity.ok().body(commentService.getCommentVip(commentId));
    }
    //==================================================================================================================
    // 댓글 쓰기
    // 댓글 내용을 받을 DTO 필요
    @PostMapping("/api/comment/common/{article_id}")
    public void createCommentCommon(@PathVariable("article_id") Long articleId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();

        commentService.createCommentCommon(userId,articleId,request);
    }
    @PostMapping("/api/comment/review/{article_id}")
    public void createCommentReview(@PathVariable("article_id") Long articleId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();

        commentService.createCommentReview(userId,articleId,request);
    }
    @PostMapping("/api/comment/vip/{article_id}")
    public void createCommentVip(@PathVariable("article_id") Long articleId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();

        commentService.createCommentVip(userId,articleId,request);
    }
    //==================================================================================================================
    // 댓글 수정
    // 수정 내용을 담을 DTO 필요
    @PostMapping("/api/comment/common/{article_id}/{comment_id}")
    public void updateCommentCommon(@PathVariable("article_id") Long articleId, @PathVariable("comment_id") Long commentId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.updateCommentCommon(userId,articleId,commentId,request);
    }
    @PostMapping("/api/comment/review/{article_id}/{comment_id}")
    public void updateCommentReview(@PathVariable("article_id") Long articleId, @PathVariable("comment_id") Long commentId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.updateCommentReview(userId,articleId,commentId,request);
    }
    @PostMapping("/api/comment/vip/{article_id}/{comment_id}")
    public void updateCommentVip(@PathVariable("article_id") Long articleId, @PathVariable("comment_id") Long commentId, @RequestBody AddCommentRequest request, Authentication authentication) {
        String userId = authentication.getName();
        commentService.updateCommentVip(userId,articleId,commentId,request);
    }
    //==================================================================================================================
    // 댓글 삭제
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
    //댓글 좋아요 기능, 이미 좋아요 되어 있으면 좋아요 취소
    @PostMapping("/common/like/{user_id}/{article_id}")
    public void recommendArticle(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        commentService.recommendArticle(user_id, article_id);
    }
    @PostMapping("/review/like/{user_id}/{article_id}")
    public void recommendReview(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        commentService.recommendReview(user_id, article_id);
    }
    @PostMapping("/vip/like/{user_id}/{article_id}")
    public void recommendVip(@PathVariable("user_id") String user_id, @PathVariable("article_id") Long article_id) {
        commentService.recommendVip(user_id, article_id);
    }


}
