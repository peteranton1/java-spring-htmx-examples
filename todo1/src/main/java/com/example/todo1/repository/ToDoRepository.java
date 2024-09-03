package com.example.todo1.repository;

import com.example.todo1.model.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

  List<ToDo> findByTitle(String title);

  ToDo findById(long id);
}
