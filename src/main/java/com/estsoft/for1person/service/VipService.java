package com.estsoft.for1person.service;

import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.exception.NotFoundException;
import com.estsoft.for1person.repository.ReviewRepository;
import com.estsoft.for1person.repository.VipRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class VipService {

    private VipRepository vipRepository; // Changed from ArticleRepository to VipRepository
    private ReviewRepository reviewRepository;

    public VipService(VipRepository vipRepository, ReviewRepository reviewRepository) {
        this.vipRepository = vipRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Vip> getAllVip() { // Changed from Article to Vip
        return vipRepository.findAll();
    }

    public Vip getVip(long vipId) { // Changed from Article to Vip, and parameter name from articleId to vipId
        return vipRepository.findById(vipId).orElseThrow();
    }

    public void createVip(long userId) { // Changed from Article to Vip
        Vip vip = new Vip(); // Changed from Article to Vip
        vipRepository.save(vip); // Changed from article to vip
    }

    public void updateVip(long userId, long vipId) { // Changed from Article to Vip, and parameter name from articleId to vipId
        Vip vip = vipRepository.findById(vipId).orElseThrow(NotFoundException::new); // Changed from Article to Vip
        //userId 맞는지 확인
        //맞으면 dto 내용을 vip에 넣어서 변경
        // 후 저장
        vipRepository.save(vip); // Changed from article to vip
    }

    public void deleteVip(long userId, long vipId) { // Changed from Article to Vip, and parameter name from articleId to vipId
        //계정이 있는지 확인
        vipRepository.findById(vipId);
        //유저 아이디랑 일치하는지 확인
        Vip vip = new Vip(); // Changed from Article to Vip
        //있으면 삭제 없으면 에러 반환
        vipRepository.deleteById(vipId); // Changed from article to vip
    }
}
