package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.User;
import com.estsoft.for1person.entity.Vip;
import com.estsoft.for1person.entity.VipLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VipLikeRepository extends JpaRepository<VipLike, Long> {
    Optional<VipLike> findByVipAndUser(Vip vip, User user);

    Optional<Integer> countArticleLikeByVip(Vip vip);

    void deleteAllByVip(Vip vip);
}
