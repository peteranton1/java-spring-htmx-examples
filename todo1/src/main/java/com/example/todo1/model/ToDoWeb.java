package com.example.todo1.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ToDoWeb {
  Long id;
  String title;
}
