package com.example.gg.domain.bid.controller;

import com.example.gg.domain.bid.dto.BidRaiseRequest;
import com.example.gg.domain.bid.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class BidController {

    private final BidService bidService;

    @PostMapping("/bids")
    public void raise(@RequestBody BidRaiseRequest request) {
        bidService.raise(request);
    }
}
