package com.example.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class ImgAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    List<Img> listImg;

    public ImgAdapter(Context context, int layout, List<Img> listImg) {
        this.context = context;
        this.layout = layout;
        this.listImg = listImg;
    }

    @Override
    public int getCount() {
        return listImg.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class viewHoldel {
        ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHoldel viewHoldel;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHoldel = new viewHoldel();
            viewHoldel.image = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHoldel);
        } else {
            viewHoldel = (viewHoldel) convertView.getTag();
        }

        Img item = listImg.get(position);
        viewHoldel.image.setImageResource(item.getImg());

        return convertView;
    }
}
