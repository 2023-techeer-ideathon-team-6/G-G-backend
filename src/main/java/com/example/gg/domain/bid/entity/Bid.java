package com.example.gg.domain.bid.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "heart")
    private int heart;

    public Bid() {
    }

    public Bid(Long itemId, Long memberId, int heart) {
        this.itemId = itemId;
        this.memberId = memberId;
        this.heart = heart;
    }

    // 게터와 세터 추가
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

}
