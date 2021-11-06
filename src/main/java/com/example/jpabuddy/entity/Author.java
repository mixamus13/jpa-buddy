package com.example.jpabuddy.entity;

import static lombok.AccessLevel.*;

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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = PRIVATE)
@Table(name = "author")
@Entity
@Getter
@Setter
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  Long id;

  @Column(name = "name", nullable = false)
  String name;

  @Column(name = "age")
  Long age;

  @Column(name = "email", length = 70)
  String email;

  @Column(name = "bio")
  String bio;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
  List<Award> awards = new ArrayList<>();
}