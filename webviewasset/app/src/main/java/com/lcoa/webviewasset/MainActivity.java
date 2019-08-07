package com.lcoa.webviewasset;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,secondactivity.class);


                Bundle bundle= new Bundle();
                bundle.putString("key","value");
                bundle.putString("key1","value1");
                intent.putExtras(bundle);
                //intent.putExtra("url","file:///android_asset/index.html");
                startActivity(intent);
            }
        });
    }
}
