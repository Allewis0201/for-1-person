package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.CommentVip;
import com.estsoft.for1person.entity.Vip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentVipRepository extends JpaRepository<CommentVip, Long> {

    List<CommentVip> findAllByVip(Vip vip);

    void deleteAllByVip(Vip vip);
}
