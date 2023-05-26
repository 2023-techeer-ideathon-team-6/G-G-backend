package com.example.gg.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberCreateRequest {

    private String email;
    private String password;
    private String nickname;
    private String registrationToken;

}
