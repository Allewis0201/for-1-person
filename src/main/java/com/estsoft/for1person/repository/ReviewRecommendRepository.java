package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRecommendRepository extends JpaRepository<ReviewRecommend, Long> {
    Optional<ReviewRecommend> findByCommentReviewAndUser(CommentReview commentReview, User user);

    Optional<Integer> countReviewRecommendByCommentReview(CommentReview commentReview);
}
