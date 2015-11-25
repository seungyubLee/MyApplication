package com.cookandroid.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends Activity {


    EditText edtNum1, edtNum2;
    RadioGroup rGroup;
    RadioButton Add, Sub, Mul, Div;
    Button btnCalc;
    Character operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);


        rGroup = (RadioGroup)findViewById(R.id.rGroup);
        Add = (RadioButton)findViewById(R.id.Add);
        Sub = (RadioButton)findViewById(R.id.Sub);
        Mul= (RadioButton)findViewById(R.id.Mul);
        Div = (RadioButton)findViewById(R.id.Div);
        btnCalc = (Button)findViewById(R.id.btnCalc);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNum1.getText().toString().equals("") || edtNum2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_LONG).show();
                else{
                    Double num1 = Double.parseDouble(edtNum1.getText().toString());
                    Double num2 = Double.parseDouble(edtNum2.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);


                    switch (rGroup.getCheckedRadioButtonId()) {
                        case R.id.Add:
                            operation = '+';
                            break;
                        case R.id.Sub:
                            operation = '-';
                            break;
                        case R.id.Mul:
                            operation = '*';
                            break;
                        case R.id.Div:
                            operation = '/';
                            break;
                    }
                    intent.putExtra("num1", num1);
                    intent.putExtra("num2", num2);
                    intent.putExtra("operation", operation);
                    startActivityForResult(intent, 0);
                }
            }
        });


    }


    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            double result = data.getDoubleExtra("result", 0);
            Toast.makeText(getApplicationContext(), "결과 : " + result, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "분모가 0 입니다. 다시 입력하세요", Toast.LENGTH_LONG).show();
        }
    }


}