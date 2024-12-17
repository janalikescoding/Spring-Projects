package com.example.restsoap_todoapplication.controller;

import com.example.restsoap_todoapplication.model.Todo;
import com.example.restsoap_todoapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

  @Autowired
  TodoService todoService;

  @RequestMapping(path = "/list-todos", method = RequestMethod.GET)
  public String getTodos(ModelMap modelMap){
    String user = (String)modelMap.get("name");
    List<Todo> todos = todoService.getTodos(user);
    modelMap.put("todos", todos);
    return "todos";
  }

  @RequestMapping(path = "/test", method = RequestMethod.POST)
  public String processList(@RequestBody List<String> titles){
    return "todos";
  }
}
