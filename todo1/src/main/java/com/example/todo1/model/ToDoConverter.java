package com.example.todo1.model;

public class ToDoConverter {

  public ToDoWeb toWeb(ToDo toDo) {
    return ToDoWeb.builder()
      .id(toDo.getId())
      .title(toDo.getTitle())
      .build();
  }

  public ToDo toDb(ToDoWeb toDoWeb) {
    return ToDo.builder()
      .id(toDoWeb.id)
      .title(toDoWeb.title)
      .build();
  }
}
