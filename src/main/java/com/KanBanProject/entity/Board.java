package com.KanBanProject.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Board {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "board")
    private List<ListEntity> lists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

     public long getId() {
        return id;
    }
}


