package com.example.todo1.repository;

import com.example.todo1.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitialiser {

  public static final String TEST_TITLE = "Write a todo item";

  private final ToDoRepository toDoRepository;

  public DataInitialiser(@Autowired ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  @EventListener(
    ApplicationReadyEvent.class
  )
  public void initialise() {
    toDoRepository.deleteAll();
    toDoRepository.save(ToDo.builder().title(TEST_TITLE).build());
  }
}
