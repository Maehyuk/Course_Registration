package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dataBase.CommunityDatabase;
import dataBase.UserDatabase;

public class WriteActivity extends AppCompatActivity {

    EditText Textname, Texttitle, Textcontent;
    Button backCommunity, writeFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Textname = findViewById(R.id.Textname);
        Texttitle = findViewById(R.id.Texttitle);
        Textcontent = findViewById(R.id.Textcontent);
        backCommunity = findViewById(R.id.backCommunity);
        writeFinish =findViewById(R.id.writeFinish);


        backCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
                startActivity(intent);
            }
        });

        writeFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Textname.equals("") && Texttitle.equals("") && Textcontent.equals("")){
                    Toast.makeText(getApplicationContext(), "모두 입력해주세요", Toast.LENGTH_SHORT).show();
                } else{
                    String name = Textname.getText().toString();
                    String title = Texttitle.getText().toString();
                    String content = Textcontent.getText().toString();

                    CommunityDatabase communityDatabase = CommunityDatabase.getInstance(getApplicationContext());

                    ContentValues addRowValue = new ContentValues();
                    addRowValue.put("name", name);
                    addRowValue.put("title", title);
                    addRowValue.put("content", content);
                    communityDatabase.insert(addRowValue);

                    Toast.makeText(getApplicationContext(), "등록했습니다.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), CommunityActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }


}