package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Practical6 extends AppCompatActivity implements AdapterView.OnItemClickListener{
    String cars[]={"lamborghini","Rolls-Royce","ferrari","Bugati"};
    ListView listCars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical6);
        listCars=findViewById(R.id.listcars);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cars);

        listCars.setAdapter(adapter);
        listCars.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i=new Intent(this,Practical6_B.class);
        i.putExtra("carname",cars[position]);
        i.putExtra("Position",position);
        startActivity(i);
    }
}