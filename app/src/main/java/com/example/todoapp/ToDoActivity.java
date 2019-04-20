package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ToDoActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private static final int NOT_FOUND_VALUE = -1;
    ToDo toDo;
    Calendar calendar;
    EditText titleEditText;
    Button dateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        titleEditText = findViewById(R.id.titleEditText);
        dateButton  = findViewById(R.id.dateButton);

        int toDoPosition = getIntent().getIntExtra(MainActivity.EXTRA_TODO_POSITION, NOT_FOUND_VALUE);

        toDo = toDoPosition > NOT_FOUND_VALUE ? ToDoManager.getInstance().getToDos().get(toDoPosition) : null;

        calendar = Calendar.getInstance();

        setTitle(getResources().getString(toDo == null ? R.string.add_todo : R.string.edit_todo));

        if (toDo != null) {
            calendar.setTime(toDo.getDate());
            titleEditText.setText(toDo.getTitle());
            dateButton.setText(toDo.getFormattedDate());
        }

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ToDoActivity.this, ToDoActivity.this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_todo, menu);
        if (toDo == null)
            menu.removeItem(R.id.action_delete);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_save) {
            String toDoTitle = titleEditText.getText().toString();
            Date toDoDate = calendar.getTime();
            if (toDo == null) {
                toDo = new ToDo(toDoTitle, toDoDate);
                ToDoManager.getInstance().addToDo(toDo);
            } else {
                toDo.setTitle(toDoTitle);
                toDo.setDate(toDoDate);
                ToDoManager.getInstance().editToDo(toDo);
            }
        }

        if (id == R.id.action_delete) {
            ToDoManager.getInstance().deleteToDo(toDo);
        }

        NavUtils.navigateUpFromSameTask(this);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        dateButton.setText(DateFormat.getDateInstance().format(calendar.getTime()));
    }
}
