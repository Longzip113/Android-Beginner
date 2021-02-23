package com.example.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstView;
    ArrayList<String> listItem;
    EditText txtView;
    Button btnAdd, btnUpdate;
    Integer indexValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        listItem = new ArrayList<>();
        listItem.add("Iphone 11");
        listItem.add("Iphone 11 Pro");
        listItem.add("Iphone 11 Pro max");
        listItem.add("Iphone 12");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                listItem);
        lstView.setAdapter(adapter);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtView.setText(listItem.get(position));
                indexValue = position;
            }
        });

        lstView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listItem.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txtView.getText() + "";
                listItem.add(input);
                txtView.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txtView.getText() + "";
                listItem.set(indexValue, input);
                txtView.setText("");
                adapter.notifyDataSetChanged();
            }
        });

    }

    private void mapping() {
        txtView = (EditText) findViewById(R.id.txtView);
        btnAdd = (Button) findViewById(R.id.button);
        btnUpdate = (Button) findViewById(R.id.button2);
        lstView = (ListView) findViewById(R.id.listView);
    }
}