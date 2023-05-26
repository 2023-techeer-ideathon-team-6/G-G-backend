package com.example.gg.domain.bid.controller;

import com.example.gg.domain.Item.dto.request.ItemCreateRequest;
import com.example.gg.domain.bid.dto.request.BidCUpdateRequest;
import com.example.gg.domain.bid.dto.request.BidCreateRequest;
import com.example.gg.domain.bid.service.BidService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "BidController", description = "경매 관련 API")
@RestController
@RequestMapping("api/v1/bids")
@RequiredArgsConstructor
public class BidController {
    private final BidService bidService;

    @Operation(summary = "createBid", description = "입찰 등록")
    @PostMapping
    public void createBid(@RequestBody BidCreateRequest dto) {
        bidService.createBid(dto);
    }

    @Operation(summary = "updateBid", description = "입찰금 증액")
    @PutMapping("/{id}")
    public void updateBid(@PathVariable Long id,
                          @RequestBody BidCUpdateRequest dto) {
        bidService.updateBid(id, dto);
    }

    @Operation(summary = "updateBid", description = "입찰금 증액")
    @PutMapping("/success")
    public void updateBid() {
//        bidService.successBid();
    }
}
