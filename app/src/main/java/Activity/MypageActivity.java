package org.techtown.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import control.CLogin;
import control.CUser;

public class MypageActivity extends AppCompatActivity {

    EditText id, pw, number, name;
    Button back, refact;
    CheckBox checkBox;
    LinearLayout dialogView;
    String id_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        name = (EditText)findViewById(R.id.name_list);
        id = (EditText)findViewById(R.id.id_list);
        pw = (EditText)findViewById(R.id.pw);
        number = (EditText)findViewById(R.id.number);

        back = findViewById(R.id.back);
        refact = findViewById(R.id.refact);

        checkBox = (CheckBox)findViewById(R.id.checkBox);

        Intent intent = getIntent();
        String name_1 = intent.getExtras().getString("name");
        this.id_1 = intent.getExtras().getString("id");
        String pw_1 = intent.getExtras().getString("pw");
        String number_1 = intent.getExtras().getString("number");

        name.setText(name_1);
        name.setEnabled(false);

        id.setText(id_1);
        id.setEnabled(false);

        pw.setText(pw_1);
        pw.setEnabled(false);

        number.setText(number_1);
        number.setEnabled(false);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        refact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePW();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                } else {
                    pw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
    public void changePW(){

        dialogView = (LinearLayout) View.inflate(getApplicationContext(), R.layout.refactpw,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(MypageActivity.this);
        AlertDialog.Builder builderNext = new AlertDialog.Builder(MypageActivity.this);

        builder.setTitle("비밀번호 변경");
        builder.setMessage("모두 입력해주세요");

        builder.setView(dialogView);

        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                EditText nowpw = (EditText) dialogView.findViewById(R.id.nowpw);
                EditText changepw = (EditText) dialogView.findViewById(R.id.changepw);

                String nowpw_1 = nowpw.getText().toString();
                String changepw_1 = changepw.getText().toString();

                CUser cUser = new CUser();
                boolean changePW = cUser.changePW(id_1, nowpw_1, changepw_1, getApplicationContext());

                if (changePW) {
                    builderNext.setTitle("알림");
                    builderNext.setMessage("변경했습니다. 다시 로그인해주세요");
                    builderNext.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);

                        }
                    });
                    builderNext.show();
                }

                else {
                    Toast.makeText(MypageActivity.this, "현재 비밀번호를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                }

            }
        });

        builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

    public void onBackPressed(){
                finish();
    }
}