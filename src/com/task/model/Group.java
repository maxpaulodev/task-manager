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

    public Task getTask(int index){
        if (index < 0 || index >= groupSize) {
            return null;
        }

        return list[index];
    }

    public int getLength(){
        return groupSize;
    }


    public void setName(String name){
        this.name = name;
    }

    public void addTask(String taskName){

        if (groupSize >= groupMax){
            aumentaMax();
        }

        Task task = new Task(taskName);
        list[groupSize] = task;

        groupSize++;
    }

    public void removeTask(int position){

        if(position < 0 || position >= groupSize){
            return;
        }

        for (int i = position; i < groupSize - 1; i++) {
            list[i] = list[i + 1];
        }

        list[groupSize - 1] = null;
        groupSize--;

        if (list.length > 16 && groupSize < groupMax - 16){
            reduzMax();
        }            

    }

    private void aumentaMax(){
        groupMax = groupMax + 16;
        Task[] newList = new Task[groupMax];

        System.arraycopy(list, 0, newList, 0, list.length);
        
        list = newList;
    }

    private void reduzMax(){
        groupMax = groupMax - 16;
        Task[] newList = new Task[groupMax];

        System.arraycopy(list, 0, newList, 0, newList.length);
        
        list = newList;
    }

}