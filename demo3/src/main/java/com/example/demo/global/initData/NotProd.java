package com.example.demo.global.initData;

import com.example.demo.domain.article.article.service.ArticleService;
import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.domain.member.member.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

// 개발모드인지 운영모드인지 출력해주는 빈
@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Lazy
    @Autowired
    private NotProd self;

    private final ArticleService articleService;

    private final MemberService memberService;

    @Bean
    public ApplicationRunner initNotProd(){
        return args -> {
            self.work1();
        };
    }


    @Transactional
    public void work1(){
        Member member1 = memberService.join("user1", "1234", "유저1").getData();
        Member member2 = memberService.join("user2", "1234", "유저2").getData();

        //RsData<Member> joiRs = memberService.join("user3", "1234", "유저3");


    }



}
