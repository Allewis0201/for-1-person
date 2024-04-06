package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.ArticleRecommend;
import com.estsoft.for1person.entity.CommentCommon;
import com.estsoft.for1person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRecommendRepository extends JpaRepository<ArticleRecommend, Long> {
    Optional<ArticleRecommend> findByCommentCommonAndUser(CommentCommon commentCommon, User user);

    Optional<Integer> countArticleRecommendByCommentCommon(CommentCommon commentCommon);
}