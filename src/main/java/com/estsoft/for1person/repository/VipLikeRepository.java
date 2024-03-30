package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.VipLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VipLikeRepository extends JpaRepository<VipLike, Long> {
}
