package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vip {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VipId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 100000)
    private String content;

    @Column(nullable = false)
    private Long views;

    @Column(nullable = false)
    private Boolean anonymous;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Integer need;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_writer_id")
    private User user;

    @Builder
    public Vip(String title,String content, Long views,Boolean anonymous,Integer need,User user)
    {
        this.title = title;
        this.content = content;
        this.views = views;
        this.anonymous = anonymous;
        this.need = need;
        this.user = user;
    }

    public void update(String title, String content, Boolean anonymous)
    {
        this.title = title;
        this.content = content;
        this.anonymous = anonymous;
    }
}


