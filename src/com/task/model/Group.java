package com.task.model;


public class Group{

    private Task[] list;
    private String name;

    public Group(String name){
        this.name = name;
        list = new Task[16];
    }


    public String getName(){
        return name;
    }

    public Task[] getList(){
        return list;
    }


    public void setName(String name){
        this.name = name;
    }

    public void addTask(String taskName){

    }


}