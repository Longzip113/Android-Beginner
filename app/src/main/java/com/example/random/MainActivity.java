package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    EditText max, min;
    Button btnRanDom;
    TextView txtNumber, txtseekBar;
    Switch swtRandDom;
    ArrayList<Integer> listBG;
    RelativeLayout bgRelativeLayout;
    ImageButton btnHelle;
    CheckBox chkRv, chkBg;
    ProgressBar progressBar;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        addBackGroud();
        bgRelativeLayout.setBackgroundResource(listBG.get(1));



        chkBg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Random rdBg = new Random();
                    bgRelativeLayout.setBackgroundResource(listBG.get(rdBg.nextInt(listBG.size())));
                }
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int number = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                number = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                txtseekBar.setText("Number seekBar");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtseekBar.setText(number + "");
            }
        });


        btnRanDom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(max.getText().length() > 0  || min.getText().length() >  0) {
                    txtNumber.setText("Number");
                    int numberMax = Integer.parseInt(max.getText().toString());
                    int numberMin = Integer.parseInt(min.getText().toString());
                    Random rd = new Random();
                    int number = rd.nextInt((numberMax - numberMin) + 1) + numberMin;

                    CountDownTimer countDownTimer = new CountDownTimer(9000, 500) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int numberProgress = progressBar.getProgress();
                            progressBar.setProgress(numberProgress + 5);
                            if(progressBar.getMax() == progressBar.getProgress()) {
                                progressBar.setProgress(0);
                            }
                        }
                        @Override
                        public void onFinish() {
                            txtNumber.setText(number + "");
                        }
                    };

                    countDownTimer.start();

                    if(chkRv.isChecked()) {
                        Toast.makeText(MainActivity.this, "Thank you checked review !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter input text ...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnHelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wellcome to apple store", Toast.LENGTH_SHORT).show();
            }
        });

        swtRandDom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(MainActivity.this, "Random true", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Randon false", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addBackGroud() {
        listBG  = new ArrayList<>();
        listBG.add(R.drawable.backgroud3);
        listBG.add(R.drawable.background2);
        listBG.add(R.drawable.backgroup1);
    }



    private void mapping() {
        btnRanDom = (Button) findViewById(R.id.ButtonRandom);
        max = (EditText) findViewById(R.id.EditTextMax);
        min = (EditText) findViewById(R.id.EditTextMin);
        txtNumber = (TextView) findViewById(R.id.textView6);
        swtRandDom = (Switch) findViewById(R.id.switch1);
        bgRelativeLayout = (RelativeLayout) findViewById(R.id.LayoutMain);
        btnHelle = (ImageButton) findViewById(R.id.imageButton);
        chkBg = (CheckBox) findViewById(R.id.checkBoxChangeBG);
        chkRv  = (CheckBox) findViewById(R.id.checkBoxreview);
        progressBar = (ProgressBar)  findViewById(R.id.progressBar);
        seekBar = (SeekBar)findViewById(R.id.seekBar);
        txtseekBar = (TextView)  findViewById(R.id.textViewSeekBar);
    }
}
























