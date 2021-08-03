package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import control.CDirectory;
import control.CGangjwa;
import dataBase.SugangDatabase;
import adapter.ListViewAdapter;
import valueObject.VDirectory;
import valueObject.VGangjwa;
import java.util.ArrayList;
import java.util.Vector;

public class SugangActivity extends AppCompatActivity {

    public static String userId;
    private ListView listView;


    private Vector<VDirectory> vcampusDirectorys;
    private Vector<VDirectory> vcolleageDirectorys;
    private Vector<VDirectory> vhakgwaDirectorys;
    private Vector<VGangjwa> vGangjwas;

    private ListViewAdapter listViewAdapter;

    private String fileName;

    SugangDatabase sugangDatabase;
    Spinner Campus;
    Spinner Colleage;
    Spinner Hakgwa;
    Button cancel, sugangList,gabang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugang);

        sugangDatabase = SugangDatabase.getInstance(getApplicationContext());

        Campus = (Spinner) findViewById(R.id.Campus);
        Colleage = (Spinner) findViewById(R.id.Colleage);
        Hakgwa = (Spinner) findViewById(R.id.Hakgwa);
        cancel = (Button) findViewById(R.id.cancelbutton);
        sugangList = (Button) findViewById(R.id.sugangList);
        gabang = (Button) findViewById(R.id.gabang);

        listView = (ListView)findViewById(R.id.listView);

        vcampusDirectorys = new Vector<VDirectory>();
        vcolleageDirectorys = new Vector<VDirectory>();
        vhakgwaDirectorys = new Vector<VDirectory>();
        vGangjwas = new Vector<VGangjwa>();

        Intent intent = getIntent();
        String userid = intent.getExtras().getString("id");
        this.userId = userid;

        this.fileName = "root";

        this.fileName = getModelData(this.fileName, Campus, getApplicationContext());

        Campus.setOnItemSelectedListener(Selectedlistener);
        Colleage.setOnItemSelectedListener(Selectedlistener);
        Hakgwa.setOnItemSelectedListener(Selectedlistener);

        sugangList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SincheongList.class);
                intent.putExtra("id", userId);
                startActivity(intent);
            }
        });

        gabang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MiridamgiList.class);
                intent.putExtra("id", userId);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(v -> finish());
    }


        private Vector<VDirectory> vDirectories;

        private AdapterView.OnItemSelectedListener Selectedlistener = new AdapterView.OnItemSelectedListener() {
            private String fileName;

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (parent.getId()){
                    case R.id.Campus:
                        this.fileName = getSelectedFileName("campus", position, vcampusDirectorys);
                        getModelData(this.fileName, Colleage, getApplicationContext());
                        break;

                    case R.id.Colleage:
                        this.fileName = getSelectedFileName("colleage", position,vcolleageDirectorys);
                        getModelData(this.fileName, Hakgwa, getApplicationContext());
                        break;
                    case R.id.Hakgwa:
                        this.fileName = getSelectedFileName("hakgwa", position,vhakgwaDirectorys);
                        getModelData_list(this.fileName);

                        break;
                    default:
                        this.fileName = getSelectedFileName("", position, vDirectories);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        public void getModelData_list(String fileName) {


            CGangjwa cGangjwa = new CGangjwa();
            Vector<VGangjwa> vGangjwas = new Vector<VGangjwa>();

            for(int i=0; i < vhakgwaDirectorys.size(); i++ ) {
                vGangjwas = cGangjwa.getData(getApplicationContext(),fileName);
            }

            ArrayList<VGangjwa> list = new ArrayList<>();
            for(int i=0; i < vGangjwas.size(); i++) {
                list.add(vGangjwas.get(i));
            }

            listViewAdapter = new ListViewAdapter(getApplicationContext(), list, this);
            listView.setAdapter(listViewAdapter);
        }

        public String getSelectedFileName(String mode, int position, Vector<VDirectory> a) {
            String selectedFileName;

            if ( mode != "" ) {
                selectedFileName = a.get(position).getFileName();
            } else {
                selectedFileName = this.vDirectories.get(position).getFileName();
            }
            return selectedFileName;
        }

        public String getModelData(String fileName, Spinner data, Context context) {

            CDirectory cDirectory = new CDirectory();
            if ( fileName.equals("root") ) {
                vcampusDirectorys = cDirectory.getData(context, fileName); }
            else if (data.equals(Colleage)) {
                vcolleageDirectorys = cDirectory.getData(context, fileName); }
            else if (data.equals(Hakgwa) ) {
                vhakgwaDirectorys = cDirectory.getData(context, fileName); }

            this.vDirectories = cDirectory.getData(context, fileName);

            Vector<String> row = new Vector<String>();
            for (VDirectory vDirectory : vDirectories) {
                row.add(vDirectory.getName());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, row);
            data.setAdapter(adapter);

            String selectedFileName = null;
            if (vDirectories.size() > 0) {
                selectedFileName = vDirectories.get(0).getFileName();
            }
            return selectedFileName;
        }


    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림");
        builder.setMessage("메뉴 화면으로 돌아가시겠습니까?");
        builder.setNegativeButton("취소", null);
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}