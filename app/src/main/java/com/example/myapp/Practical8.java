package com.example.myapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Practical8 extends AppCompatActivity {

    Button  btnSlct,btnStart,btnPause,btnStop;
    MediaPlayer mediaPlayer;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical8);

        btnSlct=findViewById(R.id.BtnSlctM);
        btnStart=findViewById(R.id.BtnStart);
        btnPause=findViewById(R.id.BtnPause);
        btnStop=findViewById(R.id.BtnStop);
        btnSlct.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.setType("audio/*");
            startActivityForResult(intent,100);
        });
        if(checkSelfPermission(Manifest.permission.READ_MEDIA_AUDIO)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_MEDIA_AUDIO},100);
        }
        btnStart.setOnClickListener(v->{
            Toast.makeText(Practical8.this, "Play clicked", Toast.LENGTH_SHORT).show();
            mediaPlayer.start();
        });
        btnPause.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        });
        btnStop.setOnClickListener(v->{
            if (mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK  && data !=null){
            uri=data.getData();
            mediaPlayer=MediaPlayer.create(this,uri);
            Toast.makeText(Practical8.this, "Audio Select", Toast.LENGTH_SHORT).show();

        }
    }
}