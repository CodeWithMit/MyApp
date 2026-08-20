package com.example.myapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Practical9 extends AppCompatActivity {
    EditText etFilename,etContent;
    Button btnSave,btnRead;
    TextView tvRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical9);
        etFilename=findViewById(R.id.etFilename);
        etContent=findViewById(R.id.etContent);
        btnSave=findViewById(R.id.btnSave);
        btnRead=findViewById(R.id.btnRead);
        tvRead=findViewById(R.id.TvRead);
        btnSave.setOnClickListener(v -> {
            String filename = etFilename.getText().toString().trim();
            if(filename.isEmpty()){
                etFilename.requestFocus();
            }else {
                try {

                    String content = etContent.getText().toString();
                    File folder = getExternalFilesDir(null);
                    File file = new File(folder, filename + ".txt");
                    FileWriter writer = new FileWriter(file);
                    writer.write(content);
                    writer.close();
                    etContent.setText("");
                    etFilename.setText("");
                    Toast.makeText(this, "File Created Succesfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(this, "File Created UnSuccesfully", Toast.LENGTH_SHORT).show();
                }
            }


        });
        btnRead.setOnClickListener(v -> {
            String filename=etFilename.getText().toString();
            if(filename.isEmpty()){
                etFilename.requestFocus();
            }else {
                try {

                    File folder = getExternalFilesDir(null);

                    File file = new File(folder, filename + ".txt");
                    FileReader Fr = new FileReader(file);
                    StringBuilder stringBuilder = new StringBuilder();
                    int ch;
                    while ((ch = Fr.read()) != -1) {
                        stringBuilder.append((char) ch);
                    }
                    Fr.close();
                    tvRead.setText(stringBuilder);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }

        });
    }

}