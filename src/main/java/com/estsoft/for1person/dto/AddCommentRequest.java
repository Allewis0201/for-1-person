package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AddCommentRequest {
    private String body;
    private Boolean anonymous;

    @Builder
    public AddCommentRequest(String body, Boolean anonymous)
    {
        this.body = body;
        this.anonymous = anonymous;
    }

    public CommentCommon toCommonEntity(User user, Article article)
    {
        return CommentCommon.builder()
                .user(user)
                .article(article)
                .body(body)
                .anonymous(anonymous)
                .build();
    }

    public CommentReview toReviewEntity(User user, Review review)
    {
        return CommentReview.builder()
                .user(user)
                .review(review)
                .body(body)
                .anonymous(anonymous)
                .build();
    }

    public CommentVip toVipEntity(User user, Vip vip)
    {
        return CommentVip.builder()
                .user(user)
                .vip(vip)
                .body(body)
                .anonymous(anonymous)
                .build();
    }
}
