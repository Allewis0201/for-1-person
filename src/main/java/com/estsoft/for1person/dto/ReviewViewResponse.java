package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.Review;
import com.estsoft.for1person.entity.User;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewViewResponse {

    private Long reviewId;
    private String title;
    private String content;
    private Long views;
    private Boolean anonymous;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer need;
    private Integer score;
    private User user;
}
