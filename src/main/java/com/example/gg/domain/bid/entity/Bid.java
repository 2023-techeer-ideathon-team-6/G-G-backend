package com.example.gg.domain.bid.entity;

import com.example.gg.domain.Item.entity.Item;
import com.example.gg.domain.member.entity.Member;
import com.example.gg.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Bid extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int heartCount;

    public Bid(Member member,
               Item item,
               int heartCount) {
        this.member = member;
        this.item = item;
        this.heartCount = heartCount;
    }

    public void update(int heartCount) {
        this.heartCount = heartCount;
    }
}
