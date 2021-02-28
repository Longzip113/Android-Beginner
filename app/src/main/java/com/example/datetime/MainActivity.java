package com.example.datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText txtDayOne, txtDayTwo, txtTime;
    Button btnSummit;
    TextView lableDay;
    Calendar time1, time2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        event();
    }

    private void event() {
        time1 = Calendar.getInstance();
        time2 = Calendar.getInstance();

        txtDayOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Turn", Toast.LENGTH_SHORT).show();
                showDate(txtDayOne, time1);
            }
        });

        txtDayTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Turn", Toast.LENGTH_SHORT).show();
                showDate(txtDayTwo, time2);
            }
        });

        btnSummit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int timeResult = (int)(time2.getTimeInMillis() - time1.getTimeInMillis()) / (1000*60*60*24);
                lableDay.setText("Day: " + timeResult);
            }
        });

        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Turn", Toast.LENGTH_SHORT).show();
                showTime(txtTime);
            }
        });
    }

    private void showTime(EditText editText){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.set(0,0,0,hourOfDay,minute);
                editText.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },hour,minute,true);

        timePickerDialog.show();
    }

    private Calendar showDate(EditText editText, Calendar item) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
                item.set(year, month, dayOfMonth);
                editText.setText(simpleDateFormat.format(item.getTime()));
            }
        },year,month,day);
        datePickerDialog.show();
        return item;
    }

    private void mapping() {
        txtDayOne = (EditText) findViewById(R.id.editTextTextPersonName);
        txtDayTwo = (EditText) findViewById(R.id.editTextTextPersonName2);
        lableDay = (TextView) findViewById(R.id.textView);
        btnSummit = (Button) findViewById(R.id.button);
        txtTime  = (EditText) findViewById(R.id.editTextTextPersonName3);
    }
}