package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.CommentReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentReviewRepository extends JpaRepository<CommentReview, Long> {

    List<CommentReview> findAllByCommentReviewId(Long articleId);
}
