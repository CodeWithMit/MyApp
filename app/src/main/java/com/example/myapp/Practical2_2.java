package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Practical2_2 extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical22);

        tv=findViewById(R.id.textView);
        Intent i = getIntent();
        String username = i.getStringExtra("uname") ;
        tv.setText("Welcome, " + username);
    }
}