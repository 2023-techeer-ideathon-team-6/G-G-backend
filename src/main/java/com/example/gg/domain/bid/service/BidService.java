package com.example.gg.domain.bid.service;

import com.example.gg.domain.Item.entity.Item;
import com.example.gg.domain.Item.repository.ItemRepository;
import com.example.gg.domain.bid.dto.request.BidCreateRequest;
import com.example.gg.domain.bid.repository.BidRepository;
import com.example.gg.domain.member.entity.Member;
import com.example.gg.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BidService {
    private final BidRepository bidRepository;
    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    public void createBid(BidCreateRequest dto) {
        Member bidder = memberRepository.findById(dto.getBidderId()).get();
        Item item = itemRepository.findById(dto.getItemId()).get();
        
        if (item.getMaxHeart() < dto.getHeartCount()) {
            item.changeMaxHeartCount(dto.getHeartCount());
        }

        bidRepository.save(dto.toBid(bidder, item, dto.getHeartCount()));
    }
}
