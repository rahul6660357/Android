package com.lcoa.activitycycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity1 extends AppCompatActivity {
Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        button1=findViewById(R.id.btn1);
        Toast.makeText(activity1.this,"oncreate1 calls",Toast.LENGTH_LONG).show();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_activity1);
        Toast.makeText(activity1.this,"onstart1 calls",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_activity1);
        Toast.makeText(activity1.this,"onresume1 calls",Toast.LENGTH_LONG).show();
    }
}
