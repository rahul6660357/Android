package com.lcoa.dialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8,Button9,Button0,Buttonstar,Buttonhash,btncall,btnmsg,btnwhats,Buttoncrs;
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//hiding the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen
   Button0=findViewById(R.id.btn0);
        Button1=findViewById(R.id.btn1);
        Button2=findViewById(R.id.btn2);
        Button3=findViewById(R.id.btn3);
        Button4=findViewById(R.id.btn4);
        Button5=findViewById(R.id.btn5);
        Button6=findViewById(R.id.btn6);
        Button7=findViewById(R.id.btn7);
        Button8=findViewById(R.id.btn8);
        Button9=findViewById(R.id.btn9);
        Buttonhash=findViewById(R.id.btnhash);
        Buttonstar=findViewById(R.id.star);
        btncall=findViewById(R.id.call);
        btnmsg=findViewById(R.id.msg);
        btnwhats=findViewById(R.id.whatsapp);
        Buttoncrs=findViewById(R.id.cross);

        text=findViewById(R.id.mytextview);

        if ((ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.CALL_PHONE  ) != PackageManager.PERMISSION_GRANTED)&& (ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.SEND_SMS ) != PackageManager.PERMISSION_GRANTED) ){
            ActivityCompat.requestPermissions(MainActivity.this,new String[] { Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS},10);
        }
        Buttoncrs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // text.setText("");
                String textString = text.getText().toString();
                if( textString.length() > 0 ) {
                    text.setText(textString.substring(0, textString.length() - 1 ));
                    //text.setSelection(text.getText().length());//position cursor at the end of the line
                }
            }
        });

        Buttoncrs.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                text.setText("");
                return false;
            }
        });
        Button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"0");
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"1");
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"2");
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"3");
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"4");
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"5");
            }
        });
        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"6");
            }
        });
        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"7");
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"8");
            }
        });
        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"9");
            }
        });
        Buttonstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"*");
            }
        });
        Buttonhash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(text.getText()+"#");
            }
        });
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialcall();
            }
        });
        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendmsg();
            }
        });
        btnwhats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  String str= text.getText().toString();

                Intent i = new Intent("android.intent.action.MAIN");
                i.setAction(Intent.ACTION_VIEW);
                i.setPackage("com.whatsapp");
                String url="https://api.whatsapp.com/send?phone=" + "+91"+text.getText().toString() + "&text=" + "hello everyone";
              //  i.putExtra(Intent.EXTRA_TEXT,"sbbahdzgx");
                i.setData(Uri.parse(url));

                startActivity(i);
            }
        });


    }
    public void dialcall()
    {
        String str="tel:"+ text.getText();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }
    public void sendmsg() {

        String str = text.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + str));

        intent.putExtra("sms_body", "hello");
        //  intent.setType("text/plain");

        if (intent.resolveActivity(getPackageManager()) != null) {

            startActivity(intent);
        }
    }
}
