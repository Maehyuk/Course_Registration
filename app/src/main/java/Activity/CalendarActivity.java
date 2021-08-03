package org.techtown.finalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    TextView diaryText, textView27;
    Button backback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = findViewById(R.id.calendarView);
        diaryText = findViewById(R.id.diaryText);
        textView27 = findViewById(R.id.textView27);
        backback = findViewById(R.id.backback);

        Intent intent = getIntent();
        String userID = intent.getExtras().getString("userID");

        textView27.setText(userID + "님의 달력");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                int realMonth = month+1;
                diaryText.setText(String.format(year +"/"+ realMonth +"/"+ dayOfMonth));
            }
        });

        backback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}