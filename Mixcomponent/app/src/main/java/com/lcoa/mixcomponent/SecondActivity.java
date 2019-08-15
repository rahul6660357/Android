package com.lcoa.mixcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String name= getIntent().getStringExtra("name");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        WebView web= findViewById(R.id.myweb);
        web.loadUrl("http://www.google.com");
        web.setWebViewClient(new WebViewClient());
    }
}
