package com.KanBanProject.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.entity.Task;
import com.KanBanProject.repository.ListEntityRepository;
import com.KanBanProject.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ListEntityRepository listEntityRepository;

    public TaskService(TaskRepository taskRepository, ListEntityRepository listEntityRepository) {
        this.taskRepository = taskRepository;
        this.listEntityRepository = listEntityRepository;
    }

    public Task getTask(Long id) {
    return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Didn't find any task with id: " + id));
}

    public Task createTask(Long listId, Task task) {
    if (task == null || task.getName() == null || task.getName().trim().isEmpty()) {
        throw new IllegalArgumentException("Name's missing");
    }

    ListEntity list = listEntityRepository.findById(listId)
            .orElseThrow(() -> new IllegalArgumentException("Didn't find any list with id: " + listId));

    task.setListEntity(list);
    list.getTasks().add(task);

    List<Task> tasksInList = taskRepository.findByListId(listId);
    int maxPosition = -1;
    for (Task t : tasksInList) {
        if (t.getPosition() > maxPosition) {
            maxPosition = t.getPosition();
        }
    }
    task.setPosition(maxPosition + 1);

    return taskRepository.save(task);
}

    public Task moveTask(Long taskId, Long targetListId) {
    Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Didn't find any task with id: " + taskId));
        
    

    ListEntity targetList = listEntityRepository.findById(targetListId).orElseThrow(() -> new IllegalArgumentException("Didn't find any targetlist with id: " + targetListId));
    task.setListEntity(targetList);
        
    List<Task> tasksInTargetList = taskRepository.findByListId(targetListId);

    int maxPosition = -1;
    for (Task t : tasksInTargetList) {
        if (t.getPosition() > maxPosition) {
            maxPosition = t.getPosition();
        }
    }

    int nextPosition = maxPosition + 1;
    task.setPosition(nextPosition);

    return taskRepository.save(task);
}
}
