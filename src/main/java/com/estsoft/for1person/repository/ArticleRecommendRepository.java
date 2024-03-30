package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.ArticleRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRecommendRepository extends JpaRepository<ArticleRecommend, Long> {
}