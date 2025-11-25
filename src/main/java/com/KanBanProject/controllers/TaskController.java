package com.KanBanProject.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.KanBanProject.entity.Task;
import com.KanBanProject.service.TaskService;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/{id}")

    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PostMapping("/lists/{listId}/tasks")

    public Task createTask(@PathVariable Long listId, @RequestBody Task task) {
        return taskService.createTask(listId, task);

    }
}

