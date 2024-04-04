package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentCommonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_writer_id")
    private User user;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean anonymous;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createdAt;

    @Builder
    public CommentCommon(Article article, User user, String body, Boolean anonymous) {
        this.article = article;
        this.user = user;
        this.body = body;
        this.anonymous = anonymous;
    }

    public void update(String body, Boolean anonymous)
    {
        this.body = body;
        this.anonymous = anonymous;
    }
}
