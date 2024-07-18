package com.example.demo.domain.surl.surl.service;

import com.example.demo.domain.member.member.entity.Member;
import com.example.demo.domain.surl.surl.entity.Surl;
import com.example.demo.domain.surl.surl.repository.SurlRepository;

import com.example.demo.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SurlService {
    private final SurlRepository surlRepository;

    public List<Surl> findAll() {
        return surlRepository.findAll();
    }



    public Optional<Surl> findById(long id) {
        return surlRepository.findById(id);
    }

    @jakarta.transaction.Transactional
    public RsData<Surl> add(Member member, String body, String url) {
        Surl surl = Surl.builder()
                .body(body)
                .url(url)
                .build();
        surlRepository.save(surl);

        return RsData.of("%d번 URL이 생성되었습니다.".formatted(surl.getId()), surl);
    }
}
