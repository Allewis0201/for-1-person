package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewLikeRepository extends JpaRepository<ReviewLike, Long> {
    Optional<ReviewLike> findByReviewAndUser(Review review, User user);

    Optional<Integer> countArticleLikeByReview(Review review);
}
