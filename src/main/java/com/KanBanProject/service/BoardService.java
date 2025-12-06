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
        Board board = boardRepository.findById(id);
        if (board == null) {
            throw new IllegalArgumentException("Didn't find any board with id: " + id);
        }
        
        return board;
    }

public Board createBoard(Board board) {
    if (board.getName() == null){
        throw new IllegalArgumentException("Name's missing");
    }
    return null;
    }
}
