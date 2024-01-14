package htwberlin.todolist.Repository;

import htwberlin.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.iduser=?1")
    User findByIdUser(Long value);
    @Query("SELECT s FROM User s WHERE s.token=?1")
    User findByToken(String  token);

    @Query("SELECT s FROM User s WHERE s.email=?1 and s.password =?2")
    User findByEmailPassword(String email, String password);

    @Query("SELECT s FROM User s ")
    List<User> findAll();

}
