package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Gallery;

import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Practical6_B extends AppCompatActivity {
    Gallery gl;
    TextView carInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical6_b);
        Intent i=getIntent();
        gl=findViewById(R.id.gallary);
        carInfo=findViewById(R.id.carInfo);
        String name=i.getStringExtra("carname");
        carInfo.setText(name);
        int []images=null;

        if(name.equals("lamborghini")){
            images=new int[]{R.drawable.car1,R.drawable.car11,R.drawable.car12,R.drawable.car13,R.drawable.car14};
        }else if(name.equals("Rolls-Royce")){
            images=new int[]{R.drawable.car2,R.drawable.car21,R.drawable.car22,R.drawable.car23};
        }
        else if(name.equals("ferrari")){
            images=new int[]{R.drawable.car3,R.drawable.car31,R.drawable.car32,R.drawable.car33};
        }
        else if(name.equals("Bugati")){
            images=new int[]{R.drawable.car4,R.drawable.car41,R.drawable.car42,R.drawable.car43};
        }
        gl.setAdapter(new ImageAdapterCar(this,images));

    }
}