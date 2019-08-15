package com.lcoa.mixcomponent;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class thirdactivity extends AppCompatActivity {
RatingBar rating;
Button btn,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity);
        rating=findViewById(R.id.myrating);
        btn=findViewById(R.id.mybtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rate= String.valueOf(rating.getRating());
                Toast.makeText(getApplicationContext(),rate,Toast.LENGTH_LONG).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progress = new ProgressDialog(thirdactivity.this);
                progress.setMessage("loading");
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.cancel();
                progress.setProgress(0);
                progress.setMax(50);
                progress.show();

            }
        });
        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showalert();
            }
        });
    }
    public void showalert()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(thirdactivity.this);
        builder.setMessage("do you want to logout");
        builder.setTitle("alert");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"button clicked",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"button no clicked",Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }

}
