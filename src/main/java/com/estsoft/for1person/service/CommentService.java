package com.estsoft.for1person.service;


import com.estsoft.for1person.dto.AddCommentRequest;
import com.estsoft.for1person.dto.UserViewResponse;
import com.estsoft.for1person.entity.*;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private UserRepository userRepository;
    private ArticleRecommendRepository articleRecommendRepository;
    private ReviewRecommendRepository reviewRecommendRepository;
    private VipRecommendRepository vipRecommendRepository;
    private CommentCommonRepository commentCommonRepository;
    private CommentVipRepository commentVipRepository;
    private CommentReviewRepository commentReviewRepository;
    private ArticleRepository articleRepository;
    private ReviewRepository reviewRepository;
    private VipRepository vipRepository;

    public CommentService(UserRepository userRepository, ArticleRecommendRepository articleRecommendRepository, ReviewRecommendRepository reviewRecommendRepository, VipRecommendRepository vipRecommendRepository, CommentCommonRepository commentCommonRepository, CommentVipRepository commentVipRepository, CommentReviewRepository commentReviewRepository, ArticleRepository articleRepository, ReviewRepository reviewRepository, VipRepository vipRepository) {
        this.userRepository = userRepository;
        this.articleRecommendRepository = articleRecommendRepository;
        this.reviewRecommendRepository = reviewRecommendRepository;
        this.vipRecommendRepository = vipRecommendRepository;
        this.commentCommonRepository = commentCommonRepository;
        this.commentVipRepository = commentVipRepository;
        this.commentReviewRepository = commentReviewRepository;
        this.articleRepository = articleRepository;
        this.reviewRepository = reviewRepository;
        this.vipRepository = vipRepository;
    }

    //============================================================================================================
    // 모든 댓글을 반환하는 기능 (일반, 리뷰, VIP)
    public List<CommentCommon> getAllCommentCommon() {
        return commentCommonRepository.findAll();
    }
    public List<CommentVip> getAllCommentVip() {
        return commentVipRepository.findAll();
    }
    public List<CommentReview> getAllCommentReview() {
        return commentReviewRepository.findAll();
    }


    //============================================================================================================
    // 특정 게시글에 적힌 모든 댓글을 반환하는 기능 (일반, 리뷰, VIP)
    public List<CommentCommon> getArticleCommonComment(Long articleId) {

        Article article = articleRepository.findById(articleId).get();

        return commentCommonRepository.findAllByArticle(article);
    }

    public List<CommentVip> getArticleVipComment(Long articleId) {

        Vip vip = vipRepository.findById(articleId).get();

        return commentVipRepository.findAllByVip(vip);
    }

    public List<CommentReview> getArticleReviewComment(Long articleId) {

        Review review = reviewRepository.findById(articleId).get();

        return commentReviewRepository.findAllByReview(review);
    }

    //============================================================================================================
    // 특정 댓글을 반환하는 기능 (일반, 리뷰, VIP)

    public CommentCommon getCommentCommon(Long commentId) {
        return commentCommonRepository.findById(commentId).orElseThrow();
    }
    public CommentVip getCommentVip(Long commentId) {
        return commentVipRepository.findById(commentId).orElseThrow();
    }

    public CommentReview getCommentReview(Long commentId) {
        return commentReviewRepository.findById(commentId).orElseThrow();
    }

    //============================================================================================================
    // 댓글을 생성하는 기능 (일반, 리뷰, VIP)
    
    public void createCommentCommon(String userId, Long articleId, AddCommentRequest request) {
        User user = userRepository.findByUserId(userId).get();
        Article article = articleRepository.findById(articleId).get();

        CommentCommon commentCommon = request.toCommonEntity(user,article);
        commentCommonRepository.save(commentCommon);
    }
    public void createCommentVip(String userId, Long articleId, AddCommentRequest request) {
        
        User user = userRepository.findByUserId(userId).get();
        Vip vip = vipRepository.findById(articleId).get();

        CommentVip commentVip = request.toVipEntity(user,vip);
        commentVipRepository.save(commentVip);

    }
    public void createCommentReview(String userId, Long articleId, AddCommentRequest request) {


        User user = userRepository.findByUserId(userId).get();
        Review review = reviewRepository.findById(articleId).get();

        CommentReview commentReview = request.toReviewEntity(user,review);
        commentReviewRepository.save(commentReview);

    }
    
    //============================================================================================================
    // 댓글을 수정하는 기능 (일반, 리뷰, VIP) (기능 작성은 했으나 시간 부족으로 적용하진 못했음)

    @Transactional
    public void updateCommentCommon(String userId, Long articleId, Long commentId, AddCommentRequest request) {
        CommentCommon commentCommon = commentCommonRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        if(commentCommon.getUser().getUserId().equals(userId))
        {
            //맞으면 dto 내용을 comment에 넣어서 변경
            commentCommon.update(request.getBody(),request.getAnonymous());
            commentCommonRepository.save(commentCommon);

        }
    }
    @Transactional
    public void updateCommentReview(String userId, Long articleId, Long commentId, AddCommentRequest request) {
        CommentVip commentVip = commentVipRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        if(commentVip.getUser().getUserId().equals(userId))
        {
            //맞으면 dto 내용을 comment에 넣어서 변경
            commentVip.update(request.getBody(),request.getAnonymous());

        }

    }
    @Transactional
    public void updateCommentVip(String userId, Long articleId, Long commentId, AddCommentRequest request) {
        CommentReview commentReview = commentReviewRepository.findById(commentId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        if(commentReview.getUser().getUserId().equals(userId))
        {
            //맞으면 dto 내용을 comment에 넣어서 변경
            commentReview.update(request.getBody(),request.getAnonymous());

        }
    }

    //============================================================================================================
    // 댓글을 삭제하는 기능 (일반, 리뷰, VIP)

    public void deleteCommonComment(String userId, Long commentId) {
        //있는지 확인
        CommentCommon commentCommon = commentCommonRepository.findById(commentId).get();
        //유저 아이디랑 일치하는지 확인
        if(commentCommon.getUser().getUserId().equals(userId))
        {
            commentCommonRepository.deleteById(commentId);
        }
        //있으면 삭제 없으면 에러 반환
    }

    public void deleteReviewComment(String userId, Long commentId) {
        //있는지 확인
        CommentReview commentReview = commentReviewRepository.findById(commentId).get();
        //유저 아이디랑 일치하는지 확인
        if(commentReview.getUser().getUserId().equals(userId))
        {
            commentReviewRepository.deleteById(commentId);
        }
        //있으면 삭제 없으면 에러 반환
    }

    public void deleteVipComment(String userId, Long commentId) {
        //있는지 확인
        CommentVip commentVip = commentVipRepository.findById(commentId).get();
        //유저 아이디랑 일치하는지 확인
        if(commentVip.getUser().getUserId().equals(userId))
        {
            commentVipRepository.deleteById(commentId);
        }
        //있으면 삭제 없으면 에러 반환
    }

    //============================================================================================================
    // 특정 게시글의 댓글을 모두 삭제하는 기능 (일반, 리뷰, VIP)

    public void deleteAllArticleComment(Long articleId)
    {
        Article article = articleRepository.findById(articleId).get();

        commentCommonRepository.deleteAllByArticle(article);
    }

    public void deleteAllReviewComment(Long reviewId)
    {
        Review review = reviewRepository.findById(reviewId).get();

        commentReviewRepository.deleteAllByReview(review);
    }

    public void deleteAllVipComment(Long vipId)
    {
        Vip vip = vipRepository.findById(vipId).get();

        commentVipRepository.deleteAllByVip(vip);
    }

    //============================================================================================================
    // 댓글 추천 기능 (일반, 리뷰, VIP) (기능 작성은 했으나 시간 부족으로 적용하진 못했음)
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

    //============================================================================================================
    // 댓글 추천 수 반환 기능 (일반, 리뷰, VIP) (기능 작성은 했으나 시간 부족으로 적용하진 못했음)

    @Transactional
    public Optional<Integer> getRecommendArticle(Long commentCommonId)
    {
        CommentCommon commentCommon = commentCommonRepository.findById(commentCommonId).get();

        return articleRecommendRepository.countArticleRecommendByCommentCommon(commentCommon);
    }

    @Transactional
    public Optional<Integer> getRecommendReview(Long commentReviewId)
    {
        CommentReview commentReview = commentReviewRepository.findById(commentReviewId).get();

        return reviewRecommendRepository.countReviewRecommendByCommentReview(commentReview);
    }


    @Transactional
    public Optional<Integer> getRecommendVip(Long commentVipId)
    {
        CommentVip commentVip = commentVipRepository.findById(commentVipId).get();

        return vipRecommendRepository.countVipRecommendByCommentVip(commentVip);
    }


    //============================================================================================================
    // 게시글에 달린 댓글 수 반환 (일반, 리뷰, VIP)

    public Optional<Integer> getCommentCommonCount(Long articleId) {

        Article article = articleRepository.findById(articleId).get();

        return commentCommonRepository.countCommentCommonByArticle(article);
    }

    public Optional<Integer> getCommentReviewCount(Long articleId) {

        Review review = reviewRepository.findById(articleId).get();

        return commentReviewRepository.countCommentReviewByReview(review);
    }

    public Optional<Integer> getCommentVipCount(Long articleId) {
        Vip vip = vipRepository.findById(articleId).get();

        return commentVipRepository.countCommentVipByVip(vip);
    }

    //============================================================================================================
    // 유저가 지금까지 작성한 댓글 수 반환 (일반, 리뷰, VIP)

    public List<UserViewResponse> getAllCommentByUserId(List<UserViewResponse> users) {
        for(UserViewResponse user : users)
        {
            User tmp = userRepository.findByUserId(user.getUserId()).get();
            Integer count = commentCommonRepository.countCommentCommonByUser(tmp) + commentReviewRepository.countCommentReviewByUser(tmp) + commentVipRepository.countCommentVipByUser(tmp);
            user.setCommentCount(count);
        }
        return users;
    }

    //============================================================================================================
}