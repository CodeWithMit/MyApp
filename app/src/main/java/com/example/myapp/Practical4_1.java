package com.example.myapp;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class Practical4_1 extends AppCompatActivity {
    Chronometer chronometer;
    Button btnStart,btnStop,btnRestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical41);
        chronometer = findViewById(R.id.ch);
        btnStart = findViewById(R.id.btn1);
        btnStop = findViewById(R.id.btn2);
        btnRestart = findViewById(R.id.btn3);

        btnStart.setOnClickListener(view -> chronometer.start());
        btnStop.setOnClickListener(view -> chronometer.stop());
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
            }
        });
    }
}