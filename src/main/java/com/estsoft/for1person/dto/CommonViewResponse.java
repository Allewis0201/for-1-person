package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonViewResponse {

    private Long articleId; // 게시글 아이디 (PK)
    private String title; // 제목
    private String content; // 내용
    private Long views; // 조회수
    private Boolean anonymous; // 익명 여부
    private Timestamp createdAt; // 생성 날짜
    private Integer need; // 필요
    private User user; // 작성자 정보 (FK)
}
