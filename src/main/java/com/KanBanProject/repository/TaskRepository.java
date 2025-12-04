package com.KanBanProject.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.Task;

@Repository
public class TaskRepository {
    public Task findById(Long Id) {
        return null; // TODO: implement findById
    }

    public Task save(Task task) {
        return task; // TODO: implement save
    }

    public List<Task> findByListId(Long listId) {
        return null; // TODO: implement findByListId
    }
}
