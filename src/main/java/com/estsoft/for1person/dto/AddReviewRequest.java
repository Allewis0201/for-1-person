package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class AddReviewRequest {
    private String title;
    private String content;
    private Long views;
    private Boolean anonymous;
    private Integer need;
    private Integer score;

    @Builder
    public AddReviewRequest(String title, String content, Long views, Boolean anonymous, Integer need,Integer score)
    {
        this.title = title;
        this.content = content;
        this.views = views;
        this.anonymous = anonymous;
        this.need = need;
        this.score = score;
    }

    public Review toEntity(User user) // 생성자를 사용해 객체 생성
    {
        return Review.builder()
                .title(title)
                .content(content)
                .views(views)
                .anonymous(anonymous)
                .need(need)
                .user(user)
                .score(score)
                .build();
    }
}
