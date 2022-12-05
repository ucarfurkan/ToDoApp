package ucarfurkan.todoapp.ToDoApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ucarfurkan.todoapp.ToDoApp.Entities.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
