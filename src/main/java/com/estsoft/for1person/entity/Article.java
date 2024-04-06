package com.estsoft.for1person.entity;

import com.estsoft.for1person.dto.CommonViewResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId; // 게시글 아이디 (PK)

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false, length = 100000)
    private String content; // 내용

    @Column(nullable = false)
    private Long views; // 조회수

    @Column(nullable = false)
    private Boolean anonymous; // 익명 여부

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt; // 생성 날짜

    @Column(nullable = false)
    private Integer need; // 필요

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_writer_id")
    private User user; // 작성자 정보 (FK)

    @Builder
    public Article(String title,String content, Long views,Boolean anonymous,Integer need,User user)
    {
        this.title = title;
        this.content = content;
        this.views = views;
        this.anonymous = false;
        this.need = need;
        this.user = user;
    }

    public void update(String title, String content, Boolean anonymous)
    {
        this.title = title;
        this.content = content;
        this.anonymous = false;
    }

    public CommonViewResponse toViewResponse() // 생성자를 사용해 객체 생성
    {
        return CommonViewResponse.builder()
                .articleId(articleId)
                .title(title)
                .content(content)
                .views(views)
                .anonymous(anonymous)
                .createdAt(createdAt)
                .need(need)
                .user(user)
                .build();
    }
}


