package com.example.jpabuddy.repository;

import com.example.jpabuddy.entity.Article;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {

  @Query("select a from Article a where upper(a.title) like upper(concat(:title, '%')) and a.articleText is not null and a.publicationDate > :publicationDate")
  List<Article> findByTitleAndDateAfter(@Param("title") String title, @Param("publicationDate") LocalDate publicationDate);

}