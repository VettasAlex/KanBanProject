package com.KanBanProject.entity;

public class Task {
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

