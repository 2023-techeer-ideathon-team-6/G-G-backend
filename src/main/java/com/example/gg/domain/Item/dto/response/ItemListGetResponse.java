package com.example.gg.domain.Item.dto.response;

import com.example.gg.domain.Item.entity.Item;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ItemListGetResponse {
    Long itemId;
    String title;
    String url;
    int starCount;
    int maxBid;

    public static ItemListGetResponse from(Item item) {
        return new ItemListGetResponse(item.getId(), item.getTitle(), item.getUrl(), item.getStarCount(), item.getMaxHeart());
    }
}
