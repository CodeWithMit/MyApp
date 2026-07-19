package com.example.myapp;

import android.os.Bundle;
import android.widget.Toast; // Added Toast import
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practical1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ToastMsg("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ToastMsg("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ToastMsg("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ToastMsg("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ToastMsg("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ToastMsg("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastMsg("onDestroy");
    }
    private void ToastMsg(String methodName) {
        String message = methodName + "() called";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}