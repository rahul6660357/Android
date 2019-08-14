package com.lcoa.runtimepermission;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button1, button2;

int REQUEST_READ_STORAGE=1;
int CAMERA_A=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)  {
                    Toast.makeText(MainActivity.this, "you already granted the permission", Toast.LENGTH_LONG).show();

                } else {
                    requestcamera();
                   // requestinternet();

                }
                /*    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(MainActivity.this, "you already granted the permission", Toast.LENGTH_LONG).show();

                    } else {
                        requestinternet();
                    }*/
                }

        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(MainActivity.this,"you already granted the permission",Toast.LENGTH_LONG).show();

                }else
                {
                    requestpermissionstorage();
                }
            }
        });
    }
    /*private void requestinternet()
    {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)){
            new AlertDialog.Builder(this).setTitle("Permission needed").setMessage("this permission requires your authentication for the use of this app").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.INTERNET},INTERNETT);
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();

        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET},CAMERA_A);
        }
    }*/
    private void requestcamera()
    {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            new AlertDialog.Builder(this).setTitle("Permission needed").setMessage("this permission requires your authentication for the use of this app").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.INTERNET,Manifest.permission.ACCESS_COARSE_LOCATION},CAMERA_A);
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();

        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA},CAMERA_A);
        }
    }



    private void requestpermissionstorage()
    {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
         new AlertDialog.Builder(this).setTitle("Permission needed").setMessage("this permission requires your authentication for the use of this app").setPositiveButton("OK", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_READ_STORAGE);
             }
         }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 dialog.dismiss();
             }
         }).create().show();

        }
        else
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_READ_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_READ_STORAGE)
        {
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
              Toast.makeText(this,"pemission granted", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"permission denied",Toast.LENGTH_LONG).show();
            }
        }
    }
}
