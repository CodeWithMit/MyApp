package com.example.myapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Pra10_Extra extends AppCompatActivity {
    SQLiteDatabase db;
    ArrayList<String> arraylist;
    ListView lst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pra10_extra);
        lst = findViewById(R.id.lstallrecord);
        arraylist = new ArrayList<String>();
        db = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);
        Cursor cursor = db.rawQuery("SELECT * FROM student", null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int marks = cursor.getInt(cursor.getColumnIndexOrThrow("marks"));
            arraylist.add(id + " " + name + " " + marks);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arraylist);
        lst.setAdapter(adapter);
        cursor.close();
    }
}