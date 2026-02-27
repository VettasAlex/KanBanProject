package com.KanBanProject.repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.Board;

@Repository
public class BoardRepository {

    // ConcurrentHashMap makes read/write operations thread-safe
    // because Spring Boot handles multiple requests in parallel.
    private final Map<Long, Board> store = new ConcurrentHashMap<>();

    // used AtomicLong for Thread-safe auto-incrementing ID generation
    private final AtomicLong idGen = new AtomicLong(0);

    public Board save(Board board) {

        // Simulate auto-increment behavior (like a db would do)
        if (board.getId() == null) {
            board.setId(idGen.incrementAndGet());
        }

        store.put(board.getId(), board);
        return board;
    }

    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    public boolean existsById(Long id) {
        return store.containsKey(id);
    }

    public void deleteById(Long id) {
        store.remove(id);
    }
}