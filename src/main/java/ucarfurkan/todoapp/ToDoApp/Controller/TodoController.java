package ucarfurkan.todoapp.ToDoApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping({"/",""})
    public String getAllTodos(Model model){
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos",todos);
        return "index";
    }
}
