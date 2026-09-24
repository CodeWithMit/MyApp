package com.example.myapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class Practical11 extends AppCompatActivity {
    EditText etNumber, etMessage;
    Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical11);
        etNumber = findViewById(R.id.etNumber);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(v -> {
            if
            (ContextCompat.checkSelfPermission(Practical11.this,
                    Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(Practical11.this,
                        new
                                String[]{Manifest.permission.SEND_SMS}, 100);
            }else{
                sendSMS();
            }
        });
    }
    private void sendSMS() {
        String number = etNumber.getText().toString().trim();
        String message = etMessage.getText().toString().trim();
        if (!number.isEmpty() && !message.isEmpty()) {
            try {
                SmsManager smsManager;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    smsManager = this.getSystemService(SmsManager.class);
                } else {
                    smsManager = SmsManager.getDefault();
                }
                smsManager.sendTextMessage(number, null, message,
                        null, null);
                Toast.makeText(this, "SMS Sent!",
                        Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "Failed: " + e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Enter number and message",
                    Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[]
                                                   permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions,
                grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "SMS Permission Granted",
                        Toast.LENGTH_SHORT).show();
                sendSMS();
            } else {
                Toast.makeText(this, "SMS Permission Denied",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
