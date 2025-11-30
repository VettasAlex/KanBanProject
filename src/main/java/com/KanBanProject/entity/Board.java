package com.KanBanProject.entity;

import java.util.List;

public class Board {
    public long id;
    public String name;
    public List<ListEntity> lists;

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


