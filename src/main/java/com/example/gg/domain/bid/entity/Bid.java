package com.example.gg.domain.bid.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "bid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "heart", nullable = false)
    private int heart;

    @Builder
    public Bid(Long memberId, Long itemId, int heart) {
        this.memberId = memberId;
        this.itemId = itemId;
        this.heart = heart;
    }
}
