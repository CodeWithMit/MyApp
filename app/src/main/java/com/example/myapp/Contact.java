package com.example.myapp;

import android.widget.ArrayAdapter;

public class Contact  {
        int image;
        String name;
        String phone;
        String PhotoUrl;

        public Contact(int image,String name,String phone,String PhotoUrl){
            this.image=image;
            this.name=name;
            this.phone=phone;
            this.PhotoUrl=PhotoUrl;

        }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }
}
