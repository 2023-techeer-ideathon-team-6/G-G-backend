package com.example.gg.domain.bid.repository;

import com.example.gg.domain.bid.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Optional<Bid> findByItemId(Long item_id);
}
