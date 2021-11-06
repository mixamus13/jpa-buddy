package com.example.jpabuddy.entity;

import static lombok.AccessLevel.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

@FieldDefaults(level = PRIVATE)
@Table(name = "article", indexes = {
    @Index(name = "idx_article_title", columnList = "title")
})
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  Long id;

  @Column(name = "title", length = 100)
  String title;

  @Column(name = "article_text", length = 3000)
  String articleText;

  @ManyToMany
  @JoinTable(name = "article_authors",
      joinColumns = @JoinColumn(name = "article_id"),
      inverseJoinColumns = @JoinColumn(name = "authors_id"))
  @Exclude
  List<Author> authors;

  @Column(name = "publication_date")
  private LocalDate publicationDate;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Article article = (Article) o;
    return id != null && Objects.equals(id, article.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}