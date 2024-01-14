package htwberlin.todolist.service.implementation;

import htwberlin.todolist.Repository.TodoRepository;
import htwberlin.todolist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="TodoService")
public class TodoServiceImpl {

    @Autowired
    TodoRepository todoRepository;

    public Todo save(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo get (Long id){
        return todoRepository.findByIdTodo(id);
    }

    public Todo getByUser (Long id){
        return todoRepository.findByIdUser(id);
    }

    public List<Todo> getAll(){
        return todoRepository.findAll();
    }

    public List<Todo> getAllByToken(String token){
        return  todoRepository.findByTokenUser(token);
    }

    public void deleteToDo(Todo todo){
        todoRepository.deleteById(todo.getIdtodo());
    }

}
