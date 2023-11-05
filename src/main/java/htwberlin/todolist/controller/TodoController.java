package htwberlin.todolist.controller;

import htwberlin.todolist.model.Todo;
import htwberlin.todolist.model.User;
import htwberlin.todolist.service.implementation.TodoServiceImpl;
import htwberlin.todolist.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {


    @Autowired
    TodoServiceImpl todoService;

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.save(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo getTodo(@PathVariable String id){
        Long userId = Long.parseLong(id);
        return todoService.get(userId);
    }



}
