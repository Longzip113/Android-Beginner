package com.example.shared;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextUserName, editTextPassWord;
    CheckBox checkBoxPassword;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        event();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        String user = sharedPreferences.getString("userName", "");
        String pass = sharedPreferences.getString("passWord", "");
        Boolean ischecked = sharedPreferences.getBoolean("checked",false);
        editTextUserName.setText(user);
        editTextPassWord.setText(pass);
        checkBoxPassword.setChecked(ischecked);
    }

    private void event () {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editTextUserName.getText().toString().trim();
                String passWord = editTextPassWord.getText().toString().trim();

                if(userName.equals("admin") && passWord.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    if (checkBoxPassword.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("passWord", passWord);
                        editor.putString("userName", userName);
                        editor.putBoolean("checked", true);
                        Toast.makeText(MainActivity.this, "luu data", Toast.LENGTH_SHORT).show();
                        editor.commit();
                    } else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("passWord");
                        editor.remove("userName");
                        editor.remove("checked");
                        editor.commit();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Wrong login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void mapping () {
        btnLogin = (Button) findViewById(R.id.button);
        editTextPassWord = (EditText) findViewById(R.id.editTextTextPersonName2);
        editTextUserName = (EditText) findViewById(R.id.editTextTextPersonName);
        checkBoxPassword  = (CheckBox) findViewById(R.id.checkBox);
    }
}