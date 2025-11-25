package com.KanBanProject.repository;

import org.springframework.stereotype.Repository;

import com.KanBanProject.entity.ListEntity;

@Repository
public class ListEntityRepository {

    public ListEntity findById(Long Id) {
        return null; // implement later
    }
    
    // Placeholder save method to fix the issue i guess
    public ListEntity save(ListEntity listEntity) {
        return listEntity; // placeholder
    }
}
