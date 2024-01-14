package htwberlin.todolist.controller;

import htwberlin.todolist.model.Todo;
import htwberlin.todolist.model.User;
import htwberlin.todolist.service.implementation.TodoServiceImpl;
import htwberlin.todolist.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {


    @Autowired
    TodoServiceImpl todoService;
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/todo")
    public String createTodo(@RequestHeader(value = "Authorization") String token, @RequestBody Todo todo){
        if(token == null || token.isEmpty()){
            return "Fail";
        }else{
            User user = userService.findByToken(token);
            if (user == null){
                return "Fail";
            }else{
                todo.setUser(user);
                todoService.save(todo);
                return "Success";
            }
        }
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@RequestHeader(value = "Authorization") String token,@PathVariable String id){
        Long todoId = Long.parseLong(id);
        return todoService.get(todoId);
    }
    @GetMapping("/todos")
    public List<Todo> getTodoAll(@RequestHeader(value = "Authorization") String token){

        if(token == null || token.isEmpty()){
            return new ArrayList<>();
        }else{
            User user = userService.findByToken(token);
            if (user == null){
                return new ArrayList<>();
            }else{
                return todoService.getAllByToken(token);
            }
        }
    }

    @PostMapping("/todo/delete")
    public List<Todo> delete(@RequestHeader(value = "Authorization") String token, @RequestBody Todo todo){

        if(token == null || token.isEmpty()){
            return new ArrayList<>();
        }else{
            User user = userService.findByToken(token);
            if (user == null){
                return new ArrayList<>();
            }else{
                todoService.deleteToDo(todo);
                return todoService.getAllByToken(token)!=null?todoService.getAllByToken(token): new ArrayList<>();
            }
        }
    }



}
