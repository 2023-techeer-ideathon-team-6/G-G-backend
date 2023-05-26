package com.example.gg.domain.Item.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false) // 제품 상태
    private int starCount;

    @Column(nullable = false) // 최고 입찰 금액
    private int maxHeart;

    public Item(Long id,
                String title,
                String url,
                int starCount) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.starCount = starCount;
    }

    public void update(String title,
                       String url,
                       int starCount) {
        this.title = title;
        this.url = url;
        this.starCount = starCount;
    }
}
