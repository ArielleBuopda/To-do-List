package htwberlin.todolist.controller;

import htwberlin.todolist.model.User;
import htwberlin.todolist.service.UserService;
import htwberlin.todolist.service.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        Long userId = Long.parseLong(id);
        User user = userService.get(userId);
        return user;
    }



}
