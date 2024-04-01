package com.estsoft.for1person.service;

import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.ReviewRepository;
import com.estsoft.for1person.repository.VipRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;
    private VipRepository vipRepository;


    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }
    public List<Vip> getAllVip() {
        return vipRepository.findAll();
    }


    public Review getReview(long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow();
    }
    public Vip getVip(long reviewId) {
        return vipRepository.findById(reviewId).orElseThrow();
    }

    public void createReview(long userId) {
        Review review = new Review();
        reviewRepository.save(review);
    }
    public void createVip(long userId) {
        Vip vip = new Vip();
        vipRepository.save(vip);
    }

    public void updateReview(long userId, long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(NotFoundException::new);
        //userId 맞는지 확인
        //맞으면 dto 내용을 review에 넣어서 변경
        // 후 저장
        reviewRepository.save(review);
    }

    public void deleteReview(long userId, long reviewId) {
        //계정이 있는지 확인
        reviewRepository.findById(reviewId);
        //유저 아이디랑 일치하는지 확인
        Review review = new Review();
        //있으면 삭제 없으면 에러 반환
        reviewRepository.deleteById(reviewId);
    }
}
