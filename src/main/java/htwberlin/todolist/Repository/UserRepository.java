package htwberlin.todolist.Repository;

import htwberlin.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
