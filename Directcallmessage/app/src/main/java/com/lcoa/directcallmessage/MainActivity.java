package com.lcoa.directcallmessage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button call,whatsapp,browser,data,activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        call=findViewById(R.id.btn1);
        whatsapp=findViewById(R.id.btn2);
        browser=findViewById(R.id.btn3);
        data=findViewById(R.id.btn4);
        activity=findViewById(R.id.btn5);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             opencall();
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmessage();
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  senddata();
            }
            });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   openbrowser();
            }
        });
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void opencall()
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:+8802177690"));//change the number
       try {
           System.out.println(callIntent);
           startActivity(callIntent);
       }
       catch (Exception e)
       {

       }
    }
    public void sendmessage()
    {
        String digits = "\\d+";
        String mob_num = "8307547571";
        if (mob_num.matches(digits))
        {
            try {
                System.out.println("hello");
             //linking for whatsapp
                Uri uri = Uri.parse("whatsapp://send?phone=+91" + mob_num);
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                i.putExtra(Intent.EXTRA_TEXT, "hello aniket");
                i.setType("text/plain");
                startActivity(i);
            }
            catch (ActivityNotFoundException e){
                e.printStackTrace();
                Toast.makeText(this, "WhatsApp not installed.", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
