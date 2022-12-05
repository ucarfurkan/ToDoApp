package ucarfurkan.todoapp.ToDoApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucarfurkan.todoapp.ToDoApp.Entities.Todo;
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
