package ucarfurkan.todoapp.ToDoApp.Service;

import ucarfurkan.todoapp.ToDoApp.Entities.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodosNotDone();
    List<Todo> getAllTodosDone();
}
