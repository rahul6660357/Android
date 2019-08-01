package com.lcoa.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
ImageView imageView1, imageView2;
Button rollbtn;
public static  final Random random=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollbtn=findViewById(R.id.rollbtn);
        imageView1=findViewById(R.id.myimg1);
        imageView2=findViewById(R.id.myimg2);
      rollbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              int value2=findrandomno();
              final Animation anim1= AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake);
              final Animation anim2= AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake);
              final Animation.AnimationListener animationListener=new Animation.AnimationListener() {
                  @Override
                  public void onAnimationStart(Animation animation) {
                      int value1=findrandomno();
                      int value2=findrandomno();

                      int res1=getResources().getIdentifier("dice"+value1,"drawable","com.lcoa.diceroller");
                      int res2=getResources().getIdentifier("dice"+value2,"drawable","com.lcoa.diceroller");
                      if(animation==anim1)
                      {
                          imageView1.setImageResource(res1);
                      }else if(animation==anim2)
                      {
                          imageView2.setImageResource(res2);
                      }
                  }

                  @Override
                  public void onAnimationEnd(Animation animation) {

                  }

                  @Override
                  public void onAnimationRepeat(Animation animation) {

                  }
              };

anim1.setAnimationListener(animationListener);
              anim2.setAnimationListener(animationListener);
              imageView1.startAnimation(anim1);
              imageView2.startAnimation(anim2);


          }
      });

    }
    public int findrandomno()
    {
        return random.nextInt(6)+1;
    }
}
