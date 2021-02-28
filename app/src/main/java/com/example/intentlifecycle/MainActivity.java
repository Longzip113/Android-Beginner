package com.example.intentlifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.buttonScreen1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecconActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.i("AAA",  "onStart main");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.i("AAA",  "onRestart main");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("AAA",  "onResume main");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("AAA",  "onPause main");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("AAA",  "onStop main");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("AAA",  "onDestroy main");
        super.onDestroy();
    }
}