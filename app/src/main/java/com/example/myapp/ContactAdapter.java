package com.example.myapp;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Activity activity;
    ArrayList<Contact> lst;
    public ContactAdapter(Activity activity, ArrayList<Contact> lst) {
        super(activity,R.layout.contact_item,lst);
        this.activity=activity;
        this.lst=lst;
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater=activity.getLayoutInflater();
        View view =inflater.inflate(R.layout.contact_item,null);
        ImageView img=view.findViewById(R.id.itemImage);
        TextView name=view.findViewById(R.id.itemname);
        TextView phone=view.findViewById(R.id.itemphone);
        Contact c= lst.get(position);
        if(c.getPhotoUrl()==null){
            img.setImageResource(c.getImage());
        }else{
            img.setImageURI(Uri.parse(c.getPhotoUrl()));
        }
        name.setText(c.getName());
        phone.setText(c.getPhone());
        return view;
    }
}
