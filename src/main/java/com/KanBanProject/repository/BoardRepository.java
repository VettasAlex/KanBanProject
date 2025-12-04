package com.KanBanProject.repository;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.Board;

@Repository
public class BoardRepository {

    public Board findById(Long Id) {
        return null; // TODO: implement findById
    }
    
    public Board save(Board board) {
        return board; // placeholder
    }
}


