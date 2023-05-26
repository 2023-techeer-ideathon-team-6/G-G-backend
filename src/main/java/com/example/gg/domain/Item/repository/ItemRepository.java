package com.example.gg.domain.Item.repository;

import com.example.gg.domain.Item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemsByTitleContaining(String title);

    Item findByMaxHeart(int maxHeart);
}
