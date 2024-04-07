package com.estsoft.for1person.entity;

import com.estsoft.for1person.dto.CommentCommonViewResponse;
import com.estsoft.for1person.dto.CommentReviewViewResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentReviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_writer_id")
    private Review review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_writer_id")
    private User user;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean anonymous;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public CommentReview(Review review, User user, String body, Boolean anonymous) {
        this.review = review;
        this.user = user;
        this.body = body;
        this.anonymous = false;
    }

    public void update(String body, Boolean anonymous)
    {
        this.body = body;
        this.anonymous = false;
    }


    public CommentReviewViewResponse toViewResponse() // 생성자를 사용해 객체 생성
    {
        return CommentReviewViewResponse.builder()
                .commentReviewId(commentReviewId)
                .user(user)
                .body(body)
                .anonymous(anonymous)
                .createdAt(createdAt)
                .build();
    }
}
