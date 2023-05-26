package com.example.gg.domain.Item.entity;

import com.example.gg.domain.member.entity.Member;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
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

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

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
