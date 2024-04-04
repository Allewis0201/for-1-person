package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VipRecommendRepository extends JpaRepository<VipRecommend, Long> {
    Optional<VipRecommend> findByCommentVipAndUser(CommentVip commentVip, User user);
}