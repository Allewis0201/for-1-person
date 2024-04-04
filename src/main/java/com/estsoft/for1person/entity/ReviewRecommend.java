package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ReviewRecommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewRecommendId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_review_id", insertable = false, updatable = false)
    private CommentReview commentReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Builder
    public ReviewRecommend(CommentReview commentReview, User user){
        this.commentReview = commentReview;
        this.user = user;
    }
}