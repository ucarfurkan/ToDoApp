package ucarfurkan.todoapp.ToDoApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

}
