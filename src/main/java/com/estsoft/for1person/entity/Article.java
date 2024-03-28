package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long articleId; // 게시글 아이디 (PK)

    @Column(nullable = false)
    private String title; // 제목

    @Column(nullable = false)
    private String content; // 내용

    @Column(nullable = false)
    private long views; // 조회수

    @Column(nullable = false)
    private Boolean anonymous; // 익명 여부

    @Column(nullable = false)
    private Timestamp createdAt; // 생성 날짜

    @Column(nullable = false)
    private int need; // 필요

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_writer_id")
    private User user; // 작성자 정보 (FK)

}


