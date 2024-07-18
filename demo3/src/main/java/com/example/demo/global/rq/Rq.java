package com.example.demo.global.rq;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // 매 요청마다 1개씩 객체 생성 (객체 생성주기 변경)
@RequiredArgsConstructor
public class Rq {
    private final MemberService memberService;
    public Member getMember() {
        return memberService.getReferenceById(1L);
    }
}
