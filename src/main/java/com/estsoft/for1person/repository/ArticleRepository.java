package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}
