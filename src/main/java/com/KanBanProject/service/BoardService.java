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
        return boardRepository.findById(id);
    }

public Board createBoard(Board board) {
    // temporary placeholder logic
    return null;
    }
}
