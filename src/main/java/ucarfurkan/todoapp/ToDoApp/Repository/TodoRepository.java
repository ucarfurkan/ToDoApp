package ucarfurkan.todoapp.ToDoApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ucarfurkan.todoapp.ToDoApp.Entities.Todo;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    @Query("SELECT t FROM Todo t WHERE t.isDone = false")
    List<Todo> findAllNotDone();

    @Query("SELECT t FROM Todo t WHERE NOT t.isDone = false")
    List<Todo> findAllDone();
}
