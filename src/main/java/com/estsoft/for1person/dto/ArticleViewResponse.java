package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.User;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleViewResponse {
    private Long articleId;
    private String title;
    private String content;
    private Long views;
    private Boolean anonymous;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer need;
    private User user;

}
