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

	//Create my default StarterPack (one Board, 3 Lists and one task) on-run.
	@Bean
	CommandLineRunner initDefaultStarterPack(BoardService boardService, ListEntityService listService, TaskService taskservice) {
		return new CommandLineRunner() {
			@Override
			public void run(String... Args) {
				System.out.println("StartUp init running..");


				Board savedBoard = boardService.createBoard("Default Board");
				Long boardId = savedBoard.getId();

				ListEntity toDo = new ListEntity();
				toDo.setName("To Do");
				listService.createListEntity(boardId, toDo);
				ListEntity savedToDo = listService.createListEntity(boardId, toDo);

				ListEntity inProgress = new ListEntity();
				inProgress.setName("In Progress");

				ListEntity done = new ListEntity();
				done.setName("Done");
				

				Task task = new Task();
				task.setName("My Task");
				taskservice.createTask(savedToDo.getId(), task);
			}
		};
	}
}
