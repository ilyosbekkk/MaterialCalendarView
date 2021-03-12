package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateLongClickListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);

        calendarView.setSelectionMode (MaterialCalendarView.SELECTION_MODE_NONE);




        calendarView.setDateSelected(CalendarDay.from(2021,3,8), true);
        calendarView.setDateSelected(CalendarDay.from(2021,3,9), true);

        calendarView.addDecorators();


        calendarView.setOnDateLongClickListener((widget, date) -> {
            Toast.makeText(this, date.toString(), Toast.LENGTH_SHORT).show();
        });








    }
}