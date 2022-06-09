package com.example.jpabuddy.entity;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "comment")
@Entity
public class Comment {

  @Id
  @Column(name = "id", nullable = false)
  Long id;

  @Column(name = "text", nullable = false)
  String text;

  @Column(name = "article_id")
  Article articleId;

  @Column(name = "author_id")
  Author authorId;

  @Column(name = "details")
  JsonNode details;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Comment comment = (Comment) o;
    return id != null && Objects.equals(id, comment.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
