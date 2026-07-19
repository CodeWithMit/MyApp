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
    int[] img = {R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4};
    int[] anims = {R.anim.alpha, R.anim.rotate, R.anim.translate, R.anim.scale};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical3);
        sImg = findViewById(R.id.sp1);
        sAni = findViewById(R.id.sp2);
        iv = findViewById(R.id.imgV);
        sImg.setOnItemSelectedListener(this);
        sAni.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0) return;
        if (adapterView.getId() == R.id.sp1) {
            iv.setImageResource(img[i - 1]);
        } else {
            iv.startAnimation(AnimationUtils.loadAnimation(this, anims[i - 1]));
        }
    }
    @Override public void onNothingSelected(AdapterView<?> adapterView) {}
}