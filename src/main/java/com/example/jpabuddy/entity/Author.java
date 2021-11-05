package com.example.jpabuddy.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "author")
@Entity
@Getter
@Setter
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "age")
  private Long age;

  @Column(name = "email", length = 70)
  private String email;

  @Column(name = "bio")
  private String bio;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
  private List<Award> awards = new ArrayList<>();
}