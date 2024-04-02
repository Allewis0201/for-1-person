package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.ArticleLike;
import com.estsoft.for1person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleLikeRepository extends JpaRepository<ArticleLike, Long> {
    Optional<ArticleLike> findByArticleAndUser(Article article, User user);
}
