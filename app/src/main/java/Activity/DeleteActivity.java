package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import control.CUser;

public class DeleteActivity extends AppCompatActivity {

    EditText id, pw;
    Button delete, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        id = findViewById(R.id.editOne);
        pw = findViewById(R.id.editTwo);
        delete = findViewById(R.id.delete_2);
        back = findViewById(R.id.back_2);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id_1 = id.getText().toString();
                String pw_2 = pw.getText().toString();

                CUser cUser = new CUser();
                boolean found = cUser.delete(id_1,pw_2,getApplicationContext());

                if(found){
                    Toast.makeText(DeleteActivity.this, "회원탈퇴 완료",Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(DeleteActivity.this, "해당하는 정보가 없습니다",Toast.LENGTH_LONG).show();

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}