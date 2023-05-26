package com.example.gg.domain.member.controller;

import com.example.gg.domain.member.dto.MemberCreateRequest;
import com.example.gg.domain.member.dto.MemberLoginRequest;
import com.example.gg.domain.member.dto.MemberLoginResponse;
import com.example.gg.domain.member.entity.Member;
import com.example.gg.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<Member> create(@RequestBody MemberCreateRequest request) {
        boolean createCheck = memberService.create(request);

        // 회원가입 성공 (이메일 중복이 없음)
        if (createCheck) {
            return ResponseEntity.ok()
                    .body(null);
        } else {
            // 회원가입 실패 (이메일 중복)
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }

    @GetMapping("/members")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest request) {
        Member memberCheck = memberService.login(request);
        if (memberCheck != null) {
            MemberLoginResponse response = new MemberLoginResponse();
            response.setId(memberCheck.getId());
            
            return ResponseEntity.ok()
                    .body(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(null);
        }
    }
}
