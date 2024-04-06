package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.User;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserViewResponse {

    private String userId; // 게시글 아이디 (PK)
    private String password; // 제목
    private String nickname; // 내용
    private Integer author;
    private Timestamp createdAt;
    private Boolean status;
    private Integer articleCount;
    private Integer commentCount;

}
