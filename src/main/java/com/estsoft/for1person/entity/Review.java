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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

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

    @ManyToOne
    @JoinColumn(name = "review_writer_id")
    private User user;
}
