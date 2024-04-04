package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.Article;

import java.time.LocalDateTime;

public class ArticleViewResponse {
    private Long articleId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long views;
    private Boolean anonymous;
    private String authorName;

    public ArticleViewResponse(){
    }

    public Long getArticleId() {
        return articleId;
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

    public ArticleViewResponse(Article article){
        this.articleId = article.getArticleId();
        this.title = article.getTitle();
        this.content = article.getContent();
        if (article.getCreatedAt() != null) {
            this.createdAt = article.getCreatedAt().toLocalDateTime();
        } else {
            this.createdAt = null;
        }
        this.views = article.getViews();
        this.anonymous = article.getAnonymous();
        this.createdAt = article.getCreatedAt().toLocalDateTime();
    }
}
