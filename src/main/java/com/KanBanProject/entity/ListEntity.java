package com.KanBanProject.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public long boardId;
    public String name;
    public List<Task> tasks;

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


