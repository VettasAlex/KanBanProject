package com.KanBanProject.service;

import org.springframework.stereotype.Service;

import com.KanBanProject.entity.ListEntity;
import com.KanBanProject.repository.ListEntityRepository;

@Service
public class ListEntityService {
    private final ListEntityRepository listEntityRepository;

    public ListEntityService(ListEntityRepository listEntityRepository) {
        this.listEntityRepository = listEntityRepository;
    }

    public ListEntity getListEntity(Long id) {
        ListEntity listEntity =  listEntityRepository.findById(id);
        if (listEntity == null) {
            throw new IllegalArgumentException("There's no List with id: " + id);
        }
        return listEntity;
    }

    public ListEntity createListEntity(Long boardId, ListEntity listEntity) {
   // TODO: implement createListEntity
    return null;
    }
}
