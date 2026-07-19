package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Practical2_1 extends AppCompatActivity implements TextWatcher {
    EditText t1,t2;
    Button b1;
    final String validuname = "mit";
    final String validpwd = "123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical21);
        t1=findViewById(R.id.uname);
        t2=findViewById(R.id.pwd);
        b1=findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = t1.getText().toString();
                Intent i = new Intent(Practical2_1.this,Practical2_2.class);
                i.putExtra("uname",email);
                startActivity(i);
            }
        });
     t1.addTextChangedListener(this);
     t2.addTextChangedListener(this);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String uname = t1.getText().toString().trim();
        String pwd = t2.getText().toString().trim();
        boolean view = uname.equals(validuname) && pwd.equals(validpwd);
        b1.setEnabled(view);
    }
}