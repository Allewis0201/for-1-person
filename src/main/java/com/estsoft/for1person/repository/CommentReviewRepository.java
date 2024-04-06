package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.CommentReview;
import com.estsoft.for1person.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentReviewRepository extends JpaRepository<CommentReview, Long> {

    List<CommentReview> findAllByReview(Review review);

    void deleteAllByReview(Review review);
}
