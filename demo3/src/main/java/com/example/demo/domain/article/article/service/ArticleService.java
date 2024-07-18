package com.example.demo.domain.article.article.service;

import com.example.demo.domain.article.article.entity.Article;
import com.example.demo.domain.article.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;


    public long count(){
        return articleRepository.count();
    }
    @Transactional
    public Article write(String title, String body){
        Article article = Article.builder()
                .title(title)
                .body(body)
                .build();
        return articleRepository.save(article);
    }

    @Transactional
    public void delete(Article article){
        articleRepository.delete(article);
    }

    public Optional<Article>findById(long id){
        return articleRepository.findById(id);
    }
    public List<Article>findAll(){
        return articleRepository.findAll();
    }
}
