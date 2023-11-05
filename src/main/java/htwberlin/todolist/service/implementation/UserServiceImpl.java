package htwberlin.todolist.service.implementation;

import htwberlin.todolist.Repository.UserRepository;
import htwberlin.todolist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="UserService")
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User get(Long id){
        User user = userRepository.findByIdUser(id);
        return userRepository.findByIdUser(id);
    }
}
