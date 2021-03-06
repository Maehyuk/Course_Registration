package org.techtown.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import control.CLogin;
import dataBase.UserDatabase;
import valueObject.VLogin;

public class MainActivity extends AppCompatActivity {

    Button registerButton,loginButton,foundIDButton, foundPWButton,delete;
    EditText dialogName, dialogNumber, dialogUserid, dialogNumber2;
    LinearLayout dialogView, dialogView2;
    UserDatabase databaseManager;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseManager = UserDatabase.getInstance(getApplicationContext());


        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),DeleteActivity.class);
                startActivity(intent);
            }
        });

        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 0;
                Intent intent = new Intent(getApplication(),RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton = findViewById(R.id.editFoundPW);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

        foundIDButton = findViewById(R.id.foundIDButton);
        foundIDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builderID();
            }
        });

        foundPWButton = findViewById(R.id.foundPWButton);
        foundPWButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builderPW();
            }
        });
    }

    private void Login() {
        EditText editTextID = (EditText)findViewById(R.id.editTextID);
        String userID = editTextID.getText().toString();

        EditText pwEdit = (EditText)findViewById(R.id.editTextPW);
        String password = pwEdit.getText().toString();

        VLogin vLogin = new VLogin(userID,password);

        CLogin cLogin = new CLogin();
        boolean bResult = cLogin.getLogin(vLogin, getApplicationContext());


        if(bResult){
            this.i = 0;
            Toast.makeText(MainActivity.this, "????????? ??????",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplication(), MenuActivity.class);
            intent.putExtra("name", vLogin.getName());
            intent.putExtra("id", vLogin.getUserId());
            intent.putExtra("pw", vLogin.getPassword());
            intent.putExtra("number", vLogin.getNumber());
            startActivity(intent);

            editTextID.setText(null);
            pwEdit.setText(null);


        } else{
                Toast.makeText(MainActivity.this, "????????? ??????", Toast.LENGTH_SHORT).show();
                i++;

                if(i==2){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("2??? ????????? ??????");
                    builder.setMessage("3??? ????????? ?????? ??? ????????? ???????????????.");
                    builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }

                if(i==3){
                    Intent intent = new Intent(getApplicationContext(), LoginErrorActivity.class);
                    startActivity(intent);
                    editTextID.setText(null);
                    pwEdit.setText(null);
                    this.i = 0;
                }
        }
    }

    private void builderID(){
        dialogView = (LinearLayout) View.inflate(getApplicationContext(), R.layout.activity_idfound,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder builderNext = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("????????? ??????");
        builder.setMessage("????????? ????????? ???????????????");

        builder.setView(dialogView);

        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialogName = (EditText) dialogView.findViewById(R.id.editFive);
                dialogNumber = (EditText) dialogView.findViewById(R.id.editSix);

                String valueName = dialogName.getText().toString();
                String valueNumber = dialogNumber.getText().toString();

                CLogin cLogin = new CLogin();
                String foundID = cLogin.foundID(valueName, valueNumber, getApplicationContext());

                if (foundID != null) {
                    builderNext.setTitle("??????");
                    builderNext.setMessage("????????????" + "  " + foundID + "  " + "?????????");
                    builderNext.setPositiveButton("??????", null);
                    builderNext.show();
                } else {
                    Toast.makeText(MainActivity.this, "?????? ????????? ???????????? ???????????? ????????????", Toast.LENGTH_LONG).show();
                }
                if (dialogName.length()==0 && dialogNumber.length()==0) {
                        Toast.makeText(MainActivity.this, "?????? ??????????????????", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    private void builderPW() {
        dialogView2 = (LinearLayout) View.inflate(getApplicationContext(), R.layout.activity_pwfound,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        AlertDialog.Builder builderNext = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("???????????? ??????");
        builder.setMessage("???????????? ????????? ???????????????");

        builder.setView(dialogView2);

        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialogUserid = (EditText) dialogView2.findViewById(R.id.editThree);
                dialogNumber2 = (EditText) dialogView2.findViewById(R.id.editFour);

                String valueUserID = dialogUserid.getText().toString();
                String valueNumber2 = dialogNumber2.getText().toString();

                CLogin cLogin = new CLogin();
                String foundPW= cLogin.foundPW(valueUserID, valueNumber2, getApplicationContext());

                if (foundPW != null) {
                    builderNext.setTitle("??????");
                    builderNext.setMessage("???????????????" + "  " + foundPW + "  " + "?????????");
                    builderNext.setPositiveButton("??????", null);
                    builderNext.show();
                } else {
                    Toast.makeText(MainActivity.this, "?????? ????????? ???????????? ??????????????? ????????????", Toast.LENGTH_SHORT).show();
                }

                if (dialogUserid.length()==0 && dialogNumber2.length()==0) {
                        Toast.makeText(MainActivity.this, "?????? ??????????????????", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("??????");
        builder.setMessage("?????? ?????????????????????????");
        builder.setNegativeButton("??????", null);
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                System.exit(0);
            }
        });
        builder.show();
    }
}