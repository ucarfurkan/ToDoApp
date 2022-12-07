package ucarfurkan.todoapp.ToDoApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ucarfurkan.todoapp.ToDoApp.Entities.Todo;
import ucarfurkan.todoapp.ToDoApp.Service.TodoService;

import java.util.List;

@Controller
public class TodoController {
    TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public String getAllTodos(Model model){
        List<Todo> notDoneTodos = todoService.getAllTodosNotDone();
        model.addAttribute("todosNotDone",notDoneTodos);
        List<Todo> doneTodos = todoService.getAllTodosDone();
        model.addAttribute("todosDone",doneTodos);
        Todo todoNew = new Todo();
        todoNew.setIsDone(false);
        model.addAttribute("newTodo",todoNew);
        return "index";
    }

    @PostMapping("/todos")
    public String postNewTodo(@ModelAttribute("todoText") String todoText){
        Todo todo = new Todo(todoText,false);
        todoService.addNewTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/todos/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.deleteTodoById(id);
        return "redirect:/todos";
    }

    @GetMapping("/todos/update/{id}")
    public String updateTodo(@PathVariable Long id, Model model){
        Todo existingTodo = todoService.getTodoById(id);
        model.addAttribute("existingTodo", existingTodo);
        return "redirect:/todos";
    }

    @GetMapping("/todos/done/{id}")
    public String doneTodo(@PathVariable Long id){
        Todo existingTodo = todoService.getTodoById(id);
        existingTodo.setIsDone(true);
        todoService.updateTodo(existingTodo);
        return "redirect:/todos";
    }

}
