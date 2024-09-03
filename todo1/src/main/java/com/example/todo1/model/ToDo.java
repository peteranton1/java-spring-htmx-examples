package com.example.todo1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  String title;
}
