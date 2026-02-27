package com.KanBanProject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.Task;

@Repository
public class TaskRepository {

    // In-memory storage (fake db table)
    private final Map<Long, Task> store = new ConcurrentHashMap<>();

    // Thread-safe id counter (like auto-increment in db)
    private final AtomicLong idGen = new AtomicLong(0);

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Task> findByListId(Long listId) {
        List<Task> tasksInList = new ArrayList<>();
        if (listId == null) {
            return tasksInList;
        }

        for (Task task : store.values()) {
            if (task.getListEntity() != null
                    && task.getListEntity().getId() != null
                    && listId.equals(task.getListEntity().getId())) {
                tasksInList.add(task);
            }
        }

        return tasksInList;
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(idGen.incrementAndGet());
        }

        store.put(task.getId(), task);
        return task;
    }

    public boolean existsById(Long id) {
        return store.containsKey(id);
    }

    public void deleteById(Long id) {
        store.remove(id);
    }
}