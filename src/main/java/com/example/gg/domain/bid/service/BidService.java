package com.example.gg.domain.bid.service;

import com.example.gg.domain.Item.entity.Item;
import com.example.gg.domain.Item.repository.ItemRepository;
import com.example.gg.domain.bid.dto.BidRaiseRequest;
import com.example.gg.domain.bid.entity.Bid;
import com.example.gg.domain.bid.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BidService {

    private final BidRepository bidRepository;
    private final ItemRepository itemRepository;

    public void raise(BidRaiseRequest request) {
        Optional<Bid> item_check = bidRepository.findByItemId(request.getItemId());

        if (item_check.isEmpty()) {
            Bid bid = Bid.builder()
                            .memberId(request.getBidderId())
                            .itemId(request.getItemId())
                            .heart(request.getHeartCount())
                            .build();
            bidRepository.save(bid);
            return;
        }

        // 입찰 하트 비교
        if (request.getHeartCount() > item_check.get().getHeart()) {
            // 더 많이 입찰 했을 경우
            item_check.get().setMemberId(request.getBidderId());
            item_check.get().setHeart(request.getHeartCount());
            bidRepository.save(item_check.get());

            Item item = itemRepository.findById(request.getItemId()).get();
            item.setMaxHeart(request.getHeartCount());
            itemRepository.save(item);
        }
    }
}
