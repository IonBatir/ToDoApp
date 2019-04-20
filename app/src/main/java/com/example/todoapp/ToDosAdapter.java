package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDosAdapter extends RecyclerView.Adapter<ToDosAdapter.ToDoViewHolder> {
    private ArrayList<ToDo> toDos;
    private ItemClickListener mClickListener;
    private CheckBoxCheckedChangeListener mCheckBoxChangeCheckedListener;

    public class ToDoViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView dateTextView;
        CheckBox completeCheckBox;

        public ToDoViewHolder(final View view) {
            super(view);

            titleTextView = view.findViewById(R.id.titleTextView);
            dateTextView = view.findViewById(R.id.dateTextView);
            completeCheckBox = view.findViewById(R.id.completeCheckBox);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
                }
            });
            completeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (mCheckBoxChangeCheckedListener != null) mCheckBoxChangeCheckedListener.onCheckBoxCheckedChange((CheckBox) buttonView, getAdapterPosition(), isChecked);
                }
            });
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
        holder.completeCheckBox.setChecked(toDo.isCompleted());
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

    public void setCheckBoxClickListener(CheckBoxCheckedChangeListener checkBoxChangeCheckListener) {
        this.mCheckBoxChangeCheckedListener = checkBoxChangeCheckListener;
    }

    public interface CheckBoxCheckedChangeListener {
        void onCheckBoxCheckedChange(CheckBox checkBox, int position, boolean isChecked);
    }
}
