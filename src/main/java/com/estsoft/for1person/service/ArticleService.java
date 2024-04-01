package com.estsoft.for1person.service;

import com.estsoft.for1person.dto.AddArticleRequest;
import com.estsoft.for1person.dto.AddReviewRequest;
import com.estsoft.for1person.dto.AddVipRequest;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.ArticleRepository;
import com.estsoft.for1person.repository.ReviewRepository;
import com.estsoft.for1person.repository.UserRepository;
import com.estsoft.for1person.repository.VipRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
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
}
