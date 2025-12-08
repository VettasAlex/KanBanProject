package com.KanBanProject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.Board;

@Repository
public class BoardRepository { //Temporary Repository until JPA
    private List<Board> boards = new ArrayList<>();

    public Board findById(Long id) {
        for (Board board : boards) {
            if (board.getId().equals(id)) {
                return board;
            }
        }
        System.out.println("No Board found with ID: " + id);
        return null;
    }

    private Long nextId = 1L;
    
    public Board save(Board board) {
        if (board.getId() == null) {
            board.setId(nextId);
            nextId++;
        }
        
        boards.add(board);
        return board;
    }
}


