package com.KanBanProject.repository;

import java.util.List;

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

    public List<Task> findByListId(Long listId) {
        return null; // implement later
}
