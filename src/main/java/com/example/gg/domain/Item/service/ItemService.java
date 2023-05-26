package com.example.gg.domain.Item.service;

import com.example.gg.domain.Item.dto.request.ItemCreateRequest;
import com.example.gg.domain.Item.dto.request.ItemUpdateRequest;
import com.example.gg.domain.Item.dto.response.ItemListGetResponse;
import com.example.gg.domain.Item.entity.Item;
import com.example.gg.domain.Item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;
    public void createItem(ItemCreateRequest dto) {
        itemRepository.save(dto.toDto(dto));
    }

    public void deleteItem(Long id) {
        itemRepository.delete(itemRepository.findById(id).get());
    }

    public void updateItem(Long id, ItemUpdateRequest dto) {
        Item item = itemRepository.findById(id).get();
        item.update(dto.getTitle(), dto.getUrl(), dto.getStarCount());
    }

    public List<ItemListGetResponse> getItems(String title) {
        return itemRepository.findItemsByTitleContaining(title)
                .stream()
                .map(ItemListGetResponse::from)
                .collect(Collectors.toList());

    }
}
