package com.example.calcrood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView2;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnClean, btnInfo, btnBack, btnDivi, btnMulti, btnSub, btnPlus, btnIgual, btnDot;

    private String numbersA;
    private String operator;


    private Double calcResult(String numbersA, String numbersB, String operator){

        if (operator.equals("+")) {
            return Double.parseDouble(numbersA) + Double.parseDouble(numbersB);
        } else if (operator.equals("-")) {
            return Double.parseDouble(numbersA) - Double.parseDouble(numbersB);
        } else if (operator.equals("᙮")) {
            return Double.parseDouble(numbersA) * Double.parseDouble(numbersB);
        }

        return Double.parseDouble(numbersA) / Double.parseDouble(numbersB);
    }

    private String getNumbersB(String operator){

        String numbersB = null;

        String idxTextView = textView.getText().toString();
        int idxMais = idxTextView.indexOf(operator);

        if (idxMais != -1 && idxMais < idxTextView.length() - 1) {
            String caracteresAposMais = idxTextView.substring(idxMais + 1);
            numbersB = caracteresAposMais;
        }

        return numbersB;

    }

    private void viewNumber(String number){
        if (textView.getText() != number) {
            textView.append(number);
        } else {
            textView.setText("0");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtView);
        textView2 = findViewById(R.id.txtView2);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);


        btnClean = findViewById(R.id.btnClean);
        btnPlus = findViewById(R.id.btnPlus);
        btnSub = findViewById(R.id.btnSub);
        btnDivi = findViewById(R.id.btnDivi);
        btnMulti = findViewById(R.id.btnMulti);
        btnIgual = findViewById(R.id.btnIgual);
        btnBack = findViewById(R.id.btnBack);

        btnInfo = findViewById(R.id.btnInfo);

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                textView2.setText("");
                numbersA = "";
                getNumbersB(operator);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               viewNumber("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewNumber("9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getText() == "0"){
                    textView.setText(".");
                }else {
                    textView.append(".");
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbersA = String.valueOf(textView.getText());
                operator = "+";
                textView.append("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbersA = String.valueOf(textView.getText());
                operator = "-";
                textView.append("-");
            }
        });

        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbersA = String.valueOf(textView.getText());
                operator = "÷";
                textView.append("÷");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numbersA = String.valueOf(textView.getText());
                operator = "᙮";
                textView.append("᙮");
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView2.setText(textView.getText().toString());

                String number = getNumbersB(operator);

                textView.setText(String.valueOf(calcResult(numbersA, number, operator)));

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtView = textView.getText().toString();
                String novaInfo = txtView.substring(0, txtView.length() -1);

                textView.setText(novaInfo);

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("About");
                builder.setMessage(
                        "Dev:" + "\n" + "Anderson Santos" + "\n" + "\n" +
                        "GitHub:" + "\n" + "https://github.com/anderood"
                );
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}