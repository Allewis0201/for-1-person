package com.estsoft.for1person.service;

import com.estsoft.for1person.dto.AddArticleRequest;
import com.estsoft.for1person.dto.AddReviewRequest;
import com.estsoft.for1person.dto.AddVipRequest;
import com.estsoft.for1person.entity.*;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {

    private ArticleRepository articleRepository;
    private ReviewRepository reviewRepository;
    private VipRepository vipRepository;
    private UserRepository userRepository;

    private ArticleLikeRepository articleLikeRepository;
    private ReviewLikeRepository reviewLikeRepository;
    private VipLikeRepository vipLikeRepository;

    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }
    public List<Vip> getAllVip() {
        return vipRepository.findAll();
    }


    public Article getArticle(Long articleId) {
        return articleRepository.findById(articleId).orElseThrow();
    }
    public Review getReview(Long articleId) {
        return reviewRepository.findById(articleId).orElseThrow();
    }
    public Vip getVip(Long articleId) {
        return vipRepository.findById(articleId).orElseThrow();
    }

    public void createArticle(String userId, AddArticleRequest request) {
        User user = userRepository.findByUserId(userId).get();
        Article article = request.toEntity(user);
        articleRepository.save(article);
    }
    public void createReview(String userId, AddReviewRequest request) {
        User user = userRepository.findByUserId(userId).get();
        Review article = request.toEntity(user);
        reviewRepository.save(article);
    }
    public void createVip(String userId, AddVipRequest request) {
        User user = userRepository.findByUserId(userId).get();
        Vip article = request.toEntity(user);
        vipRepository.save(article);
    }

    @Transactional
    public void updateArticle(String userId, Long articleId, AddArticleRequest request) {
        Article article = articleRepository.findById(articleId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 article에 넣어서 변경

        if(userId.equals(article.getUser().getUserId()))
        {
            article.update(request.getTitle(),request.getContent(),request.getAnonymous());
        }
        // 후 저장

        //articleRepository.save(article);
    }

    @Transactional
    public void updateReview(String userId, Long reviewId, AddReviewRequest request) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 review에 넣어서 변경

        if(userId.equals(review.getUser().getUserId()))
        {
            review.update(request.getTitle(),request.getContent(),request.getAnonymous(), request.getScore());
        }

        // 후 저장
        //reviewRepository.save(review);
    }

    @Transactional
    public void updateVip(String userId, Long vipId, AddVipRequest request) { // Changed from Article to Vip, and parameter name from articleId to vipId
        Vip vip = vipRepository.findById(vipId).orElseThrow(NotFoundException::new); // Changed from Article to Vip
        //userId 맞는지 확인
        //맞으면 dto 내용을 vip에 넣어서 변경


        if(userId.equals(vip.getUser().getUserId()))
        {
            vip.update(request.getTitle(),request.getContent(),request.getAnonymous());
        }

        // 후 저장
        //vipRepository.save(vip); // Changed from article to vip
    }

    public void deleteArticle(String userId, Long articleId) {
        //계정이 있는지 확인
        Article article = articleRepository.findById(articleId).get();
        //유저 아이디랑 일치하는지 확인

        if(article.getUser().getUserId().equals(userId))
        {
            articleRepository.deleteById(articleId);
        }

        //있으면 삭제 없으면 에러 반환
    }

    public void deleteReview(String userId, Long reviewId) {
        //계정이 있는지 확인
        Review review = reviewRepository.findById(reviewId).get();
        //유저 아이디랑 일치하는지 확인
        if(review.getUser().getUserId().equals(userId))
        {
            reviewRepository.deleteById(reviewId);
        }
        //있으면 삭제 없으면 에러 반환
    }

    public void deleteVip(String userId, Long vipId) { // Changed from Article to Vip, and parameter name from articleId to vipId
        //계정이 있는지 확인
        Vip vip = vipRepository.findById(vipId).get();
        //유저 아이디랑 일치하는지 확인
        if(vip.getUser().getUserId().equals(userId))
        {
            vipRepository.deleteById(vipId);
        }
        //있으면 삭제 없으면 에러 반환
    }

    @Transactional
    public void likeArticle(String userId, Long articleId) {
        // 만약 articleLike 정보가 있으면 좋아요 한 상태임
        User user = userRepository.findByUserId(userId).orElseThrow(NotFoundException::new);
        Article article = articleRepository.findById(articleId).orElseThrow(NotFoundException::new);

        if(articleLikeRepository.findByArticleAndUser(article, user).isEmpty()){

            ArticleLike articleLike = ArticleLike.builder()
                    .user(user)
                    .article(article)
                    .build();

            articleLikeRepository.save(articleLike);
        }
        // 좋아요 한 정보가 있다면
        else {
            ArticleLike tmp = articleLikeRepository.findByArticleAndUser(article, user).get();
            articleLikeRepository.delete(tmp);
        }
    }
    @Transactional
    public void likeReview(String userId, Long reviewId) {
        // 만약 articleLike 정보가 있으면 좋아요 한 상태임
        User user = userRepository.findByUserId(userId).orElseThrow(NotFoundException::new);
        Review review = reviewRepository.findById(reviewId).orElseThrow(NotFoundException::new);

        if(reviewLikeRepository.findByReviewAndUser(review, user).isEmpty()){

            ReviewLike reviewLike = ReviewLike.builder()
                    .user(user)
                    .review(review)
                    .build();

            reviewLikeRepository.save(reviewLike);
        }
        // 좋아요 한 정보가 있다면
        else {
            ReviewLike tmp = reviewLikeRepository.findByReviewAndUser(review, user).get();
            reviewLikeRepository.delete(tmp);
        }
    }
    @Transactional
    public void likeVip(String userId, Long vipId) {
        // 만약 articleLike 정보가 있으면 좋아요 한 상태임
        User user = userRepository.findByUserId(userId).orElseThrow(NotFoundException::new);
        Vip vip = vipRepository.findById(vipId).orElseThrow(NotFoundException::new);

        if(vipLikeRepository.findByVipAndUser(vip, user).isEmpty()){

            VipLike vipLike = VipLike.builder()
                    .user(user)
                    .vip(vip)
                    .build();

            vipLikeRepository.save(vipLike);
        }
        // 좋아요 한 정보가 있다면
        else {
            VipLike tmp = vipLikeRepository.findByVipAndUser(vip, user).get();
            vipLikeRepository.delete(tmp);
        }
    }
    public Article findArticleId(Long articleId) {
        return articleRepository.findById(articleId).orElseThrow(() ->
                new RuntimeException("Article not found with id: " + articleId));
    }

    public Review findReviewId(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() ->
                new RuntimeException("Review not found with id: " + reviewId));
    }
}
