package com.KanBanProject.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.KanBanProject.entity.Board;
import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.service.BoardService;
import com.KanBanProject.service.ListEntityService;

@RestController
public class BoardController {

    private final BoardService boardService;
    private final ListEntityService listService;

    public BoardController(BoardService boardService, ListEntityService listService) {
        this.boardService = boardService;
        this.listService = listService;
    }

    @GetMapping("/boards/{id}")
    public Board getBoard(@PathVariable Long id) {     
        return boardService.getBoard(id);
    }

    @PostMapping("/boards")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    
    @PostMapping("/boards/{boardId}/lists")
    public ListEntity createListEntity(@PathVariable Long boardId,@RequestBody ListEntity listEntity) {
    return listService.createListEntity(boardId, listEntity);
    }
}
