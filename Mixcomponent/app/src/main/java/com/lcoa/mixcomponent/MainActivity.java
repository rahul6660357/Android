package com.lcoa.mixcomponent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button call, browser,whatsapp,senddata,thirdactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=findViewById(R.id.btn1);
        browser=findViewById(R.id.btn2);
        whatsapp=findViewById(R.id.btn3);
        senddata=findViewById(R.id.btn4);
        thirdactivity=findViewById(R.id.btn5);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencall();
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbrowser();
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openwhatsapp();

            }
        });
        senddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendinfo();
            }
        });
        thirdactivity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
Intent intent= new Intent(MainActivity.this,thirdactivity.class);
startActivity(intent);
                    }
                }
        );
    }
    public void opencall()
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9996660357"));
        startActivity(intent);
    }
    public void openbrowser()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.learncodeonline.in"));
        startActivity(intent);
    }
    public  void openwhatsapp()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "hello aniket");
        intent.setType("text/plain");
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        startActivity(intent);
    }
    public  void sendinfo()
    {
        Intent intent= new Intent(this,SecondActivity.class);
        intent.putExtra("name","rahul");
        startActivity(intent);
    }

}
