package com.example.gg.domain.Item.repository;

import com.example.gg.domain.Item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
