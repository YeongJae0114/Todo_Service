package com.example.demo.domain.member.member.service;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.domain.member.member.repository.MemberRepository;
import com.example.demo.global.exception.GlobalException;
import com.example.demo.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public RsData<Member> join(String username, String password, String nickname) {
        findByUsername(username).ifPresent(ignored -> {
            throw new GlobalException("400-1", "%s(은)는 이미 존재하는 아이디".formatted(username));
        });

        Member member = Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .build();
        memberRepository.save(member);
        return RsData.of("회원가입 완료",member);
    }

    private Optional<Member>findByUsername(String username){
        return memberRepository.findByUsername(username);
    }

    public Member getReferenceById(long id) {
        return memberRepository.getReferenceById(id);
    }
}
