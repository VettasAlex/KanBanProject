package com.KanBanProject.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
        System.out.println("it works"); // Added debug statement
        return taskService.getTask(id);
    }

    @PatchMapping("/tasks/{taskId}move")
    public Task moveTask(@PathVariable Long taskId, @RequestParam Long targetListId) {
        taskService.moveTask(taskId, targetListId);
}
}

