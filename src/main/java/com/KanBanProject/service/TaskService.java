package com.KanBanProject.service;
import org.springframework.stereotype.Service;

import com.KanBanProject.entity.Task;
import com.KanBanProject.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Long listId, Task task) {
    // temporary placeholder logic
    return null;
}



}
