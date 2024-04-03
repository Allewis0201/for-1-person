package com.estsoft.for1person.service;

import com.estsoft.for1person.entity.*;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private UserRepository userRepository;
    private ArticleRecommendRepository articleRecommendRepository;
    private ReviewRecommendRepository reviewRecommendRepository;
    private VipRecommendRepository vipRecommendRepository;
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

    @Transactional
    public void recommendArticle(String userId, Long commentCommonId) {
        // 만약 articleLike 정보가 있으면 좋아요 한 상태임
        User user = userRepository.findByUserId(userId).orElseThrow(NotFoundException::new);
        CommentCommon comment = commentCommonRepository.findById(commentCommonId).orElseThrow(NotFoundException::new);

        if(articleRecommendRepository.findByCommentCommonAndUser(comment, user).isEmpty()){

            ArticleRecommend articleRecommend = ArticleRecommend.builder()
                    .commentCommon(comment)
                    .user(user)
                    .build();

            articleRecommendRepository.save(articleRecommend);
        }

        // 좋아요 한 정보가 있다면
        else {
            ArticleRecommend tmp = articleRecommendRepository.findByCommentCommonAndUser(comment, user).get();
            articleRecommendRepository.delete(tmp);
        }

    }
    @Transactional
    public void recommendReview(String userId, Long commentReviewId) {
        // 만약 articleLike 정보가 있으면 좋아요 한 상태임
        User user = userRepository.findByUserId(userId).orElseThrow(NotFoundException::new);
        CommentReview comment = commentReviewRepository.findById(commentReviewId).orElseThrow(NotFoundException::new);

        if(reviewRecommendRepository.findByCommentReviewAndUser(comment, user).isEmpty()){

            ReviewRecommend reviewRecommend = ReviewRecommend.builder()
                    .commentReview(comment)
                    .user(user)
                    .build();

            reviewRecommendRepository.save(reviewRecommend);
        }

        // 좋아요 한 정보가 있다면
        else {
            ReviewRecommend tmp = reviewRecommendRepository.findByCommentReviewAndUser(comment, user).get();
            reviewRecommendRepository.delete(tmp);
        }

    }

    @Transactional
    public void recommendVip(String userId, Long commentVipId) {
        // 만약 articleLike 정보가 있으면 좋아요 한 상태임
        User user = userRepository.findByUserId(userId).orElseThrow(NotFoundException::new);
        CommentVip comment = commentVipRepository.findById(commentVipId).orElseThrow(NotFoundException::new);

        if(vipRecommendRepository.findByCommentVipAndUser(comment, user).isEmpty()){

            VipRecommend vipRecommend = VipRecommend.builder()
                    .commentVip(comment)
                    .user(user)
                    .build();

            vipRecommendRepository.save(vipRecommend);
        }

        // 좋아요 한 정보가 있다면
        else {
            VipRecommend tmp = vipRecommendRepository.findByCommentVipAndUser(comment, user).get();
            vipRecommendRepository.delete(tmp);
        }

    }

}