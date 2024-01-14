package htwberlin.todolist.controller;

import htwberlin.todolist.model.User;
import htwberlin.todolist.service.implementation.UserServiceImpl;
import htwberlin.todolist.utils.Utilitaries;
import oracle.jdbc.oracore.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/authentificate")
    public String authentification(@RequestBody User user){
        User us = userService.findByEmailPassword(user.getEmail(),new Utilitaries().convertSHA512(user.getPassword()));
        if(us == null){
            return "Fail";
        }else{
            String tok = new Utilitaries().generateUniqueString();
            us.setToken(tok);
            userService.save(us);
            return tok;
        }
    }
}
