package com.estsoft.for1person.service;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.ArticleRepository;
import com.estsoft.for1person.repository.ReviewRepository;
import com.estsoft.for1person.repository.VipRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService {

    private ArticleRepository articleRepository;
    private ReviewRepository reviewRepository;
    private VipRepository vipRepository;


    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }
    public List<Vip> getAllVip() {
        return vipRepository.findAll();
    }


    public Article getArticle(long articleId) {
        return articleRepository.findById(articleId).orElseThrow();
    }
    public Review getReview(long articleId) {
        return reviewRepository.findById(articleId).orElseThrow();
    }
    public Vip getVip(long articleId) {
        return vipRepository.findById(articleId).orElseThrow();
    }

    public void createArticle(long userId) {
        Article article = new Article();
        articleRepository.save(article);
    }
    public void createReview(long userId) {
        Review article = new Review();
        reviewRepository.save(article);
    }
    public void createVip(long userId) {
        Vip article = new Vip();
        vipRepository.save(article);
    }

    public void updateArticle(long userId, long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 article에 넣어서 변경
        // 후 저장
        articleRepository.save(article);
    }

    public void deleteArticle(long userId, long articleId) {
        //계정이 있는지 확인
        articleRepository.findById(articleId);
        //유저 아이디랑 일치하는지 확인
        Article articles = new Article();
        //있으면 삭제 없으면 에러 반환
        articleRepository.deleteById(articleId);
    }
}
