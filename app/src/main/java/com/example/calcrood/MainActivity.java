package com.example.calcrood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

enum Operator {
    ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
}

public class MainActivity extends AppCompatActivity {

    TextView textView, textView2;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnClean, btnInfo, btnBack, btnDivi, btnMulti, btnSub, btnPlus, btnIgual, btnDot;

    private String numbersA;
    private String operator;

    private Double calcResult(Double numbersA, Double numbersB, Operator operator) {
        switch (operator) {
            case ADDITION:
                return numbersA + numbersB;
            case SUBTRACTION:
                return numbersA - numbersB;
            case MULTIPLICATION:
                return numbersA * numbersB;
            case DIVISION:
                if (numbersB != 0) {
                    return numbersA / numbersB;
                }
            default:
                return Double.NaN;
        }
    }
    private String getNumbersB(Operator operator) {
        String numbersB = null;

        String idxTextView = textView.getText().toString();
        String operatorStr = "";

        switch (operator) {
            case ADDITION:
                operatorStr = "+";
                break;
            case SUBTRACTION:
                operatorStr = "-";
                break;
            case MULTIPLICATION:
                operatorStr = "᙮";
                break;
            case DIVISION:
                operatorStr = "÷";
                break;
        }

        int idxOperator = idxTextView.indexOf(operatorStr);

        if (idxOperator != -1 && idxOperator < idxTextView.length() - 1) {
            numbersB = idxTextView.substring(idxOperator + 1);
        }

        return numbersB;
    }


    private void viewNumber(String number){
        if (number.equals(textView.getText())) {
            textView.append(number);
        } else {
            textView.setText("0");
        }
    }
    private void handleOperatorClick(Operator operator, String simbolo ) {
        numbersA = String.valueOf(textView.getText());
        this.operator = String.valueOf(operator);
        textView.append(simbolo);
    }
    private void handleNumeroCick(String numero){
        if("0".equals(textView.getText())){
            textView.setText(numero);
        }else {
            textView.append(numero);
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

        View.OnClickListener numeroClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                handleNumeroCick(((Button) view).getText().toString());
            }
        };

        btn0.setOnClickListener(numeroClickListener);
        btn1.setOnClickListener(numeroClickListener);
        btn2.setOnClickListener(numeroClickListener);
        btn3.setOnClickListener(numeroClickListener);
        btn4.setOnClickListener(numeroClickListener);
        btn5.setOnClickListener(numeroClickListener);
        btn6.setOnClickListener(numeroClickListener);
        btn7.setOnClickListener(numeroClickListener);
        btn8.setOnClickListener(numeroClickListener);
        btn9.setOnClickListener(numeroClickListener);

        Map<Button, Operator> operatorMap = new HashMap<>();
        operatorMap.put(btnPlus, Operator.ADDITION);
        operatorMap.put(btnSub, Operator.SUBTRACTION);
        operatorMap.put(btnMulti, Operator.MULTIPLICATION);
        operatorMap.put(btnDivi, Operator.DIVISION);

        View.OnClickListener operatorClickListener = new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Operator operator1 = operatorMap.get(view);
                String simbolo = ((Button) view).getText().toString();
                handleOperatorClick(operator1, simbolo);
            }
        };

        btnPlus.setOnClickListener(operatorClickListener);
        btnSub.setOnClickListener(operatorClickListener);
        btnMulti.setOnClickListener(operatorClickListener);
        btnDivi.setOnClickListener(operatorClickListener);

        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                textView2.setText("");
                numbersA = "";
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("0".equals(textView.getText())){
                    textView.setText(".");
                }else {
                    textView.append(".");
                }
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
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroB = getNumbersB(Operator.valueOf(operator));

                if (numeroB != null) {
                    textView2.setText(textView.getText().toString());

                    Double numA = Double.parseDouble(numbersA);
                    Double numB = Double.parseDouble(numeroB);

                    Double resultado = calcResult(numA, numB, Operator.valueOf(operator));
                    textView.setText(String.valueOf(resultado));
                }

                numbersA = "";
                operator = "";
            }
        });


    }
}