package com.KanBanProject.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

import com.KanBanProject.entity.ListEntity;

@Repository
public class ListEntityRepository {

    private List<ListEntity> lists = new ArrayList<>();
private Long nextId = 1L;

    public ListEntity findById(Long Id) {
        for (ListEntity listEntity : lists) {
            if (listEntity.getId() != null && listEntity.getId().equals(Id)) {
                return listEntity;
            }
        }
        System.out.println("No ListEntity found with ID: " + Id);
        return null;
    }
    
    // Placeholder save method to fix the issue i guess
   public ListEntity save(ListEntity listEntity) {

    if (listEntity.getId() == null) {
        listEntity.setId(nextId++);
        lists.add(listEntity);
        return listEntity;
    }

    for (int i = 0; i < lists.size(); i++) {
        if (lists.get(i).getId().equals(listEntity.getId())) {
            lists.set(i, listEntity);
            return listEntity;
        }
    }

    // If someone tries to save an entity with an id that doesn't exist in the repo,
    // we treat it as "new" (or we could throw i guess).
    lists.add(listEntity);
    return listEntity;
    }
}
