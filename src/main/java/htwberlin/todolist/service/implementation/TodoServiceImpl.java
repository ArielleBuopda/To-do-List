package htwberlin.todolist.service.implementation;

import htwberlin.todolist.Repository.TodoRepository;
import htwberlin.todolist.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
