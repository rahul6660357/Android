package com.lcoa.mywebview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button Web1,Web2,Web3,Web4,Web5,Web6,Web7,Web8,Web9,Web10,Web11,Web12,Web13,Web14,Web15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//hiding the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen
        Web1=findViewById(R.id.web1);
        Web2=findViewById(R.id.web2);
        Web3=findViewById(R.id.web3);
        Web4=findViewById(R.id.web4);
        Web5=findViewById(R.id.web5);
        Web6=findViewById(R.id.web6);
        Web7=findViewById(R.id.web7);
        Web8=findViewById(R.id.web8);
        Web9=findViewById(R.id.web9);
        Web10=findViewById(R.id.web10);
        Web11=findViewById(R.id.web11);
        Web12=findViewById(R.id.web12);
        Web13=findViewById(R.id.web13);
        Web14=findViewById(R.id.web14);
        Web15=findViewById(R.id.web15);
        Web1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opengoogle();
            }
        });
        Web2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfacebook();
            }
        });
        Web3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openyoutube();
            }
        });
        Web4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentwitter();
            }
        });
        Web5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openinsta(); }});
        Web6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openyahoo();
            }
        });
        Web7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openamazon();
            }
        });
        Web8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openflipkart();
            }
        });
        Web9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmyntra();
            }
        });
        Web10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openoutlook();
            }
        });
        Web11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengmail();
            }
        });
        Web12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennetflix();
            }
        });
        Web13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openchrome();
            }
        });
        Web14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              opensnapchat();
            }
        });
        Web15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openquora();
            }
        });
    }
    public void opengoogle()
    {
        Intent intent= new Intent(this,secondactivity.class);
      //  Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        intent.putExtra("url","https://www.google.com");
    startActivity(intent);
}
    public void openfacebook()
    {
        Intent intent= new Intent(this,secondactivity.class);
       // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
        intent.putExtra("url","https://www.facebook.com/login/");
        startActivity(intent);
    }

    public void openyoutube()
    {
        Intent intent = new Intent(MainActivity.this,secondactivity.class);
        intent.putExtra("url","https://www.youtube.com/");
        startActivity(intent);
    }
    public void opentwitter()
    {
        Intent intent= new Intent(this,secondactivity.class);
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com"));
        intent.putExtra("url","https://twitter.com");
        startActivity(intent);
    }
    public void openinsta()
    {
        Intent intent= new Intent(this,secondactivity.class);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
        intent.putExtra("url","https://www.instagram.com/");
        startActivity(intent);
    }
    public void openyahoo()
    {
        Intent intent= new Intent(this,secondactivity.class);
       // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://in.yahoo.com"));
        intent.putExtra("url","https://in.yahoo.com");
        startActivity(intent);
    }
    public void openamazon()
    {
        Intent intent= new Intent(this,secondactivity.class);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in"));
        intent.putExtra("url","https://www.amazon.in");
        startActivity(intent);
    }
    public void openflipkart()
    {
        Intent intent= new Intent(this,secondactivity.class);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipkart.com"));
        intent.putExtra("url","https://www.flipkart.com");
        startActivity(intent);
    }
    public void openmyntra()
    {
        Intent intent= new Intent(this,secondactivity.class);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.myntra.com"));
        intent.putExtra("url","https://www.myntra.com");
        startActivity(intent);
    }
    public void openoutlook()
    {
        Intent intent= new Intent(this,secondactivity.class);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://outlook.live.com"));
        intent.putExtra("url","https://outlook.live.com");
        startActivity(intent);
    }
    public void opengmail()
    {
        Intent intent= new Intent(this,secondactivity.class);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com"));
        intent.putExtra("url","https://mail.google.com");
        startActivity(intent);
    }
    public void opennetflix()
    {
        Intent intent= new Intent(this,secondactivity.class);
       // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.netflix.com"));
        intent.putExtra("url","https://www.netflix.com");
        startActivity(intent);
    }
    public void openchrome()
    {
        Intent intent= new Intent(this,secondactivity.class);
       //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        intent.putExtra("url","https://www.google.com");
        startActivity(intent);
    }
    public void opensnapchat()
    {
        Intent intent= new Intent(this,secondactivity.class);
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.snapchat.com"));
        intent.putExtra("url","https://www.snapchat.com/");
        startActivity(intent);
    }
    public void openquora()
    {
        Intent intent= new Intent(this,secondactivity.class);
       // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hi.quora.com/"));
        intent.putExtra("url","https://hi.quora.com/");
        startActivity(intent);
    }
}
