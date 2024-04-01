package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CommentVip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentVipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vip_writer_id")
    private Vip vip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_writer_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean anonymous;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp createdAt;

    @Builder
    public CommentVip(Vip vip, User user, String body, Boolean anonymous) {
        this.vip = vip;
        this.user = user;
        this.body = body;
        this.anonymous = anonymous;
    }
}
