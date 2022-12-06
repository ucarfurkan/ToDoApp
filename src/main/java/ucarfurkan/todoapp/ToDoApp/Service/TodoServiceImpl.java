package ucarfurkan.todoapp.ToDoApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucarfurkan.todoapp.ToDoApp.Entities.Todo;
import ucarfurkan.todoapp.ToDoApp.Repository.TodoRepository;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {
    TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAllTodosNotDone() {
        return todoRepository.findAllNotDone();
    }

    @Override
    public List<Todo> getAllTodosDone() {
        return todoRepository.findAllDone();
    }

    @Override
    public void addNewTodo(Todo todo) {
        todoRepository.save(todo);
    }
}
