package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.VipRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VipRecommendRepository extends JpaRepository<VipRecommend, Long> {
}