package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlusActivity extends AppCompatActivity {

    Button seoulCall,yonginCall,cancel,calculator, calendar ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        seoulCall = findViewById(R.id.seoulCall);
        yonginCall = findViewById(R.id.yonginCall);
        cancel = findViewById(R.id.cancel);
        calculator = findViewById(R.id.calculator);
        calendar = findViewById(R.id.calendar);

        Intent intent = getIntent();
        String userID = intent.getExtras().getString("id");


        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CalendarActivity.class);
                intent.putExtra("userID",userID);
                startActivity(intent);
            }
        });


        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CalculatorActivity.class);
                startActivity(intent);
            }
        });


        seoulCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:023001700"));
                startActivity(mIntent);
            }
        });

        yonginCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0313222459"));
                startActivity(mIntent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}