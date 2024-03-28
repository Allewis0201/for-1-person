package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VipLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vipLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vip_id")
    private Vip vip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
}

