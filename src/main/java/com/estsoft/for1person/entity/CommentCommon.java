package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.sql.Time;

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
    private Users users;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private boolean anonymous;

    @Column(nullable = false)
    private Time createdAt;

}
