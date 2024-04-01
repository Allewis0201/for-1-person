package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.Article;
import com.estsoft.for1person.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;
    private Long views;
    private Boolean anonymous;
    private Integer need;

    @Builder
    public AddArticleRequest(String title, String content, Long views, Boolean anonymous, Integer need)
    {
        this.title = title;
        this.content = content;
        this.views = views;
        this.anonymous = anonymous;
        this.need = need;
    }

    public Article toEntity(User user) // 생성자를 사용해 객체 생성
    {
        return Article.builder()
                .title(title)
                .content(content)
                .views(views)
                .anonymous(anonymous)
                .need(need)
                .user(user)
                .build();
    }
}
