package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.ReviewRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRecommendRepository extends JpaRepository<ReviewRecommend, Long> {
}
