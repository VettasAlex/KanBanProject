package com.KanBanProject.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.entity.Task;
import com.KanBanProject.service.ListService;
import com.KanBanProject.service.TaskService;


@RestController
public class ListController {

    private final ListService listService;
    private final TaskService taskService;

    public ListController(ListService listService, TaskService taskService) {
        this.listService = listService;
        this.taskService = taskService;
    }

    @GetMapping("/lists/{id}")

    public ListEntity getListEntity(@PathVariable Long id) {
        return listService.getListEntity(id);
    }

    @PostMapping("/lists/{listId}/tasks")
    public Task createTask(@PathVariable Long listId, @RequestBody Task task) {
        return taskService.createTask(listId, task);
    }
}
