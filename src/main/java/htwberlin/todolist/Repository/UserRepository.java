package htwberlin.todolist.Repository;

import htwberlin.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT s FROM User s WHERE s.iduser=?1")
    User findByIdUser(Long value);

}
