package com.estsoft.for1person.repository;

import com.estsoft.for1person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId);
    Optional<User> findByNickname(String nickname);
    boolean existsByUserId(String userId);
    boolean existsByNickname(String nickname);
    @Query("SELECT COUNT(user) FROM User user")
    Long countAllUsers();
}
