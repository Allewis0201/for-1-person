package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;

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
    private Boolean anonymous;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createdAt;

    @Builder
    public CommentReview(Review review, User user, String body, Boolean anonymous) {
        this.review = review;
        this.user = user;
        this.body = body;
        this.anonymous = anonymous;
    }

    public void update(String body, Boolean anonymous)
    {
        this.body = body;
        this.anonymous = anonymous;
    }
}
