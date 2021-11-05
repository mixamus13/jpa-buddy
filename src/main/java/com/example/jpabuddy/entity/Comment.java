package com.example.jpabuddy.entity;

import com.fasterxml.jackson.databind.JsonNode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "comment")
@Entity
public class Comment {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "text", nullable = false)
  private String text;

  @Column(name = "article_id")
  private Article articleId;

  @Column(name = "author_id")
  private Author authorId;

  @Column(name = "details")
  private JsonNode details;

  public JsonNode getDetails() {
    return details;
  }

  public void setDetails(JsonNode details) {
    this.details = details;
  }

  public Author getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Author authorId) {
    this.authorId = authorId;
  }

  public Article getArticleId() {
    return articleId;
  }

  public void setArticleId(Article articleId) {
    this.articleId = articleId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}