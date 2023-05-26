package com.example.gg.domain.bid.controller;

import com.example.gg.domain.bid.entity.Bid;
import com.example.gg.domain.bid.service.BidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bids")
public class BidController {

    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/")
    public ResponseEntity<String> placeBid(@RequestBody Bid bid) {
        try {
            bidService.placeBid(bid);
            return ResponseEntity.ok("Bid placed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to place bid.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> increaseBidAmount(@PathVariable("id") long bidId, @RequestBody Bid bid) {
        try {
            bidService.increaseBidAmount(bidId, bid.getHeart());
            return ResponseEntity.ok("Bid amount increased successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to increase bid amount.");
        }
    }

    @PostMapping("/success")
    public ResponseEntity<String> acceptBid(@RequestBody Bid bid) {
        try {
            bidService.acceptBid(bid);
            return ResponseEntity.ok("Bid accepted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to accept bid.");
        }
    }

    public
}
