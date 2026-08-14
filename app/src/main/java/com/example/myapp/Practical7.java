package com.example.myapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Practical7 extends AppCompatActivity {
    ListView listView;
    ContactAdapter adapter;
    ArrayList<Contact> list;

    private static final int CONTACT_PERMISSON_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_practical7);
        listView=findViewById(R.id.Contactlist);
        list=new ArrayList<>();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},CONTACT_PERMISSON_CODE);
        }else{
            LoadContact();
        }
    }
    private void LoadContact(){
        Cursor cursor=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,new String[]{
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI},null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");
        if(cursor!=null){
            int nameIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            int numberIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int photoIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI);
            while(cursor.moveToNext()){
                String name=cursor.getString(nameIndex);
                String number=cursor.getString(numberIndex);
                String photo=cursor.getString(photoIndex);
                System.out.println(photo);
                list.add(new Contact(R.drawable.car11,name,number,photo));
            }
            cursor.close();
        }
        adapter=new ContactAdapter(this,list);
        listView.setAdapter(adapter);
    }
}