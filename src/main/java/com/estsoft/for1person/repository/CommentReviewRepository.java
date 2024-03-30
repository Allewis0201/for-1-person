package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.CommentReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentReviewRepository extends JpaRepository<CommentReview, Long> {
}
