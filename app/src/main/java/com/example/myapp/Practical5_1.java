package com.example.myapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practical5_1 extends AppCompatActivity {
    LinearLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical51);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        l = findViewById(R.id.main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucolor,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.red){
            l.setBackgroundColor(getResources().getColor(R.color.red));
            Toast.makeText(this, "Red Color", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.green) {
            l.setBackgroundColor(getResources().getColor(R.color.green));
            Toast.makeText(this, "Green Color", Toast.LENGTH_SHORT).show();
        }
        if(item.getItemId()==R.id.blue) {
            l.setBackgroundColor(getResources().getColor(R.color.yellow));
            Toast.makeText(this, "Yellow Color", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}