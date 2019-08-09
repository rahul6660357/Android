package com.lcoa.fastfood;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn;
RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//hiding the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen
rating=findViewById(R.id.myrating);

        btn=findViewById(R.id.button);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String rate= String.valueOf(rating.getRating());
        Toast.makeText(getApplicationContext(),rate,Toast.LENGTH_LONG).show();
        showalert(rate);
    }
});
    }
    public void showalert(String rate)
    {
       final String str=rate;
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Thanks for your feedback");
        builder.setTitle("Feedback Saved");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"your rating "+str+" is saved",Toast.LENGTH_LONG).show();
                // finish();
            }
        });

        AlertDialog alertDialog=builder.create();
        alertDialog.show();
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
