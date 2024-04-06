package com.estsoft.for1person.dto;

import com.estsoft.for1person.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VipViewResponse {
    private Long VipId;
    private String title;
    private String content;
    private Long views;
    private Boolean anonymous;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer need;
    private User user;

}
