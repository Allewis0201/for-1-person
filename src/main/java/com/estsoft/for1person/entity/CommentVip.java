package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

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
    private Users users;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private boolean anonymous;

    @Column(nullable = false)
    private Time createdAt;
}
