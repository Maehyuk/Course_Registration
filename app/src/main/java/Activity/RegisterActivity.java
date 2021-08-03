package org.techtown.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import control.CUser;
import dataBase.UserDatabase;


public class RegisterActivity extends AppCompatActivity {
    boolean check=true;

    Button RbackButton, RegisterButton, RcheckButton;
    EditText ReditName, ReditID, ReditPW, ReditCheckPW, ReditNumber;
    CheckBox checkBox2;
    UserDatabase databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseManager = UserDatabase.getInstance(getApplicationContext());

        RbackButton = findViewById(R.id.RbackButton);
        RbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RcheckButton = findViewById(R.id.RcheckButton);
        RcheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IDCheck();
            }
        });

        RegisterButton = findViewById(R.id.RegisterButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register(){
        ReditName = (EditText)findViewById(R.id.ReditName);
        String name = ReditName.getText().toString();

        ReditID = (EditText)findViewById(R.id.ReditID);
        String userId = ReditID.getText().toString();

        ReditPW = (EditText)findViewById(R.id.ReditPW);
        String password = ReditPW.getText().toString();

        ReditCheckPW = (EditText)findViewById(R.id.ReditCheckPW);
        String passCk = ReditCheckPW.getText().toString();

        ReditNumber = (EditText)findViewById(R.id.ReditNumber);
        String number = ReditNumber.getText().toString();

        checkBox2 = findViewById(R.id.checkBox2);

        if(name.equals("") || userId.equals("") || password.equals("") || passCk.equals("") || number.equals("")) {
            alarm("빈 칸을 모두 입력해주세요");
        }
        else if(!(password.equals(passCk))){
            alarm("비밀번호가 서로 일치하지 않습니다.");
        }
        else if(check){
            alarm("중복확인 해주세요");
        } else if(!(checkBox2.isChecked())){
            alarm("개인정보 이용동의 체크하세요");
        }
        else{
            CUser cUser = new CUser();
            cUser.getUser(name,userId,password,number,getApplicationContext());

            Toast.makeText(RegisterActivity.this, "정상적으로 회원등록했습니다.",Toast.LENGTH_SHORT).show();

            finish();
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        }
    }

    private void IDCheck(){
        ReditID = (EditText)findViewById(R.id.ReditID);
        String userId = ReditID.getText().toString();

        CUser cUser = new CUser();
        boolean a = cUser.getCheckID(userId,getApplicationContext());


        if(userId.equals("")){
            alarm("아이디를 입력해주세요");
        } else if(a==false){
            alarm("사용 가능한 아이디입니다.");
            ReditID.setEnabled(false);
            RcheckButton.setEnabled(false);
            check = false;
        } else {
            alarm("중복된 아이디입니다.");
        }
    }

    private void alarm(String context){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setTitle("Information");
        builder.setMessage(context);
        builder.setPositiveButton("확인",null);
        builder.show();
    }
}

