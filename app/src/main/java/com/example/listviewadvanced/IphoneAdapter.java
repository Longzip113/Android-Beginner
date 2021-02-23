package com.example.listviewadvanced;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class IphoneAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Iphone> listIphone;

    public IphoneAdapter(Context context, int layout, List<Iphone> listIphone) {
        this.context = context;
        this.layout = layout;
        this.listIphone = listIphone;
    }

    // Number row
    @Override
    public int getCount() {
        return listIphone.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // tránh render lại row trong view
    private class ViewHoldel {
        ImageView imageView;
        TextView txtName, txtDesc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHoldel viewHoldel;

        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            viewHoldel = new ViewHoldel();

            //Mapping view
            viewHoldel.txtName = (TextView) convertView.findViewById(R.id.labelName);
            viewHoldel.txtDesc = (TextView) convertView.findViewById(R.id.labelName);
            viewHoldel.imageView = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHoldel);
        } else {
            viewHoldel = (ViewHoldel) convertView.getTag();
        }
        // Gan gia tri
        Iphone iphone = listIphone.get(position);

        viewHoldel.txtName.setText(iphone.getName());
        viewHoldel.txtDesc.setText(iphone.getDesc());
        viewHoldel.imageView.setImageResource(iphone.getImage());

        return convertView;
    }
}
































