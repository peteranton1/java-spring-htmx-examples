package com.example.todo1.controller;

import com.example.todo1.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {

  private final ToDoService toDoService;

  public ToDoController(@Autowired ToDoService toDoService) {
    this.toDoService = toDoService;
  }

  @GetMapping("/todos")
  String todos(Model model){
    model.addAttribute("todos", toDoService.findAll());
    return "todos";
  }

}
