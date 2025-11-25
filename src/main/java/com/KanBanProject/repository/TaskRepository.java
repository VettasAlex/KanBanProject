package com.KanBanProject.repository;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.Task;

@Repository
public class TaskRepository {
    public Task findById(Long Id) {
        return null; // implement later
    }
     public Task save(Task task) {
        return task; // placeholder
    }
}
