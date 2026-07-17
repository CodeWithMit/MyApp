package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String[] pr = {"Pr1","Pr2","Pr3","Pr4","Pr5","Pr6"};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    lv = findViewById(R.id.l1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pr);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i){
                    case 0:
                        intent = new Intent(MainActivity.this, Practical1.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, Practical2_1.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, Practical3.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, Practical4_1.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, Practical5_1.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });

    }
}