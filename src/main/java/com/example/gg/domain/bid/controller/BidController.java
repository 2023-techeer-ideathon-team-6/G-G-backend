package com.example.gg.domain.bid.controller;

import com.example.gg.domain.Item.dto.request.ItemCreateRequest;
import com.example.gg.domain.bid.dto.request.BidCreateRequest;
import com.example.gg.domain.bid.service.BidService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "ItemController", description = "상품 관련 API")
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
}
