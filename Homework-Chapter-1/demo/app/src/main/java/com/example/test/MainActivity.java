package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn1);
        final TextView tv1 = findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("What a wonderful life!");
                Log.d("YYDS", "ZJU");
            }
        });

        //radio button
        RadioGroup rgroup = findViewById(R.id.rgroup);
        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbtn = findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "Choose" + rbtn.getText(), Toast.LENGTH_LONG).show();
            }
        });

        //check box
        final CheckBox cb0 = findViewById(R.id.checkBox0);
        final CheckBox cb1 = findViewById(R.id.checkBox1);
        final CheckBox cb2 = findViewById(R.id.checkBox2);
        Button btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb=new StringBuilder();
                if(cb0.isChecked())
                {
                    sb.append(cb0.getText());
                }
                if(cb1.isChecked())
                {
                    sb.append(cb1.getText());
                }
                if(cb2.isChecked())
                {
                    sb.append(cb2.getText());
                }
                //显示弹窗
                Toast.makeText(MainActivity.this, "You choose："+sb.toString() , Toast.LENGTH_SHORT).show();
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt = findViewById(R.id.editText);
                Toast.makeText(MainActivity.this, "Your Name is " + edt.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
