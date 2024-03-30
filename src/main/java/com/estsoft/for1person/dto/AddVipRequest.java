package com.estsoft.for1person.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddVipRequest {
    private String title;
    private String content;
    private Long view;
    private Boolean anonymous;
    private Integer need;
}
