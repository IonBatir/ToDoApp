package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDosAdapter extends RecyclerView.Adapter<ToDosAdapter.ToDoViewHolder> {
    private ArrayList<ToDo> toDos;
    private ItemClickListener mClickListener;

    public class ToDoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        TextView dateTextView;
        CheckBox completeCheckbox;

        public ToDoViewHolder(View view) {
            super(view);

            view.setOnClickListener(this);

            titleTextView = view.findViewById(R.id.titleTextView);
            dateTextView = view.findViewById(R.id.dateTextView);
            completeCheckbox = view.findViewById(R.id.completeCheckBox);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public ToDosAdapter(ArrayList<ToDo> toDos) {
        this.toDos = toDos;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_item, parent, false);

        return new ToDoViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        ToDo toDo = toDos.get(position);
        holder.titleTextView.setText(toDo.getTitle());
        holder.dateTextView.setText(toDo.getFormattedDate());
        holder.completeCheckbox.setChecked(toDo.isCompleted());
    }

    @Override
    public int getItemCount() {
        return toDos.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
