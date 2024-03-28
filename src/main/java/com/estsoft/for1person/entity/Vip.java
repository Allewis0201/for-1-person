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
public class Vip {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VipId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long views;

    @Column(nullable = false)
    private Boolean anonymous;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Integer need;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_writer_id")
    private User user;
}


