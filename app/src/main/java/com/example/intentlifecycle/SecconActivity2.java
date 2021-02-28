package com.example.intentlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecconActivity2 extends Activity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccon2);

        btn = (Button) findViewById(R.id.buttonScreen2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecconActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.i("AAA",  "onStart second");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("AAA",  "onRestart second");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("AAA",  "onResume second");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("AAA",  "onPause second");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("AAA",  "onStop second");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("AAA",  "onDestroy second");
        super.onDestroy();
    }
}