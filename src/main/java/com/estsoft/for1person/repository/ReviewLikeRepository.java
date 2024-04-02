package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.ArticleLike;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.ReviewLike;
import com.estsoft.for1person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewLikeRepository extends JpaRepository<ReviewLike, Long> {
    Optional<ReviewLike> findByReviewAndUser(Review review, User user);
}
