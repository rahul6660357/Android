package com.lcoa.Myapplicationss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageview;
    private Button button;
    int first=0, count=0;
    float last=0;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageview =findViewById(R.id.imageview2);
        button=findViewById(R.id.btn1);
        getSupportActionBar().hide();//hiding the title bar

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin();
                count++;
                if(count>0)
                {
                    first=(int)last;
                }
            }
        });

    }
    private void spin()
    {

        int pivotY = imageview.getHeight()/2;
        int pivotX = imageview.getWidth()/2;
        last = (int) (3000 + Math.random()*600);
        System.out.println(last);
        if(last<first)
        {
            last = first+last;
        }
        Animation rotate = new RotateAnimation(first,last,pivotX,pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        imageview.startAnimation(rotate);
    }
}
