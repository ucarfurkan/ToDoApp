package ucarfurkan.todoapp.ToDoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ucarfurkan.todoapp.ToDoApp.Entities.Todo;
import ucarfurkan.todoapp.ToDoApp.Repository.TodoRepository;

@SpringBootApplication
public class ToDoAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void run(String... args) throws Exception {
/*		Todo todo1 = new Todo("HIT GYM",false);
		todoRepository.save(todo1);
		Todo todo2= new Todo("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS",false);
		todoRepository.save(todo2);*/
		Todo todo3= new Todo("qwdqwişdqwşidçqwşiefçöqeiföeşlwmfglşwömgflşr",false);
		todoRepository.save(todo3);
		Todo todo4= new Todo("aaaaaa",true);
		todoRepository.save(todo4);
	}
}
