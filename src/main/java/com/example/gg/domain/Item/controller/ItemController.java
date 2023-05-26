package com.example.gg.domain.Item.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "ItemController", description = "상품 관련 API")
@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    @Operation(summary = "getReComment", description = "답글 조회")
    @GetMapping
    public String get() {
        return "Hello world!";
    }
}
