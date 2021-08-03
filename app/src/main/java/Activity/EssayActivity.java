package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EssayActivity extends AppCompatActivity {

    TextView aa, bb, zzz;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("title");
        String content = intent.getExtras().getString("content");
        int click = intent.getExtras().getInt("click");

        aa=findViewById(R.id.aa);
        bb=findViewById(R.id.Linear);
        zzz=findViewById(R.id.zzz);
        button2=findViewById(R.id.button2);

        aa.setText(title);
        bb.setText(content);
        zzz.setText("조회 수 :" + click);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}