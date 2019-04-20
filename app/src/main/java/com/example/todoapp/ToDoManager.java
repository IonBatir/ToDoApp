package com.example.todoapp;

import java.util.ArrayList;

public class ToDoManager {
    private static ToDoManager manager;
    private ArrayList<ToDo> toDos;

    private ToDoManager() {
        toDos = new ArrayList<>();
    }

    static ToDoManager getInstance() {
        if (manager == null)
            manager = new ToDoManager();
        return manager;
    }

    ArrayList<ToDo> getToDos() {
        return toDos;
    }

    public void addToDo(ToDo toDo) {
        toDos.add(toDo);
    }

    public void editToDo(ToDo toDo) {
        int index = -1;
        for (ToDo item : toDos)
            if (item.getUuid().equals(toDo.getUuid())) {
                index = toDos.indexOf(item);
                break;
            }
        toDos.set(index, toDo);
    }

    public void deleteToDo(ToDo toDo) {
        toDos.remove(toDo);
    }
}
