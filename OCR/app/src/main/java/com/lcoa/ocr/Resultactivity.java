package com.lcoa.ocr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultactivity extends AppCompatActivity {
Button btn1;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultactivity);
        btn1=findViewById(R.id.back);
        textView=findViewById(R.id.texttext);
        Intent it= getIntent();
        String str=it.getStringExtra("result");
        textView.setText(str);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
