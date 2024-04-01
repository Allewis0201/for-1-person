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

    public CommentCommon getCommentCommon(long commentId) {
        return commentCommonRepository.findById(commentId).orElseThrow();
    }
    public CommentVip getCommentVip(long commentId) {
        return commentVipRepository.findById(commentId).orElseThrow();
    }
    public CommentReview getCommentReview(long commentId) {
        return commentReviewRepository.findById(commentId).orElseThrow();
    }

    //dto 대체
    public void createCommentCommon(long commentId) {
        CommentCommon comments = new CommentCommon();
        commentCommonRepository.save(comments);
    }
    public void createCommentVip(long commentId) {
        CommentVip comments = new CommentVip();
        commentVipRepository.save(comments);
    }
    public void createCommentReview(long commentId) {
        CommentReview comments = new CommentReview();
        commentReviewRepository.save(comments);
    }

    public void updateCommentCommon(long userId, long commentId) {
        CommentCommon comment = commentCommonRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 comment에 넣어서 변경
        // 후 저장
        commentCommonRepository.save(comment);
    }
    public void updateCommentReview(long userId, long commentId) {
        CommentVip comment = commentVipRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 comment에 넣어서 변경
        // 후 저장
        commentVipRepository.save(comment);
    }
    public void updateCommentVip(long userId, long commentId) {
        CommentReview comment = commentReviewRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 comment에 넣어서 변경
        // 후 저장
        commentReviewRepository.save(comment);
    }

    public void deleteCommonComment(long userId, long commentId) {
        //있는지 확인
        commentCommonRepository.findById(commentId);
        //유저 아이디랑 일치하는지 확인
        CommentCommon comments = new CommentCommon();
        //있으면 삭제 없으면 에러 반환
        commentCommonRepository.deleteById(commentId);
    }

    public void deleteReviewComment(long userId, long commentId) {
        //있는지 확인
        commentVipRepository.findById(commentId);
        //유저 아이디랑 일치하는지 확인
        CommentVip comments = new CommentVip();
        //있으면 삭제 없으면 에러 반환
        commentVipRepository.deleteById(commentId);
    }

    public void deleteVipComment(long userId, long commentId) {
        //있는지 확인
        commentReviewRepository.findById(commentId);
        //유저 아이디랑 일치하는지 확인
        CommentReview comments = new CommentReview();
        //있으면 삭제 없으면 에러 반환
        commentReviewRepository.deleteById(commentId);
    }

}
