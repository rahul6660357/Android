package com.lcoa.activitycycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.btn2);
        Toast.makeText(MainActivity.this,"oncreate calls",Toast.LENGTH_LONG).show();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"oncreate calls",Toast.LENGTH_LONG).show();
                Intent i= new Intent(getApplicationContext(),activity1.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"onstart calls",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"onresume calls",Toast.LENGTH_LONG).show();
    }
}
