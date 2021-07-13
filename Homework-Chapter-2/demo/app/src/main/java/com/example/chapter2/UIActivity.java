package com.example.chapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class UIActivity extends AppCompatActivity {

    private ImageButton btn_ret;
    private Button btn_tree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        btn_ret = findViewById(R.id.btn_ret);
        btn_ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UIActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_tree = findViewById(R.id.btn_tree);
        btn_tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIActivity.this, "快去植树", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
