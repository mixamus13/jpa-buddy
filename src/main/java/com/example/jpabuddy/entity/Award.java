package com.example.jpabuddy.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "award")
@Entity
@Getter
@Setter
public class Award {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  Long id;

  @ManyToOne
  @JoinColumn(name = "author_id")
  Author author;

}
