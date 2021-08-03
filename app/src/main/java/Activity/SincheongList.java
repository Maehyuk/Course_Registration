package org.techtown.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import control.CGangjwa;
import adapter.SincheongListAdapter;
import valueObject.VGangjwa;

import java.util.ArrayList;
import java.util.Vector;

public class SincheongList extends AppCompatActivity {

    int hakjum=0;
    Button checkH;
    ListView sugangList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincheong_list);

        sugangList = findViewById(R.id.sugangList);
        Button button = findViewById(R.id.button);
        checkH = findViewById(R.id.checkH);

        Intent intent = getIntent();
        String userId= intent.getExtras().getString("id");

        Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
        CGangjwa cGangjwa = new CGangjwa();
        vGangjwas = cGangjwa.getDataSugangSincheong(getApplicationContext(), userId);

        ArrayList<VGangjwa> list = new ArrayList<VGangjwa>();

        for(int i=0; i < vGangjwas.size(); i++ ) {
            list.add(vGangjwas.get(i));

            if(list.get(i).getCredit().equals("2")){
                hakjum += 2;
            } else if (list.get(i).getCredit().equals("3")){
                hakjum += 3;
            } else if (list.get(i).getCredit().equals("4")){
                hakjum += 4;
            }
        }

        SincheongListAdapter sincheongListAdapter = new SincheongListAdapter(getApplicationContext(), list, this, hakjum);
        sugangList.setAdapter(sincheongListAdapter);

        checkH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builderNext = new AlertDialog.Builder(SincheongList.this);

                builderNext.setTitle("현재 학점 확인");
                builderNext.setMessage("현재 학점은" +" "+ hakjum + "학점 입니다.");
                builderNext.setPositiveButton("확인", null);
                builderNext.show();

                if(hakjum<=9){
                    Toast.makeText(getApplicationContext(),"최소 수강 학점은 9학점 이상입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}