package com.cookandroid.image;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView text1, text2;
    Switch switAgree;
    RadioGroup rGroup;
    RadioButton jelly, kit, lolli;
    Button finish, refresh;
    ImageView imgVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        switAgree = (Switch) findViewById(R.id.switAgree);
        text2 = (TextView) findViewById(R.id.Text2);
        rGroup = (RadioGroup) findViewById(R.id.Rgroup);
        jelly = (RadioButton) findViewById(R.id.jelly);
        kit = (RadioButton) findViewById(R.id.kit);
        lolli = (RadioButton) findViewById(R.id.lolli);

        finish = (Button) findViewById(R.id.finishBtn);
        refresh = (Button) findViewById(R.id.refreshBtn);
        imgVer = (ImageView) findViewById(R.id.imgVer);


        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (rGroup.getCheckedRadioButtonId()) {
                    case R.id.jelly:
                        imgVer.setImageResource(R.drawable.jelly);
                        break;
                    case R.id.kit:
                        imgVer.setImageResource(R.drawable.kit);
                        break;
                    case R.id.lolli:
                        imgVer.setImageResource(R.drawable.lolli);
                        break;
                }
            }
        });


//        switch(rGroup.getCheckedRadioButtonId()){
//            case R.id.jelly:
//                imgVer.setImageResource(R.drawable.jelly);
//                break;
//            case R.id.kit:
//                imgVer.setImageResource(R.drawable.kit);
//                break;
//            case R.id.lolli:
//                imgVer.setImageResource(R.drawable.lolli);
//                break;
//        }

        switAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (switAgree.isChecked()) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup.setVisibility(android.view.View.VISIBLE);
                    finish.setVisibility(android.view.View.VISIBLE);
                    refresh.setVisibility(android.view.View.VISIBLE);
                    imgVer.setVisibility(android.view.View.VISIBLE);
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup.setVisibility(android.view.View.INVISIBLE);
                    refresh.setVisibility(android.view.View.INVISIBLE);
                    finish.setVisibility(android.view.View.INVISIBLE);
                    imgVer.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jelly.setChecked(false);
                kit.setChecked(false);
                lolli.setChecked(false);
                imgVer.setImageResource(0);
            }
        });


    }

//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//        if(rGroup.getCheckedRadioButtonId() == R.id.jelly)
//            imgVer.setImageResource(R.drawable.jelly);
//        if(rGroup.getCheckedRadioButtonId() == R.id.kit)
//            imgVer.setImageResource(R.drawable.kit);
//        if(rGroup.getCheckedRadioButtonId() == R.id.lolli)
//            imgVer.setImageResource(R.drawable.lolli);
//    }


}