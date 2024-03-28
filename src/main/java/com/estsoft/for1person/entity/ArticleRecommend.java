package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ArticleRecommend {

    @Id
    @Column(name = "article_id", nullable = false)
    private Long articleId;

    @Id
    @Column(name = "article_writer_id", nullable = false)
    private String articleWriterId;

    @ManyToOne
    @JoinColumn(name = "article_writer_id", insertable = false, updatable = false)
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users users;

}

