package com.example.gg.domain.bid.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BidRaiseRequest {

    private Long itemId;
    private Long bidderId;
    private int heartCount;


}
