package com.example.jpabuddy.entity;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
