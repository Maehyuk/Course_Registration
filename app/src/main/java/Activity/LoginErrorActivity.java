package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class LoginErrorActivity extends AppCompatActivity {

    public static int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_error);

        count = 0;
        Timer mTimer = new Timer();
        TimerTask mTask = new TimerTask() {

            public void run() {
                finish();
            }
        };

        mTimer.schedule(mTask, 5000);

    }
}