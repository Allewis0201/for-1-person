package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReviewViewResponse {

    private Long reviewId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long views;
    private Boolean anonymous;
    private String authorName;
    private Integer need;
    private Integer score;

    public ReviewViewResponse(){
    }

    public Long getReviewId() {
        return reviewId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public ReviewViewResponse(Review review){
        this.reviewId = review.getReviewId();
        this.title = review.getTitle();
        this.content = review.getContent();
        if (review.getCreatedAt() != null) {
            this.createdAt = review.getCreatedAt().toLocalDateTime();
        } else {
            this.createdAt = null;
        }
        this.views = review.getViews();
        this.anonymous = review.getAnonymous();
        this.createdAt = review.getCreatedAt().toLocalDateTime();
    }
}
