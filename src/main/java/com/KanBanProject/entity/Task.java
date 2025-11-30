package com.KanBanProject.entity;

public class Task {
    public long id;
    public long tasksId;
    public String name;
    public String description;

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

