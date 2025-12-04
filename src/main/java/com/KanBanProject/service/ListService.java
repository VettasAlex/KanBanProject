package com.KanBanProject.service;

import org.springframework.stereotype.Service;

import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.repository.ListEntityRepository;

@Service
public class ListService {
    private final ListEntityRepository listEntityRepository;

    public ListService(ListEntityRepository listEntityRepository) {
        this.listEntityRepository = listEntityRepository;
    }

    public ListEntity getListEntity(Long id) {
        ListEntity listEntity =  listEntityRepository.findById(id);
        if (listEntity == null) {
            throw new IllegalArgumentException("There's no List with id: " + id);
        }
        return listEntity;
    }

    public ListEntity createList(Long boardId, ListEntity listEntity) {
    // temporary placeholder logic
    return null;
    }
}
