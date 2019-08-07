package com.lcoa.webviewasset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {
WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        web=findViewById(R.id.myweb);
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        String key = b.getString("key");
        String key1= b.getString("key1");
        Toast.makeText(getApplicationContext(),key,Toast.LENGTH_LONG).show();



        Toast.makeText(getApplicationContext(),key1,Toast.LENGTH_LONG).show();



        //  web.loadUrl(name);
       // web.setWebViewClient(new WebViewClient());
    }
}
