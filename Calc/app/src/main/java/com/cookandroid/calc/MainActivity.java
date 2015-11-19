package com.cookandroid.calc;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnRem;
    TextView textResult;
    String num1, num2;
    float result=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnRem = (Button) findViewById(R.id.BtnRem);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.equals("")|num2.equals("")) Toast.makeText(MainActivity.this,"숫자를 입력하세요",Toast.LENGTH_SHORT).show();

                else {
                    result = Float.parseFloat(num1) + Float.parseFloat(num2);
                }
                textResult.setText("계산 결과 : " + result);
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.equals("")|num2.equals("")) Toast.makeText(MainActivity.this,"숫자를 입력하세요",Toast.LENGTH_SHORT).show();

                else {
                    result = Float.parseFloat(num1) - Float.parseFloat(num2);
                }
                textResult.setText("계산 결과 : " + result);
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.equals("")|num2.equals("")) Toast.makeText(MainActivity.this,"숫자를 입력하세요",Toast.LENGTH_SHORT).show();

                else {
                    result = Float.parseFloat(num1) * Float.parseFloat(num2);
                }
                textResult.setText("계산 결과 : " + result);
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                if(num1.equals("")|num2.equals("")) Toast.makeText(MainActivity.this,"숫자를 입력하세요",Toast.LENGTH_SHORT).show();
                else if(num2.equals("0")) Toast.makeText(MainActivity.this,"0으로 나눌 수 없습니다",Toast.LENGTH_SHORT).show();

                else {
                    result = Float.parseFloat(num1) / Float.parseFloat(num2);
                }
                textResult.setText("계산 결과 : " + result);
                return false;
            }
        });
        btnRem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if(num1.equals("")|num2.equals("")) Toast.makeText(MainActivity.this,"숫자를 입력하세요",Toast.LENGTH_SHORT).show();

                else {
                    result = Float.parseFloat(num1) % Float.parseFloat(num2);
                }
                textResult.setText("계산 결과 : " + result);
                return false;
            }
        });
    }
}

