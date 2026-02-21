package com.KanBanProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.KanBanProject.entity.Board;
import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.service.BoardService;
import com.KanBanProject.service.ListEntityService;

@SpringBootTest
class KanBanProjectSeedSmokeTest {

    @Autowired private BoardService boardService;
    @Autowired private ListEntityService listService;

    @Test
    void seed_creates_board_and_lists_prints_and_asserts() {
        Board savedBoard = boardService.createBoard("Smoke Board");
        Long boardId = savedBoard.getId();

        ListEntity toDo = new ListEntity();
        toDo.setName("Stuff To Do");
        ListEntity savedToDo = listService.createListEntity(boardId, toDo);

        System.out.println("Board id = " + savedBoard.getId());
        System.out.println("List id = " + savedToDo.getId());
        System.out.println("List.board.id = " + (savedToDo.getBoard() != null ? savedToDo.getBoard().getId() : null));
        System.out.println("Board.lists.size = " + (savedBoard.getLists() != null ? savedBoard.getLists().size() : null));
        System.out.println("Board first list name = " + ((savedBoard.getLists() != null && !savedBoard.getLists().isEmpty()) ? savedBoard.getLists().get(0).getName() : null));

        assertNotNull(savedBoard.getId());
        assertNotNull(savedToDo.getId());

        assertNotNull(savedToDo.getBoard());
        assertEquals(savedBoard.getId(), savedToDo.getBoard().getId());

        assertNotNull(savedBoard.getLists());
        assertTrue(savedBoard.getLists().size() >= 1);
    }
}