package com.example.gg.domain.Item.service;

import com.example.gg.domain.Item.dto.request.ItemCreateRequest;
import com.example.gg.domain.Item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
