package com.example.demo.controller;

import com.example.demo.domain.Surl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SurlController {
    private final List<Surl> surls = new ArrayList<>();
    private long surlsLastId;

    @GetMapping("/all")
    public List<Surl>geAll(){
        return surls;
    }

    @GetMapping("/add")
    public Surl add(String body, String url){
        Surl surl = Surl
                .builder()
                .id(++surlsLastId)
                .body(body)
                .url(url)
                .build();
        surls.add(surl);
        return surl;
    }

    @GetMapping("/s/{body}/**")
    public Surl add(
            @PathVariable String body,
            HttpServletRequest req
    ){
        String url = req.getRequestURI();
        if(req.getQueryString() != null){
            url += "?" + req.getQueryString();
        }
        String[] urlBits = url.split("/", 4);

        System.out.println("Arrays.toString(urlBits) : " + Arrays.toString(urlBits));

        url = urlBits[3];

        Surl surl = Surl
                .builder()
                .id(++surlsLastId)
                .body(body)
                .url(url)
                .build();

        surls.add(surl);

        return surl;
    }


    @GetMapping("/g/{id}")
    public String go(
            @PathVariable long id,
            HttpServletResponse response
    ) {
        Surl findSurl = surls
                .stream()
                .filter(_surl -> _surl.getId() == id)
                .findFirst()
                .orElse(null);

        if ( findSurl == null ) throw new RuntimeException("%d번 URL을 찾을 수 없습니다.".formatted(id));

        findSurl.increaseCount();

        return "redirect:" + findSurl.getUrl();
    }


}
