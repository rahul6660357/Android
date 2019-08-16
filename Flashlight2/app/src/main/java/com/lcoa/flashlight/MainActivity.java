package com.lcoa.flashlight;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private CameraManager cameraManager;
    private ImageView ivonoff;
    private String  backcameraid;
    private boolean istorchon=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivonoff=findViewById(R.id.imageView);
        istorchon=false;
        ivonoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(istorchon)
                    {
                        turnofflight();
                        istorchon=false;
                    }
                    else
                    {
                        turnonlight();
                        istorchon=true;
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        Boolean isflashavailable=getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if(!isflashavailable)
        {
            AlertDialog alert= new AlertDialog.Builder(MainActivity.this).create();
            alert.setTitle("FlashLightApp");
            alert.setMessage("no flash in your device");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
            return;

        }
        else
        {
            cameraManager= (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            try{
                backcameraid= cameraManager.getCameraIdList()[0];
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public void turnonlight()
    {
        try
        {
            if(Build.VERSION.SDK_INT >=23)
            {
                cameraManager.setTorchMode(backcameraid,true);
                ivonoff.setImageResource(R.drawable.power1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void turnofflight()
    {
        try
        {
            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M)
            {
                cameraManager.setTorchMode(backcameraid,false);
                ivonoff.setImageResource(R.drawable.power2);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    protected void onStop()
    {
        super.onStop();
        if(istorchon){
            turnofflight();
        }
    }


}

