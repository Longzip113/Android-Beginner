package com.example.listviewadvanced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewIP;
    ArrayList<Iphone> arrayListIP;
    IphoneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        adapter = new IphoneAdapter(this, R.layout.row_listiphone, arrayListIP);
        listViewIP.setAdapter(adapter);

    }

    private void mapping() {
     listViewIP = (ListView) findViewById(R.id.listViewIphone);
     arrayListIP = new ArrayList<>();

     Iphone iphone = new Iphone("Iphone 11", "Iphone 11 product", R.drawable.hinh1);
     Iphone iphone1 = new Iphone("Iphone 11", "Iphone 11 product", R.drawable.hinh2);
     Iphone iphone2 = new Iphone("Iphone 11", "Iphone 11 product", R.drawable.hinh3);
     Iphone iphone3 = new Iphone("Iphone 11", "Iphone 11 product", R.drawable.hinh4);

     arrayListIP.add(iphone);
     arrayListIP.add(iphone1);
     arrayListIP.add(iphone2);
     arrayListIP.add(iphone3);
    }
}