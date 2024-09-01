package com.example.todo1.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "todos")
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String title;
}
