package com.estsoft.for1person.service;

import com.estsoft.for1person.entity.CommentCommon;
import com.estsoft.for1person.entity.CommentReview;
import com.estsoft.for1person.entity.CommentVip;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.CommentCommonRepository;
import com.estsoft.for1person.repository.CommentReviewRepository;
import com.estsoft.for1person.repository.CommentVipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentCommonRepository commentCommonRepository;
    private CommentVipRepository commentVipRepository;
    private CommentReviewRepository commentReviewRepository;

    public List<CommentCommon> getAllCommentCommon() {
        return commentCommonRepository.findAll();
    }
    public List<CommentVip> getAllCommentVip() {
        return commentVipRepository.findAll();
    }
    public List<CommentReview> getAllCommentReview() {
        return commentReviewRepository.findAll();
    }

    public CommentCommon getCommentCommon(Long commentId) {
        return commentCommonRepository.findById(commentId).orElseThrow();
    }
    public CommentVip getCommentVip(Long commentId) {
        return commentVipRepository.findById(commentId).orElseThrow();
    }
    public CommentReview getCommentReview(Long commentId) {
        return commentReviewRepository.findById(commentId).orElseThrow();
    }

    //dto 대체
    public void createCommentCommon(String commentId) {
        CommentCommon comments = new CommentCommon();
        commentCommonRepository.save(comments);
    }
    public void createCommentVip(String commentId) {
        CommentVip comments = new CommentVip();
        commentVipRepository.save(comments);
    }
    public void createCommentReview(String commentId) {
        CommentReview comments = new CommentReview();
        commentReviewRepository.save(comments);
    }

    public void updateCommentCommon(String userId, Long commentId) {
        CommentCommon comment = commentCommonRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 comment에 넣어서 변경
        // 후 저장
        commentCommonRepository.save(comment);
    }
    public void updateCommentReview(String userId, Long commentId) {
        CommentVip comment = commentVipRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 comment에 넣어서 변경
        // 후 저장
        commentVipRepository.save(comment);
    }
    public void updateCommentVip(String userId, Long commentId) {
        CommentReview comment = commentReviewRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 comment에 넣어서 변경
        // 후 저장
        commentReviewRepository.save(comment);
    }

    public void deleteCommonComment(String userId, Long commentId) {
        //있는지 확인
        commentCommonRepository.findById(commentId);
        //유저 아이디랑 일치하는지 확인
        CommentCommon comments = new CommentCommon();
        //있으면 삭제 없으면 에러 반환
        commentCommonRepository.deleteById(commentId);
    }

    public void deleteReviewComment(String userId, Long commentId) {
        //있는지 확인
        commentVipRepository.findById(commentId);
        //유저 아이디랑 일치하는지 확인
        CommentVip comments = new CommentVip();
        //있으면 삭제 없으면 에러 반환
        commentVipRepository.deleteById(commentId);
    }

    public void deleteVipComment(String userId, Long commentId) {
        //있는지 확인
        commentReviewRepository.findById(commentId);
        //유저 아이디랑 일치하는지 확인
        CommentReview comments = new CommentReview();
        //있으면 삭제 없으면 에러 반환
        commentReviewRepository.deleteById(commentId);
    }

}