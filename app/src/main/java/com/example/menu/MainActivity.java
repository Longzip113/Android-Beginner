package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnConTextMenu, btnMenu, btnLogin, btnCancel;
    TextView labelClick;
    EditText txtUsername, txtPassword;
    ConstraintLayout screen;
    ListView listView;
    ArrayList<String> listPhone;
    ArrayAdapter arrayAdapter;
    AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listPhone);
        listView.setAdapter(arrayAdapter);
        alert = new AlertDialog.Builder(MainActivity.this);
        registerForContextMenu(btnConTextMenu);

        onListViewDelete();
        onLogin();
//        btnMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showPopup();
//            }
//        });
    }

    private void onListViewDelete ()   {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                alert.setMessage("Do you want to delete item")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listPhone.remove(position);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                alert.show();
                return false;
            }
        });
    }

    private void mapping () {
        btnMenu = (Button) findViewById(R.id.btnMenuPopup);
        btnConTextMenu = (Button) findViewById(R.id.btnConTextMenu);
        screen = (ConstraintLayout) findViewById(R.id.layoutConstraint);
        listView = (ListView) findViewById(R.id.listView);
        labelClick = (TextView) findViewById(R.id.clicklogin);

        listPhone = new ArrayList<>();
        listPhone.add("Iphone 11");
        listPhone.add("Iphone 11 Pro Max");
        listPhone.add("Iphone 11 Pro");
        listPhone.add("Iphone 12");
        listPhone.add("Iphone 12 Mini");
        listPhone.add("Iphone 12 Pro");
    }

    private void onLogin () {
        labelClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog () {
        Dialog dialog = new Dialog(this);
        //remove header
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // click out dialog
        dialog.setCanceledOnTouchOutside(false);

        dialog.setContentView(R.layout.custom_dialog);
        btnLogin = (Button) dialog.findViewById(R.id.btnlogin);
        btnCancel = (Button) dialog.findViewById(R.id.btncancel);
        txtUsername = (EditText) dialog.findViewById(R.id.txtUsename);
        txtPassword = (EditText) dialog.findViewById(R.id.txtPassword);

        eventDialog(dialog);

        dialog.show();
    }

    private void eventDialog (Dialog dialog) {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if(username.equals("admin") && password.equals("admin")) {
                    dialog.cancel();
                    Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "User name and password wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menusearch:
                Toast.makeText(this, "Menu search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuexit:
                Toast.makeText(this, "Menu Exit", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menusettings:
                Toast.makeText(this, "Menu Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menusuppots:
                Toast.makeText(this, "Menu  Support", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menucontext, menu);
        menu.setHeaderTitle("Choose color background");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menured:
                screen.setBackgroundColor(Color.RED);
                return true;
            case R.id.menublue:
                screen.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.menuYellow:
                screen.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    // cach 1
//    public void showPopup() {
//        PopupMenu popup = new PopupMenu(this, btnMenu);
//        MenuInflater inflater = popup.getMenuInflater();
//        inflater.inflate(R.menu.menupopup, popup.getMenu());
//        popup.show();
//    }

    // cach 2
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menupopup, popup.getMenu());
        popup.show();
    }
}