package com.example.demo.domain.surl.surl.controller;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.domain.surl.surl.entity.Surl;
import com.example.demo.domain.surl.surl.service.SurlService;
import com.example.demo.global.rq.Rq;
import com.example.demo.global.rsData.RsData;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class SurlController {
    private final SurlService surlService;
    private final Rq rq;

    @GetMapping("/all")
    public List<Surl> getAll(){
        return surlService.findAll();
    }

    @GetMapping("/add")
    public RsData<Surl> add(String body, String url){
        Member member = rq.getMember(); //현재 브라우저로 로그인한 회원
        return surlService.add(member, body, url);
    }


}

