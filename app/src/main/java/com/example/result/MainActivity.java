package com.example.result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSummit;
    TextView lableTitle;

    int REQUEST_EDIT_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        event();
    }

    private void event() {
        btnSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivityForResult(intent, REQUEST_EDIT_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_EDIT_CODE && resultCode == RESULT_OK && data != null) {
            String titleNew = data.getStringExtra("titleNew");
            lableTitle.setText(titleNew);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void mapping() {
        btnSummit = (Button) findViewById(R.id.btnSummit);
        lableTitle = (TextView) findViewById(R.id.textView);
    }
}