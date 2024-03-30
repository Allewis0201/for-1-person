package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.CommentVip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentVipRepository extends JpaRepository<CommentVip, Long> {
}
