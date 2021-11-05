package com.example.jpabuddy.controller;

import com.example.jpabuddy.entity.Article;
import com.example.jpabuddy.repository.ArticleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleRepository articleRepository;

  @GetMapping("articles")
  public List<Article> getAllArticle() {
    return articleRepository.findAll();
  }
}
