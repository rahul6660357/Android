package com.lcoa.drumpadeg;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8;
    private SoundPool soundpool;
    private int sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View overplay = findViewById(R.id.mylayout);
        getSupportActionBar().hide();//hiding the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen

        overplay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioattributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).build();
            soundpool = new SoundPool.Builder().setMaxStreams(8).setAudioAttributes(audioattributes).build();
        } else {
            soundpool = new SoundPool(8, AudioManager.STREAM_MUSIC, 0);
        }
        sound1 = soundpool.load(this, R.raw.one, 1);
        sound2 = soundpool.load(this, R.raw.two, 1);
        sound3 = soundpool.load(this, R.raw.three, 1);
        sound4 = soundpool.load(this, R.raw.four, 1);
        sound5 = soundpool.load(this, R.raw.five, 1);
        sound6 = soundpool.load(this, R.raw.six, 1);
        sound7 = soundpool.load(this, R.raw.seven, 1);
        sound8 = soundpool.load(this, R.raw.eight, 1);
        Button1 = findViewById(R.id.btn1);
        Button2 = findViewById(R.id.btn2);
        Button3 = findViewById(R.id.btn3);
        Button4 = findViewById(R.id.btn4);
        Button5 = findViewById(R.id.btn5);
        Button6 = findViewById(R.id.btn6);
        Button7 = findViewById(R.id.btn7);
        Button8 = findViewById(R.id.btn8);


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound1, 1, 1, 1, 0, 1);
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound2, 1, 1, 1, 0, 1);
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound3, 1, 1, 1, 0, 1);
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound4, 1, 1, 1, 0, 1);
            }
        });
        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound5, 1, 1, 1, 0, 1);
            }
        });
        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound6, 1, 1, 1, 0, 1);
            }
        });
        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound7, 1, 1, 1, 0, 1);
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundpool.play(sound8, 1, 1, 1, 0, 1);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundpool.release();
        soundpool = null;
    }
}
