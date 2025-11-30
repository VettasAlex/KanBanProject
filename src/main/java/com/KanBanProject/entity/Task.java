package com.KanBanProject.entity;

public class Task {
    public long id;
    public long tasksId;
    public String name;
    public String description;
    private int position;
    
        //for task immigration between lists



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


    //for task immigration between lists
    
    public void setPos(int position) {
        this.position = position;
    }

    public int getPos() {
        return position;
    }

    
    

}

