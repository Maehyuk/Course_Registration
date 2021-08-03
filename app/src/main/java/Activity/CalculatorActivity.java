package org.techtown.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private String func = "+";
    private int firstNumber;

    TextView textNumber;
    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,nequal,nc,ndiv,nmultiple,nminus,nplus,backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textNumber= findViewById(R.id.textNumber);


        n1= findViewById(R.id.n1);
        n2= findViewById(R.id.n2);
        n3= findViewById(R.id.n3);
        n4= findViewById(R.id.n4);
        n5= findViewById(R.id.n5);
        n6= findViewById(R.id.n6);
        n7= findViewById(R.id.n7);
        n8= findViewById(R.id.n8);
        n9= findViewById(R.id.n9);
        n0= findViewById(R.id.n0);
        nequal= findViewById(R.id.nequal);
        nc= findViewById(R.id.nc);
        ndiv= findViewById(R.id.ndiv);
        nmultiple= findViewById(R.id.nmultiple);
        nminus= findViewById(R.id.nminus);
        nplus= findViewById(R.id.nplus);
        backButton= findViewById(R.id.backButton);

        textNumber.setText("0");

        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curr = (String) textNumber.getText();

                if (curr.equals("0")) {
                    textNumber.setText(curr);
                } else {
                    textNumber.setText(textNumber.getText() + "0");
                }
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("1");
                } else {
                    textNumber.setText(textNumber.getText() + "1");
                }
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textNumber.getText() == "0") {
                    textNumber.setText("2");
                } else {
                    textNumber.setText(textNumber.getText() + "2");
                }
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("3");
                } else {
                    textNumber.setText(textNumber.getText() + "3");
                }
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("4");
                } else {
                    textNumber.setText(textNumber.getText() + "4");
                }
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("5");
                } else {
                    textNumber.setText(textNumber.getText() + "5");
                }
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("6");
                } else {
                    textNumber.setText(textNumber.getText() + "6");
                }
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("7");
                } else {
                    textNumber.setText(textNumber.getText() + "7");
                }
            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("8");
                } else {
                    textNumber.setText(textNumber.getText() + "8");
                }
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNumber.getText() == "0") {
                    textNumber.setText("9");
                } else {
                    textNumber.setText(textNumber.getText() + "9");
                }
            }
        });

        nplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Integer.parseInt((String) textNumber.getText());
                textNumber.setText("0");

                func = "+";
            }
        });

        ndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Integer.parseInt((String) textNumber.getText());
                textNumber.setText("0");

                func = "/";
            }
        });

        nminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Integer.parseInt((String) textNumber.getText());
                textNumber.setText("0");

                func = "-";
            }
        });

        nmultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumber = Integer.parseInt((String) textNumber.getText());
                textNumber.setText("0");

                func = "X";
            }
        });

        nc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textNumber.setText("0");
            }
        });

        nequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (func == "+") {
                    int Value = Integer.parseInt((String) textNumber.getText());
                    textNumber.setText((firstNumber + Value) + "");

                } else if (func == "-") {
                    int Value = Integer.parseInt((String) textNumber.getText());
                    textNumber.setText((firstNumber - Value) + "");

                } else if (func == "X") {
                    int Value = Integer.parseInt((String) textNumber.getText());
                    textNumber.setText((firstNumber * Value) + "");

                } else if (func == "/") {
                    double Value = Integer.parseInt((String) textNumber.getText());
                    textNumber.setText((firstNumber / Value) + "");

                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });








    }
}