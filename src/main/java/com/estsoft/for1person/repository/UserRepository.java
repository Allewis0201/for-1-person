package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId);
    boolean existsByUserId(String userId);
    boolean existsByNickname(String nickname);
}
