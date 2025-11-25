package com.KanBanProject.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.KanBanProject.entity.Board;
import com.KanBanProject.service.BoardService;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/boards/{id}")
    public Board getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @PostMapping("/boards")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }
    
}
