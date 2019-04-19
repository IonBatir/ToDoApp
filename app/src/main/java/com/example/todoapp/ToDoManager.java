package com.example.todoapp;

import java.util.ArrayList;

public class ToDoManager {
    private static ToDoManager manager;
    private ArrayList<ToDo> toDos;

    private ToDoManager() {
        toDos = new ArrayList<>();
    }

    private static ToDoManager getInstance() {
        if (manager == null)
            manager = new ToDoManager();
        return manager;
    }

    public ArrayList<ToDo> getToDos() {
        return toDos;
    }

    public void addToDo(ToDo toDo) {
        toDos.add(toDo);
    }
}
