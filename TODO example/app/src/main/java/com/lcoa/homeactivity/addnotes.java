package com.lcoa.homeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class addnotes extends AppCompatActivity {

EditText edit1,edit2;
Button btn1;
private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotes);
        edit1=findViewById(R.id.mytext1);
        databaseReference=FirebaseDatabase.getInstance().getReference();
        edit2=findViewById(R.id.mytext2);
        btn1=findViewById(R.id.mybtn);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edit1.getText().toString();
                String des = edit2.getText().toString();
                addData(title,des);
                Intent i = new Intent(addnotes.this,MainActivity.class);
                startActivity(i);
            }
            });
        }
        public  void addData(String title, String des)
        {
            String id= databaseReference.push().getKey();
            AddUser addUser= new AddUser(id,title,des);
            databaseReference.child("Notes").child(id).setValue(addUser);
        }
}
