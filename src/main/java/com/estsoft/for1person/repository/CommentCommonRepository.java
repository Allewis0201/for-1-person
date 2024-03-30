package com.estsoft.for1person.repository;
import com.estsoft.for1person.entity.CommentCommon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentCommonRepository extends JpaRepository<CommentCommon, Long> {
}