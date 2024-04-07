package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.CommentVip;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.entity.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentVipRepository extends JpaRepository<CommentVip, Long> {

    List<CommentVip> findAllByVip(Vip vip);

    void deleteAllByVip(Vip vip);

    Optional<Integer> countCommentVipByVip(Vip vip);

    Integer countCommentVipByUser(User user);
}
