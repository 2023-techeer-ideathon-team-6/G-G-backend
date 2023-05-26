package com.example.gg.domain.bid.dto.request;

import com.example.gg.domain.Item.dto.request.ItemCreateRequest;
import com.example.gg.domain.Item.entity.Item;
import com.example.gg.domain.bid.entity.Bid;
import com.example.gg.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BidCreateRequest {
    private Long itemId;
    private Long bidderId;
    private int heartCount;

    public Bid toBid(Member bidder,
                     Item item,
                     int heartCount) {

        return new Bid(bidder, item, heartCount);
    }
}
