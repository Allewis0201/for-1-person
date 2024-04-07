package com.estsoft.for1person.dto;


import com.estsoft.for1person.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentCommonViewResponse {
    private Long commentCommonId;
    private User user;
    private String body;
    private Boolean anonymous;
    private LocalDateTime createdAt;
}
