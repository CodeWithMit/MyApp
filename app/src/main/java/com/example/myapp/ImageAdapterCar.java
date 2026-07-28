package com.example.myapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
public class ImageAdapterCar extends BaseAdapter {
    Context context;
    int[] images;
    public ImageAdapterCar(Context context,int[] images){
        this.context=context;
        this.images=images;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(images[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(720,405));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        return imageView;
    }
}
