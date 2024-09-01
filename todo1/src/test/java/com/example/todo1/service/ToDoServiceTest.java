package com.example.todo1.service;

import com.example.todo1.model.ToDoWeb;
import com.example.todo1.repository.DataInitialiser;
import com.example.todo1.repository.ToDoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ToDoServiceTest {

  @Autowired
  ToDoRepository toDoRepository;
  ToDoService toDoService;

  @BeforeEach
  void setUp() {
    toDoService = new ToDoService(toDoRepository);
  }

  @Test
  void initialiseWhenOk() {
    List<ToDoWeb> todos = toDoService.findByTitle(DataInitialiser.TEST_TITLE);
    Assertions.assertEquals(1, todos.size());
  }

  @Test
  void insertWhenOk() {
    final String TITLE = "InsertedTitle";
    toDoService.upsertToDo(ToDoWeb.builder()
      .title(TITLE)
      .build());
    List<ToDoWeb> todos = toDoService.findByTitle(TITLE);
    Assertions.assertEquals(1, todos.size());
  }

  @Test
  void findByIdWhenOk() {
    final String TITLE = "InsertedTitle";
    ToDoWeb toDoWeb1 = toDoService.upsertToDo(ToDoWeb.builder()
      .title(TITLE)
      .build());
    ToDoWeb todo = toDoService.findById(toDoWeb1.getId());
    Assertions.assertNotNull(todo);
  }

  @Test
  void updateWhenOk() {
    final String TITLE1 = "InsertedTitle";
    final String TITLE2 = "UpdatedTitle";
    ToDoWeb toDoWeb1 = toDoService.upsertToDo(ToDoWeb.builder()
      .title(TITLE1)
      .build());
    Assertions.assertNotNull(toDoWeb1.getId());
    ToDoWeb toDoWeb2 = toDoService.upsertToDo(ToDoWeb.builder()
      .id(toDoWeb1.getId())
      .title(TITLE2)
      .build());
    Assertions.assertNotNull(toDoWeb2.getId());
    List<ToDoWeb> todos = toDoService.findByTitle(TITLE2);
    Assertions.assertEquals(1, todos.size());
  }

}