package com.example.gg.domain.Item.repository;

import com.example.gg.domain.Item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemsByTitleContaining(String title);
    Optional<Item> findById(String Long);
}
