package com.estsoft.for1person.controller;

import com.estsoft.for1person.entity.CommentCommon;
import com.estsoft.for1person.entity.CommentReview;
import com.estsoft.for1person.entity.CommentVip;
import com.estsoft.for1person.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private CommentService commentService;
    //==================================================================================================================
    // common comment 모든 목록 출력
    @GetMapping("/common")
    public ResponseEntity<List<CommentCommon>> getAllCommentCommon() {
        return ResponseEntity.ok().body(commentService.getAllCommentCommon());
    }

    // review comment 모든 목록 출력
    @GetMapping("/review")
    public ResponseEntity<List<CommentReview>> getAllCommentReview() {
        return ResponseEntity.ok().body(commentService.getAllCommentReview());
    }

    // common comment 모든 목록 출력
    @GetMapping("/vip")
    public ResponseEntity<List<CommentVip>> getAllCommentVip() {
        return ResponseEntity.ok().body(commentService.getAllCommentVip());
    }
    //==================================================================================================================
    // common 하나의 댓글 상세 보기
    @GetMapping("/common/{comment_id}")
    public ResponseEntity<CommentCommon> getCommonComment(@PathVariable("comment_id") Long commentId) {
        return ResponseEntity.ok().body(commentService.getCommentCommon(commentId));
    }
    // review 하나의 댓글 상세 보기
    @GetMapping("/review/{comment_id}")
    public ResponseEntity<CommentReview> getReviewComment(@PathVariable("comment_id") Long commentId) {
        return ResponseEntity.ok().body(commentService.getCommentReview(commentId));
    }
    // vip 하나의 댓글 상세 보기
    @GetMapping("/vip/{comment_id}")
    public ResponseEntity<CommentVip> getVipComment(@PathVariable("comment_id") Long commentId) {
        return ResponseEntity.ok().body(commentService.getCommentVip(commentId));
    }
    //==================================================================================================================
    // 댓글 쓰기
    // 댓글 내용을 받을 DTO 필요
    @PostMapping("/common/{user_id}")
    public void createCommentCommon(@PathVariable("user_id") Long userId) {
        commentService.createCommentCommon(userId);
    }
    @PostMapping("/review/{user_id}")
    public void createCommentReview(@PathVariable("user_id") Long userId) {
        commentService.createCommentReview(userId);
    }
    @PostMapping("/vip/{user_id}")
    public void createCommentVip(@PathVariable("user_id") Long userId) {
        commentService.createCommentVip(userId);
    }
    //==================================================================================================================
    // 댓글 수정
    // 수정 내용을 담을 DTO 필요
    @PostMapping("common/{user_id}/{comment_id}")
    public void updateCommentCommon(@PathVariable("user_id") Long userId, @PathVariable("comment_id") Long commentId) {
        commentService.updateCommentCommon(userId, commentId);
    }
    @PostMapping("review/{user_id}/{comment_id}")
    public void updateCommentReview(@PathVariable("user_id") Long userId, @PathVariable("comment_id") Long commentId) {
        commentService.updateCommentReview(userId, commentId);
    }
    @PostMapping("vip/{user_id}/{comment_id}")
    public void updateCommentVip(@PathVariable("user_id") Long userId, @PathVariable("comment_id") Long commentId) {
        commentService.updateCommentVip(userId, commentId);
    }
    //==================================================================================================================
    // 댓글 삭제
    @DeleteMapping("common/{user_id}/{comment_id}")
    public void deleteCommonComment(@PathVariable("user_id") Long userId, @PathVariable("comment_id") Long commentId, @PathVariable String comment_id) {
        commentService.deleteCommonComment(userId, commentId);
    }
    @DeleteMapping("review/{user_id}/{comment_id}")
    public void deleteReviewComment(@PathVariable("user_id") Long userId, @PathVariable("comment_id") Long commentId, @PathVariable String comment_id) {
        commentService.deleteReviewComment(userId, commentId);
    }
    @DeleteMapping("vip/{user_id}/{comment_id}")
    public void deleteVipComment(@PathVariable("user_id") Long userId, @PathVariable("comment_id") Long commentId, @PathVariable String comment_id) {
        commentService.deleteVipComment(userId, commentId);
    }

}
