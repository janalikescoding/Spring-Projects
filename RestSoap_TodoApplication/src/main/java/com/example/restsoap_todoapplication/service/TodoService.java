package com.example.restsoap_todoapplication.service;

import com.example.restsoap_todoapplication.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
  private static List<Todo> todos = new ArrayList();
  static {
    todos.add(new Todo(1, "user", "Learn Spring MVC", new Date(),
        false));
    todos.add(new Todo(2, "user", "Learn Struts", new Date(), false));
    todos.add(new Todo(3, "user", "Learn Hibernate", new Date(),
        false));
  }

  public  List<Todo> getTodos(String user){
    return todos.stream().filter(t -> t.getUser().equalsIgnoreCase(user)).collect(Collectors.toList());
  }
}
