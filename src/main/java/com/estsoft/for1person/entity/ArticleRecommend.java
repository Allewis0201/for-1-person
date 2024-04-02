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
public class ArticleRecommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleRecommendId;

    @ManyToOne
    @JoinColumn(name = "comment_common_id", insertable = false, updatable = false)
    private CommentCommon commentCommon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Builder
    public ArticleRecommend(User user, CommentCommon commentCommon){
        this.user = user;
        this.commentCommon = commentCommon;
    }

}

