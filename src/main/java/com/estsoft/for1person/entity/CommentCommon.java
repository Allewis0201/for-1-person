package com.estsoft.for1person.entity;

import com.estsoft.for1person.dto.CommentCommonViewResponse;
import com.estsoft.for1person.dto.CommonViewResponse;
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
import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;

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

    public CommentCommonViewResponse toViewResponse() // 생성자를 사용해 객체 생성
    {
        return CommentCommonViewResponse.builder()
                .commentCommonId(commentCommonId)
                .user(user)
                .body(body)
                .anonymous(anonymous)
                .createdAt(createdAt)
                .build();
    }
}
