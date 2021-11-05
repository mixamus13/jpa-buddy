package com.example.jpabuddy.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.jpabuddy.entity.Article;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ArticleRepositoryTest {

  @Autowired
  ArticleRepository articleRepository;

  @Test
  void hashSetFindEntity() {

    Article article = new Article();
    article.setTitle("Lombok and JPA");

    HashSet<Article> articles = new HashSet<>();
    articles.add(article);

    articleRepository.save(article);

    assertTrue(articles.contains(article));
  }
}