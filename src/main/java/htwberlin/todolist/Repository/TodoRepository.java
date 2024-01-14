package htwberlin.todolist.Repository;

import htwberlin.todolist.model.Todo;
import htwberlin.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    @Query("SELECT s FROM Todo s WHERE s.idtodo=?1")
    Todo findByIdTodo(Long value);

    @Query("SELECT s FROM Todo s WHERE s.user.iduser=?1")
    Todo findByIdUser(Long value);

    @Query("SELECT s FROM Todo s ")
    List<Todo> findAll();

    @Query("SELECT s FROM Todo s WHERE s.user.token=?1")
    List<Todo> findByTokenUser(String token);




}
