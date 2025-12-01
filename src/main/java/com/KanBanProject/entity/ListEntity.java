package com.KanBanProject.entity;

import java.util.List;

public class ListEntity {
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


