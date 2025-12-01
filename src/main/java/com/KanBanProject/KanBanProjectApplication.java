package com.KanBanProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.KanBanProject.entity.Board;
import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.entity.Task;
import com.KanBanProject.service.BoardService;
import com.KanBanProject.service.ListService;
import com.KanBanProject.service.TaskService;

@SpringBootApplication
public class KanBanProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KanBanProjectApplication.class, args);
	}

	//Create my default StarterPack (one Board, 3 Lists and one task) on-run.
	@Bean
	CommandLineRunner initDefaultStarterPack(BoardService boardService, ListService listService, TaskService taskservice) {
		return new CommandLineRunner() {
			@Override
			public void run(String... Args) {
				System.out.println("StartUp init running..");

				Board defaultBoard = new Board();
				defaultBoard.setName("Default Board");

				Board savedBoard = boardService.createBoard(defaultBoard);
				Long boardId = savedBoard.getId();
			


				ListEntity toDo = new ListEntity();
				toDo.setName("To Do");
				listService.createList(boardId, toDo);
				ListEntity savedToDo = listService.createList(boardId, toDo);


				ListEntity inProgress = new ListEntity();
				inProgress.setName("In Progress");
				// ListEntity savedInProgress = listService.createList(boardId, inProgress);


				ListEntity done = new ListEntity();
				done.setName("Done");
				// ListEntity savedDone = listService.createList(boardId, done);

				Task task = new Task();
				task.setName("My Task");
				taskservice.createTask(savedToDo.getId(), task);
			}
		};
	}

}
