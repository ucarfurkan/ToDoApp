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

    @GetMapping({"", "/"})
    public String getAllTodos(Model model){
        List<Todo> notDoneTodos = todoService.getAllTodosNotDone();
        model.addAttribute("todosNotDone",notDoneTodos);
        List<Todo> doneTodos = todoService.getAllTodosDone();
        model.addAttribute("todosDone",doneTodos);
        return "index";
    }
}
