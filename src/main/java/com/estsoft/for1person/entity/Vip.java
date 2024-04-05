package com.estsoft.for1person.entity;

import com.estsoft.for1person.dto.CommonViewResponse;
import com.estsoft.for1person.dto.VipViewResponse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;

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

    public VipViewResponse toViewResponse() // 생성자를 사용해 객체 생성
    {
        return VipViewResponse.builder()
                .VipId(VipId)
                .title(title)
                .content(content)
                .views(views)
                .anonymous(anonymous)
                .createdAt(createdAt)
                .need(need)
                .user(user)
                .build();
    }
}


