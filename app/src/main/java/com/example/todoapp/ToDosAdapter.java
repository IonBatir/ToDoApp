package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDosAdapter extends RecyclerView.Adapter<ToDosAdapter.ToDoViewHolder> {
    private ArrayList<ToDo> toDos;

    public static class ToDoViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView dateTextView;

        public ToDoViewHolder(View view) {
            super(view);

            this.titleTextView = view.findViewById(android.R.id.text1);
            this.dateTextView = view.findViewById(android.R.id.text2);
        }
    }

    public ToDosAdapter(ArrayList<ToDo> toDos) {
        this.toDos = toDos;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);

        ToDoViewHolder toDoViewHolder = new ToDoViewHolder(listItemView);
        return toDoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo toDo = toDos.get(position);
        holder.titleTextView.setText(toDo.getTitle());
        holder.dateTextView.setText(toDo.getDate().toString());
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }
}
