package com.KanBanProject.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public long id;
    public long listId;
    public String name;
    public String description;
    private int position;  //for task immigration between lists


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getListId() {
        return listId;
    }

    public void setListId(long listId) {
        this.listId = listId;
    }

    //for task immigration between lists

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

}

