package com.KanBanProject.service;

import org.springframework.stereotype.Service;
import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.repository.BoardRepository;
import com.KanBanProject.repository.ListEntityRepository;
import com.KanBanProject.entity.Board;

@Service
public class ListEntityService {
    private final ListEntityRepository listEntityRepository;
    private final BoardRepository boardRepository;

    public ListEntityService(ListEntityRepository listEntityRepository,
                         BoardRepository boardRepository) {
    this.listEntityRepository = listEntityRepository;
    this.boardRepository = boardRepository;
}

    public ListEntity getListEntity(Long id) {
        ListEntity listEntity =  listEntityRepository.findById(id);
        if (listEntity == null) {
            throw new IllegalArgumentException("There's no List with id: " + id);
        }
        return listEntity;
    }

    public ListEntity createListEntity(Long boardId, ListEntity listEntity) {
    if (listEntity == null) {
        throw new IllegalArgumentException("List is missing");
    }
    if (listEntity.getName() == null) {
        throw new IllegalArgumentException("Name is missing");
    }

    Board board = boardRepository.findById(boardId);
    if (board == null) {
        throw new IllegalArgumentException("Board with id: " + boardId + " doesn't exist");
    }

    listEntity.setBoard(board);
    board.getLists().add(listEntity);
    
        return listEntityRepository.save(listEntity);
    }
}
