package com.estsoft.for1person.repository;
import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.CommentCommon;
import com.estsoft.for1person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentCommonRepository extends JpaRepository<CommentCommon, Long> {
    List<CommentCommon> findAllByArticle(Article article);

    void deleteAllByArticle(Article article);

    Optional<Integer> countCommentCommonByArticle(Article article);

    Integer countCommentCommonByUser(User user);
}