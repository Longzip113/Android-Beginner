package com.example.gridview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
     //String list [] = {"A", "B", "C", "D"};
    ArrayList<Img> list;
    ImgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        list = new ArrayList<Img>();

        list.add(new Img(R.drawable.hinh1));
        list.add(new Img(R.drawable.hinh1));
        list.add(new Img(R.drawable.hinh1));
        list.add(new Img(R.drawable.hinh1));

        adapter = new ImgAdapter(
                this,
                R.layout.itemgridview,
                list);

        //ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);

        gridView.setAdapter(adapter);
    }
}