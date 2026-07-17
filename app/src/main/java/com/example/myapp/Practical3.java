package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Practical3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sImg, sAni;
    ImageView iv;
    int[] img = {R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        sImg = findViewById(R.id.sp1);
        sAni = findViewById(R.id.sp2);
        iv = findViewById(R.id.imgV);
        sImg.setOnItemSelectedListener(this);
        sAni.setOnItemSelectedListener(this);


    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Animation animation=null;

        if(adapterView.getId()==R.id.sp1){
            switch (i){
                case 1:
                    iv.setImageResource(R.drawable.car1);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.car2);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.car3);
                    break;
                case 4:
                    iv.setImageResource(R.drawable.car4);
                    break;
            }
        }
        if(adapterView.getId()==R.id.sp2){
        switch (i)
        {
            case 1:
                //animation = AnimationUtils.loadAnimation(Practical3.this,R.anim.alpha);
                AlphaAnimation alpha = new AlphaAnimation(0.0f,1.0f);
                alpha.setDuration(1000);
                iv.startAnimation(alpha);
                break;
            case 2:
                animation = AnimationUtils.loadAnimation(Practical3.this,R.anim.rotate);
                break;
            case 3:
                animation = AnimationUtils.loadAnimation(Practical3.this,R.anim.translate);
                break;
            case 4:
                animation = AnimationUtils.loadAnimation(Practical3.this,R.anim.scale);
                break;
        }
        if(animation!=null){
            iv.startAnimation(animation);
        }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}