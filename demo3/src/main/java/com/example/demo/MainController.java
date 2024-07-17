package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @Value("${custom.site.name}")
    private String siteName;

    @GetMapping("/")
    public String showMain(){
        return "Hello, World!" + siteName;
    }


    @GetMapping("/sbb")
    public String index(){
        return "안녕";
    }




    @GetMapping("/a")
    public String hello(
            String age, String id){
        return "age : %s id : %s".formatted(age, id);
    }


}
