package org.techtown.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {


    ImageView sugangView, homepageView, mypageView, noteView, plusView, logout;
    TextView welcomeView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        welcomeView = (TextView) findViewById(R.id.welcomeView);
        sugangView = (ImageView)findViewById(R.id.sugangView);
        mypageView = (ImageView)findViewById(R.id.mypageView);
        homepageView = (ImageView)findViewById(R.id.homepageView);
        noteView = (ImageView)findViewById(R.id.noteView);
        plusView = (ImageView)findViewById(R.id.plusView);
        logout = (ImageView)findViewById(R.id.logout);


        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String userid = intent.getExtras().getString("id");
        String pw = intent.getExtras().getString("pw");
        String number = intent.getExtras().getString("number");

        welcomeView.setText(name + "님, 환영합니다");



        sugangView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SugangActivity.class);
                intent.putExtra("id", userid);
                startActivity(intent);
            }
        });

        mypageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MypageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("id",userid);
                intent.putExtra("pw",pw);
                intent.putExtra("number",number);
                startActivity(intent);

            }
        });

        homepageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mju.ac.kr/sites/mjukr/intro/intro.html"));
                startActivity(mIntent);
            }
        });

        plusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), PlusActivity.class);
                intent.putExtra("id",userid);
                startActivity(intent);
            }
        });

        noteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplication(), CommunityActivity.class);
                startActivity(intent2);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("로그인 화면으로 돌아가시겠습니까?");
        builder.setNegativeButton("취소", null);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent vintent = new Intent(getApplication(),MainActivity.class);
                startActivity(vintent);
            }
        });
        builder.show();
    }
}