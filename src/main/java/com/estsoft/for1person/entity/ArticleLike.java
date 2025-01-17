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
public class ArticleLike{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long articleLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @Builder
    public ArticleLike(User user, Article article){
        this.user = user;
        this.article = article;
    }
}

