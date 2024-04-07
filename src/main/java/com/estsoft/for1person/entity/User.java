package com.estsoft.for1person.entity;

import com.estsoft.for1person.dto.UserViewResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements UserDetails {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "author")
    private Integer author;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "status")
    private Boolean status;

    @Builder
    public User(String userId, String password, String nickname, Integer author, Timestamp createdAt, Boolean status) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.author = author == null ? 1: author; // 기본 디폴트 값은 '1'로 설정함
        this.createdAt = createdAt;
        this.status = status;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public String getPassword() {
        return password;
    }


    // 계정 만료 여부 반환 (true: 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        //사용자의 계정이 특정 날짜를 기준으로 만료된다면, 현 날짜와 비교해서 계정의 만료 여부 판단
        return true;
    }

    // 계정 잠금 여부 반환 (true: 잠금 안됨)
    @Override
    public boolean isAccountNonLocked() {
        //사용자가 로그인을 여러번 실패해서 계정이 잠겨있다면 false를 반환하여 로그인을 거부할 수 있음.
        return true;
    }

    // 패스워드의 만료 여부 반환 (true: 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        //사용자의 비밀번호를 일정 기간 지나서 변경햐야하는 정책이 있을 때,
        //비밀번호가 만료되었다면 사용자의 로그인을 거부할 수 있음.
        return true;
    }

    // 계정 사용 여부 반환 (true: 사용 가능)
    @Override
    public boolean isEnabled() {
        return true;
    }


    public UserViewResponse toViewResponse()
    {
        return UserViewResponse.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .author(author)
                .createdAt(createdAt)
                .status(status)
                .articleCount(0)
                .commentCount(0)
                .build();
    }

}
