package ucarfurkan.todoapp.ToDoApp.Service;

import ucarfurkan.todoapp.ToDoApp.Entities.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodosNotDone();
    List<Todo> getAllTodosDone();
    void addNewTodo(Todo todo);
    void deleteTodoById(Long id);
    Todo getTodoById(Long id);
    void updateTodo(Todo todo);
}
