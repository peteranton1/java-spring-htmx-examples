package com.example.todo1.service;

import com.example.todo1.model.ToDo;
import com.example.todo1.model.ToDoConverter;
import com.example.todo1.model.ToDoWeb;
import com.example.todo1.repository.DataInitialiser;
import com.example.todo1.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ToDoService {

  private final ToDoRepository toDoRepository;
  private final ToDoConverter toDoConverter;

  public ToDoService(
    @Autowired ToDoRepository toDoRepository
  ) {
    this.toDoRepository = toDoRepository;
    DataInitialiser dataInitialiser = new DataInitialiser(toDoRepository);
    dataInitialiser.initialise();
    this.toDoConverter = new ToDoConverter();
  }

  public List<ToDoWeb> findAll() {
    Iterable<ToDo> toDos = toDoRepository.findAll();
    return StreamSupport.stream(toDos.spliterator(), false)
      .map(toDoConverter::toWeb).toList();
  }

  public List<ToDoWeb> findByTitle(String title) {
    List<ToDo> toDos = toDoRepository.findByTitle(title);
    return toDos.stream().map(toDoConverter::toWeb).toList();
  }

  public ToDoWeb findById(Long id) {
    ToDo toDo = toDoRepository.findById(id).orElseThrow();
    return toDoConverter.toWeb(toDo);
  }

  public ToDoWeb upsertToDo(ToDoWeb toDoWeb) {
    ToDo toDo = toDoRepository.save(toDoConverter.toDb(toDoWeb));
    return toDoConverter.toWeb(toDo);
  }


}
