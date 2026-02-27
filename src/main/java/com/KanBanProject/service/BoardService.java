package com.KanBanProject.service;

import org.springframework.stereotype.Service;

import com.KanBanProject.entity.Board;
import com.KanBanProject.repository.BoardRepository;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Didn't find any board with id: " + id));

        return board;
    }

    public Board createBoard(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name's missing");
        }

        Board board = new Board();
        board.setName(name);

        Board savedBoard = boardRepository.save(board);
        return savedBoard;
    }
}