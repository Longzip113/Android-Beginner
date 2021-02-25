package com.example.appwould;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtPW, txtEmail;
    Button btnResult;
    TextView labelResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString().trim();
                String PW = txtPW.getText().toString().trim();
                String email = txtEmail.getText().toString().trim();

                String nameVN  = getString(R.string.app_username);
                String PWVN  = getString(R.string.app_passWord);
                String emailVN  = getString(R.string.app_email);

                labelResult.setText(nameVN + ": " + name + PWVN + "/t: " + PW + emailVN + "/t: "+ email);
            }
        });
    }

    private void mapping () {
        txtName = (EditText)  findViewById(R.id.txtName);
        txtPW = (EditText)  findViewById(R.id.txtPassWord);
        txtEmail = (EditText)  findViewById(R.id.txtEmail);
        btnResult = (Button) findViewById(R.id.button);
        labelResult =(TextView) findViewById(R.id.txtResult);
    }
}