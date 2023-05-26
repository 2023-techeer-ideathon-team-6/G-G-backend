package com.example.gg.domain.Item.controller;

import com.example.gg.domain.Item.dto.request.ItemCreateRequest;
import com.example.gg.domain.Item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ItemController", description = "상품 관련 API")
@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @Operation(summary = "getReComment", description = "답글 조회")
    @PostMapping
    public void createItem(@RequestBody ItemCreateRequest dto) {
        itemService.createItem(dto);
    }
}
