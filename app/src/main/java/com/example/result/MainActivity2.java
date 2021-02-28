package com.example.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    Button btnConform;
    EditText txtTile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        maping();
        event();
    }

    private void event() {
        btnConform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleNew = txtTile.getText().toString().trim();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);

                intent.putExtra("titleNew", titleNew);
                setResult(RESULT_OK, intent);

                // end screen this
                finish();
            }
        });
    }

    private void maping() {
        btnConform = (Button) findViewById(R.id.btnConform);
        txtTile = (EditText) findViewById(R.id.txtTitle);
    }
}