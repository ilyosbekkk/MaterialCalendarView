package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateLongClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    MaterialCalendarView calendarView;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendarView);
        ArrayList<CalendarDay> days = new ArrayList<>();
        ArrayList<CalendarDay> days1 = new ArrayList<>();
        ArrayList<CalendarDay> days2 = new ArrayList<>();

        days.add(CalendarDay.from(2021,3,8));
        days.add(CalendarDay.from(2021,3,10));
        days.add(CalendarDay.from(2021,3,13));
        days.add(CalendarDay.from(2021,3,15));
        days.add(CalendarDay.from(2021,3,16));
        days1.add(CalendarDay.from(2021,3,15));
        days1.add(CalendarDay.from(2021,3,13));
        days2.add(CalendarDay.from(2021,3,14));
        days1.add(CalendarDay.from(2021,3,17));
        days1.add(CalendarDay.from(2021,3,18));
        days2.add(CalendarDay.from(2021,3,19));
        days1.add(CalendarDay.from(2021,3,30));
        days1.add(CalendarDay.from(2021,3,26));
        days2.add(CalendarDay.from(2021,3,23));


        calendarView.addDecorator(new Sample1(1, days, this));
        calendarView.addDecorator(new Sample1(2,  days1,  this));
        calendarView.addDecorator(new Sample1(3,  days2,  this));



        calendarView.setOnDateLongClickListener((widget, date) -> {
            Toast.makeText(this, date.toString(), Toast.LENGTH_SHORT).show();
        });


    }
}

class Sample1 implements DayViewDecorator {

    private int answer_num;
    private final ArrayList<CalendarDay> dates;
    private Context context;

    public Sample1(int level, ArrayList<CalendarDay> dates, Context context) {
        this.answer_num = level;
        this.dates = dates;
        this.context = context;
    }


    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        if (answer_num == 1)
            view.setBackgroundDrawable(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.sample3)));
        else if (answer_num == 2)
            view.setBackgroundDrawable(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.sample2)));
        else
            view.setBackgroundDrawable(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.sample1)));

    }
}