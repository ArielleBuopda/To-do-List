package htwberlin.todolist.controller;

import htwberlin.todolist.model.User;
import htwberlin.todolist.service.UserService;
import htwberlin.todolist.service.implementation.UserServiceImpl;
import htwberlin.todolist.utils.Utilitaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user){
        user.setPassword(new Utilitaries().convertSHA512(user.getPassword()));
        userService.save(user);
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        Long userId = Long.parseLong(id);
        User user = userService.get(userId);
        return user;
    }

    @GetMapping( "/users")
    public List<User> getUsers(){
        return userService.getAll();
    }


}
