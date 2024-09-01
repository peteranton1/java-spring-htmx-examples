package com.example.todo1.repository;

import com.example.todo1.model.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

  List<ToDo> findByTitle(String title);

  ToDo findById(long id);
}
