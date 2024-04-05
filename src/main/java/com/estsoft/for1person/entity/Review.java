package com.estsoft.for1person.entity;

import com.estsoft.for1person.dto.CommonViewResponse;
import com.estsoft.for1person.dto.ReviewViewResponse;
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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, length = 100000)
    private Long views;

    @Column(nullable = false)
    private Boolean anonymous;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Integer need;

    @Column(nullable = false)
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "review_writer_id")
    private User user;

    @Builder
    public Review(String title,String content, Long views,Boolean anonymous,Integer need,User user, Integer score)
    {
        this.title = title;
        this.content = content;
        this.views = views;
        this.anonymous = anonymous;
        this.need = need;
        this.user = user;
        this.score = score;
    }

    public void update(String title, String content, Boolean anonymous, Integer score)
    {
        this.title = title;
        this.content = content;
        this.anonymous = anonymous;
        this.score = score;
    }

    public ReviewViewResponse toViewResponse() // 생성자를 사용해 객체 생성
    {
        return ReviewViewResponse.builder()
                .reviewId(reviewId)
                .title(title)
                .content(content)
                .views(views)
                .anonymous(anonymous)
                .createdAt(createdAt)
                .need(need)
                .user(user)
                .score(score)
                .build();
    }
}
