package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import control.CGangjwa;
import adapter.MiridamgiListAdapter;

import valueObject.VGangjwa;

import java.util.ArrayList;
import java.util.Vector;

public class MiridamgiList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miridamgi_list);

        ListView miridamgiList = findViewById(R.id.miridamgiList);
        Button button_1 = findViewById(R.id.button_1);


        Intent intent = getIntent();
        String userId = intent.getExtras().getString("id");

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();
        CGangjwa cGangjwa = new CGangjwa();
        vGangjwas = cGangjwa.getDataMiridamgi(getApplicationContext(), userId);

        ArrayList<VGangjwa> list = new ArrayList<VGangjwa>();

        for(int i=0; i < vGangjwas.size(); i++ ) {
            list.add(vGangjwas.get(i));
        }

        MiridamgiListAdapter miridamgiListAdapter = new MiridamgiListAdapter(getApplicationContext(), list, this);
        miridamgiList.setAdapter(miridamgiListAdapter);
    }
}