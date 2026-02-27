package com.KanBanProject.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.ListEntity;

@Repository
public class ListEntityRepository {

    // In-memory storage (acts like a fake db table)
    private final Map<Long, ListEntity> store = new ConcurrentHashMap<>();

    // Thread-safe id counter (like auto-increment in db)
    private final AtomicLong idGen = new AtomicLong(0);

    public ListEntity save(ListEntity listEntity) {

        // Generate id if new
        if (listEntity.getId() == null) {
            listEntity.setId(idGen.incrementAndGet());
        }

        store.put(listEntity.getId(), listEntity);
        return listEntity;
    }

    public Optional<ListEntity> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<ListEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    public boolean existsById(Long id) {
        return store.containsKey(id);
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

    // Helper for getting lists under a board
    public List<ListEntity> findByBoardId(Long boardId) {
        List<ListEntity> result = new ArrayList<>();

        for (ListEntity listEntity : store.values()) {
            if (listEntity.getBoard() != null
                    && listEntity.getBoard().getId() != null
                    && listEntity.getBoard().getId().equals(boardId)) {

                result.add(listEntity);
            }
        }

        return result;
    }
}