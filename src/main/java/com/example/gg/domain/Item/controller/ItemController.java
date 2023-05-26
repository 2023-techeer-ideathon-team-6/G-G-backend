package com.example.gg.domain.Item.controller;

import com.example.gg.domain.Item.dto.request.ItemCreateRequest;
import com.example.gg.domain.Item.dto.request.ItemUpdateRequest;
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

    @Operation(summary = "createItem", description = "상품 등록")
    @PostMapping
    public void createItem(@RequestBody ItemCreateRequest dto) {
        itemService.createItem(dto);
    }

    @Operation(summary = "deleteItem", description = "상품 삭제")
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @Operation(summary = "updateItem", description = "상품 수정")
    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id,
                           @RequestBody ItemUpdateRequest dto) {
        itemService.updateItem(id, dto);
    }
}
