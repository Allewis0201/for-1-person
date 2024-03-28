package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentReviewId;

    @ManyToOne
    @JoinColumn(name = "review_writer_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "comment_writer_id")
    private User user;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private boolean anonymous;

    @Column(nullable = false)
    private Time createdAt;
}
