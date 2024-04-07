package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.CommentReview;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentReviewRepository extends JpaRepository<CommentReview, Long> {

    List<CommentReview> findAllByReview(Review review);

    void deleteAllByReview(Review review);

    Optional<Integer> countCommentReviewByReview(Review review);

    Integer countCommentReviewByUser(User user);
}
