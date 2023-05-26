package com.example.gg.domain.member.entity;

import com.example.gg.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "heart", nullable = false)
    private Long heart;

    @Column(name = "token", nullable = false)
    private String token;


    @Builder
    public Member(String email, String password, String nickname, Long heart, String token) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.heart = heart;
        this.token = token;
    }

    public void plusHeart(int count) {
        this.heart += count;
    }

    public void payToken(int count) {
        this.heart -= count;
    }
}
