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
        Task task = taskRepository.findById(id);
        if (task == null) {
            throw new IllegalArgumentException("Didn't find any task with id: " + id);
        }
        return task;
    }

    public Task createTask(Long listId, Task task) {
        // TODO: implement createTask
        return null;
    }

    public Task moveTask(Long taskId, Long targetListId) {
        Task task = taskRepository.findById(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Didn't find any task with id: " + taskId);
        }
        ListEntity targetList = listEntityRepository.findById(targetListId);
         if (targetList == null) {
        throw new IllegalArgumentException("Didn't find any targetlist with id: " + targetListId);
        }
        
        List<Task> tasksInTargetList = taskRepository.findByListId(targetListId);

        int maxPos = -1;
        for (Task t : tasksInTargetList) {
            if (t.getPos() > maxPos) {
                maxPos = t.getPos();
            }
        }

        int nextPos = maxPos + 1;
        task.setPos(nextPos);
        

        return taskRepository.save(task);


    }
}
