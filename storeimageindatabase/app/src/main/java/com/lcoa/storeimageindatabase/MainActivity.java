package com.lcoa.storeimageindatabase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class MainActivity extends AppCompatActivity  {
Button btn1, btn2,btn3;
    private StorageReference mStorageRef;
ImageView imageView;
private static final int PICK_REQUEST=10;
private Uri filepath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.choosebtn);
        btn2=findViewById(R.id.uploadbtn);
        btn3=findViewById(R.id.uploadbtn);
        imageView=findViewById(R.id.myimage);
        mStorageRef = FirebaseStorage.getInstance().getReference();

       // Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_LONG).show();

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        FileChooser();
    }
});


btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        uploadfile();
    }
});

btn3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(MainActivity.this,secondactivity.class);
        startActivity(i);
    }
});


    }
    private void uploadfile()
    {
      if(filepath!=null) {
          final ProgressDialog progressDialog= new ProgressDialog(this);
          progressDialog.setTitle("uploading...");
          progressDialog.show();

          StorageReference riversRef = mStorageRef.child("images/profile.jpg");

          riversRef.putFile(filepath)
                  .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                      @Override
                      public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                       progressDialog.dismiss();
                       Toast.makeText(getApplicationContext(),"File uploaded",Toast.LENGTH_LONG).show();
                      }
                  })
                  .addOnFailureListener(new OnFailureListener() {
                      @Override
                      public void onFailure(@NonNull Exception exception) {
                          progressDialog.dismiss();
                          Toast.makeText(getApplicationContext(),exception.getMessage(),Toast.LENGTH_LONG).show();

                      }
                  }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
              @Override
              public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                  double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
              progressDialog.setMessage((int)progress+"% uploaded");
              }
          });
      }
    }
    private  void FileChooser()
    {

        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select a image"),PICK_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data)
    {
        super.onActivityResult(requestcode, resultcode, data);
        if (requestcode == PICK_REQUEST && resultcode == RESULT_OK && data != null && data.getData() != null) {
            filepath = data.getData();
            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
