package com.example.speedanimal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox, checkBox1, checkBox2;
    SeekBar seekBar, seekBar1, seekBar2;
    TextView txtScores;
    ImageButton btnPlay;
    Integer winGame = 0;
    Integer scores = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        txtScores.setText("Score: "+scores);
        seekBar.setEnabled(false);
        seekBar1.setEnabled(false);
        seekBar2.setEnabled(false);
        handlingChecked();
        runSpeed();
    }

    private void mapping()  {
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);

        txtScores = (TextView)  findViewById(R.id.textView);
        btnPlay = (ImageButton) findViewById(R.id.imageButton);
    }

    private void runSpeed() {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setVisibility(View.GONE);
                checkBox.setEnabled(false);
                checkBox1.setEnabled(false);
                checkBox2.setEnabled(false);

                if(checkBox.isChecked() == checkBox1.isChecked() == checkBox2.isChecked() == false) {
                    Toast.makeText(MainActivity.this, "Please choose one pokemon !", Toast.LENGTH_SHORT).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    return;
                }
                resetGame();
                playGame();

            }
        });
    }

    private void handlingChecked() {
//        ArrayList<CheckBox> listCheckBox = new ArrayList<>();
//        for(CheckBox item : listCheckBox) {
//            item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if(isChecked){
//                        for (CheckBox itemm: listCheckBox) {
//                            if(itemm.getId() == item.getId()) {
//                                continue;
//                            }
//                            itemm.setChecked(false);
//                        }
//                    }
//                }
//            });
//        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox1.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox.setChecked(false);
                    checkBox2.setChecked(false);
                }
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox1.setChecked(false);
                    checkBox.setChecked(false);
                }
            }
        });
    }

    private void playGame () {
        CountDownTimer run = new CountDownTimer(100000,500) {
            @Override
            public void onTick(long millisUntilFinished) {



                int propress = seekBar.getProgress();
                Random rd = new Random();
                int count = rd.nextInt(5) + 1;
                seekBar.setProgress(propress + count);

                int propress2 = seekBar2.getProgress();
                Random rd2 = new Random();
                int count2 = rd2.nextInt(5) + 1;
                seekBar2.setProgress(propress2 + count2);

                int propress1 = seekBar1.getProgress();
                Random rd1 = new Random();
                int count1 = rd1.nextInt(5) + 1;
                seekBar1.setProgress(propress1 + count1);

                if(seekBar1.getProgress() == seekBar1.getMax() || seekBar2.getProgress() == seekBar2.getMax() || seekBar.getProgress() == seekBar.getMax()) {
                    cancel();
                    this.onFinish();
                };
            }

            @Override
            public void onFinish() {
                if(seekBar1.getProgress() == seekBar1.getMax()) {
                    winGame = 1;
                } else if(seekBar.getProgress() == seekBar.getMax()) {
                    winGame = 0;
                }  else {
                    winGame = 2;
                }
                scoresCalculation(winGame);
                Toast.makeText(MainActivity.this, winGame + " Done", Toast.LENGTH_SHORT).show();
                btnPlay.setVisibility(View.VISIBLE);
            }
        };
        run.start();
    }

    private void resetGame () {
        seekBar.setProgress(0);
        seekBar1.setProgress(0);
        seekBar2.setProgress(0);

        seekBar.setMax(100);
        seekBar1.setMax(100);
        seekBar2.setMax(100);
    }

    private void scoresCalculation (int win) {
        switch (win) {
            case 0:
                scores = checkBox.isChecked() ? scores + 10 : scores - 10;
                break;
            case 1:
                scores = checkBox1.isChecked() ? scores + 10 : scores - 10;
                break;
            case 2:
                scores = checkBox2.isChecked() ? scores + 10 : scores - 10;
                break;
        }

        txtScores.setText("Score: "+scores);
        checkBox.setEnabled(true);
        checkBox1.setEnabled(true);
        checkBox2.setEnabled(true);
    }
}


























