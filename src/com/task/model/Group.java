package com.task.model;


public class Group{

    private Task[] list;
    private String name;
    private int groupSize;
    private int groupMax;

    public Group(String name){
        this.name = name;
        groupMax = 16;
        list = new Task[groupMax];
        groupSize = 0;
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
        Task task = new Task(taskName);
        list[groupSize] = task;

        groupSize++;

        if (groupSize > groupMax){
            aumentaMax();
        }
    }



    private void aumentaMax(){
        groupMax = groupMax + 16;
        Task[] newList = new Task[groupMax];

        System.arraycopy(list, 0, newList, 0, list.length);
        
        list = newList;
    }


}