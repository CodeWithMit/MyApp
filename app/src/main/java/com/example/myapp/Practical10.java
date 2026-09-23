package com.example.myapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Practical10 extends AppCompatActivity {

    EditText etId, etName, etMarks;
    Button btnAdd, btnView, btnUpdate, btnDelete;
    TextView tvResult;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical10);
        etId = findViewById(R.id.etId1);
        etName = findViewById(R.id.etName1);
        etMarks = findViewById(R.id.etMarks1);
        btnAdd = findViewById(R.id.btnAdd1);
        btnView = findViewById(R.id.btnView1);
        btnUpdate = findViewById(R.id.btnUpdate1);
        btnDelete = findViewById(R.id.btnDelete1);
        tvResult = findViewById(R.id.tvResult1);
        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," + "name TEXT," + "marks INTEGER)");
        btnAdd.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String marks = etMarks.getText().toString();
            db.execSQL("INSERT INTO student(name, marks) VALUES(?, ?)",
                    new Object[]{name, marks});
            Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etMarks.setText("");
        });

        btnView.setOnClickListener(v -> {
            Intent i = new Intent(Practical10.this, Pra10_Extra.class);
            startActivity(i);
            //tvResult.setText(data.toString());
        });
        btnUpdate.setOnClickListener(v -> {
            String id = etId.getText().toString();
            String name = etName.getText().toString();
            String marks = etMarks.getText().toString();

            db.execSQL("UPDATE student SET name = ?, marks = ? WHERE id = ?", new Object[]{name, marks, id});

            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etMarks.setText("");
        });

        btnDelete.setOnClickListener(v -> {
            String id = etId.getText().toString();

            db.execSQL("DELETE FROM STUDENT WHERE id = ?", new Object[]{id});

            Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
        });
//        btnUpdate.setOnClickListener(v -> {
//            String id = etId.getText().toString();
//        });
    }
    protected void  onDestroy(){
        super.onDestroy();
        if(db != null && db.isOpen()){
            db.close();
        }
    }
}