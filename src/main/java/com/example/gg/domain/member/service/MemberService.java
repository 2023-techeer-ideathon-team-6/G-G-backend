package com.example.gg.domain.member.service;

import com.example.gg.domain.member.dto.MemberCreateRequest;
import com.example.gg.domain.member.dto.MemberLoginRequest;
import com.example.gg.domain.member.entity.Member;
import com.example.gg.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean create(MemberCreateRequest request) {
        Optional<Member> checkEmail = memberRepository.findByEmail(request.getEmail());

        if (checkEmail.isEmpty()) {
            Member member = Member.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .nickname(request.getNickname())
                    .heart(30L)
                    .token(request.getRegistrationToken())
                    .build();
            memberRepository.save(member);
            return true;
        } else {
            return false;
        }


    }

    public Member login(MemberLoginRequest request) {
        Optional<Member> member = memberRepository.findByEmail(request.getEmail());

        // 유저가 없는 경우
        if (member.isEmpty()) {
            return null;
        }

        // 유저가 있는 경우
        if (member.get().getPassword().equals(request.getPassword())) {
            // 로그인 성공
            return member.get();
        } else {
            return null;
        }
    }
}
