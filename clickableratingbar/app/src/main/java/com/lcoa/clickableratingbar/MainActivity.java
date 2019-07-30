package com.lcoa.clickableratingbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RatingBar rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    rate=findViewById(R.id.myrating);
    rate.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            String rat= String.valueOf(rate.getRating());
            Toast.makeText(getApplicationContext(),rat,Toast.LENGTH_LONG).show();
            showalert(rat);
            return false;
        }
    });
    }
    public void showalert(String rate)
    {
        final String str=rate;
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Thanks for your feedback/ are you want to close the app");
        builder.setTitle("Feedback Saved");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"your rating "+str+" is saved",Toast.LENGTH_LONG).show();
                 finish();
            }
        }).setNegativeButton("No",null);

        builder.create();


        builder.show();
    }
    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Really exit!!");
        builder.setMessage("are you want to close the app").setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        }).setNegativeButton("No",null);
        builder.create();
        builder.show();

    }
}
