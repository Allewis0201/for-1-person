package com.estsoft.for1person.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class VipRecommend {

    @Id
    @Column(name = "vip_id", nullable = false)
    private Long vipId;

    @Id
    @Column(name = "vip_writer_id", nullable = false)
    private String vipWriterId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vip_writer_id", insertable = false, updatable = false)
    private Vip vip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users users;

}
