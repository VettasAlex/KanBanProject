package com.KanBanProject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.entity.Task;

@Repository
public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    public Task findById(Long Id) {

        for (Task task : tasks) {
            if (task.getId() != null && task.getId().equals(Id)) {
                return task;
            }
        }
        System.out.println("No Task found with ID: " + Id);
        return null;
    }

    public Task save(Task task) {

    if (task.getId() == null) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    for (int i = 0; i < tasks.size(); i++) {
        if (tasks.get(i).getId().equals(task.getId())) {
            tasks.set(i, task);
            return task;
        }
    }

    // If someone tries to save an entity with an id that doesn't exist in the repo,
    // we treat it as "new" (or we could throw i guess).
    tasks.add(task);
    return task;
    }

    public List<Task> findByListId(Long listId) {

        List<Task> tasksInList = new ArrayList<>();
        if (listId == null) {
            return new ArrayList<>();
     }
        for (Task task : tasks) {
         if (task.getListEntity() != null && listId.equals(task.getListEntity().getId())) {
            tasksInList.add(task);
        }
    }
    return tasksInList;
    }
}


