package com.KanBanProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.KanBanProject.entity.Board;
import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.entity.Task;
import com.KanBanProject.service.BoardService;
import com.KanBanProject.service.ListEntityService;
import com.KanBanProject.service.TaskService;


@SpringBootApplication(
	// Disable auto-configuration for database connection & JPA until implemented
    exclude = { 
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
    }
)
public class KanBanProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanBanProjectApplication.class, args);
	}

	//Create my default StarterPack (one Board, 3 Lists and 3 tasks, one per list) on-run.
	@Bean
	CommandLineRunner initDefaultStarterPack(BoardService boardService, ListEntityService listService, TaskService taskservice) {
		return new CommandLineRunner() {
			@Override
			public void run(String... Args) {
				System.out.println("StartUp init running..");


				Board savedBoard = boardService.createBoard("Default Board");
				Long boardId = savedBoard.getId();


				// Create default lists for the board

				ListEntity toDo = new ListEntity();
				toDo.setName("Stuff To Do");
				// listService.createListEntity(boardId, toDo);
				ListEntity savedToDo = listService.createListEntity(boardId, toDo);

				ListEntity inProgress = new ListEntity();
				inProgress.setName("In Progress");
				ListEntity savedInProgress = listService.createListEntity(boardId, inProgress);

				ListEntity done = new ListEntity();
				done.setName("Done");
				ListEntity savedDone = listService.createListEntity(boardId, done);


				// Create tasks in the "To Do" list

				Task task1 = new Task();
				task1.setName("Write Code");
				taskservice.createTask(savedDone.getId(), task1);

				Task task2 = new Task();
				task2.setName("Debug Code");
				taskservice.createTask(savedInProgress.getId(), task2);

				Task task3 = new Task();
				task3.setName("Fix Bugs");
				taskservice.createTask(savedToDo.getId(), task3);

				
			}
		};
	}
}
