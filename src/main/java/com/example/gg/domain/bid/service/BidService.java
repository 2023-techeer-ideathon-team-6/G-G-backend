package com.example.gg.domain.bid.service;

import com.example.gg.domain.bid.entity.Bid;
import com.example.gg.domain.bid.repository.BidRepository;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    private final BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public void placeBid(Bid bid) {
        bidRepository.save(bid);
    }

    public void increaseBidAmount(long bidId, int heartCount) {
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new RuntimeException("Bid not found."));
        bid.setHeart(bid.getHeart() + heartCount);
        bidRepository.save(bid);
    }

    public void acceptBid(Bid bid) {
        bidRepository.save(bid);
    }
}
