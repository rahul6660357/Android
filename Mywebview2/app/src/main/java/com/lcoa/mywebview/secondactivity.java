package com.lcoa.mywebview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,Window.PROGRESS_VISIBILITY_ON);
        getSupportActionBar().hide();//hiding the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen

        String name= getIntent().getStringExtra("url");
       Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        WebView web= findViewById(R.id.myweb);
        web.loadUrl(name);
         web.getSettings().setJavaScriptEnabled(true);
         final ProgressDialog p=new ProgressDialog(this);

        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view , String url, Bitmap favicon)
            {
                super.onPageStarted(view, url, favicon);
                p.setMessage("loading...");
                p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                p.setCancelable(false);
                p.show();
            }
            @Override
            public void onPageFinished(WebView view,String url){
                super.onPageFinished(view, url);
                p.cancel();
            }
            @Override
            public void onLoadResource(WebView view,String url)
            {
                super.onLoadResource(view, url);

            }
        });
    }
}

