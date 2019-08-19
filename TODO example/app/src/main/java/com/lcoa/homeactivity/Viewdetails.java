package com.lcoa.homeactivity;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Viewdetails extends AppCompatActivity {
EditText edit1, edit2;
Button btn1, btn2;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetails);
        edit1=findViewById(R.id.mytitle);
        edit2=findViewById(R.id.mydesc);
        btn1=findViewById(R.id.myupdate);
        btn2=findViewById(R.id.mydlt);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        final Intent i= getIntent();
        final String ID= i.getStringExtra("id");
        String DESC=i.getStringExtra("desc");
        String TITLE=i.getStringExtra("title");
        edit1.setText(TITLE);
        edit2.setText(DESC);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedata(ID);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletedata(ID);
            }
        });

    }
    public  void updatedata( String ID)
    {
 String  title=edit1.getText().toString();
 String desc=edit2.getText().toString();
 AddUser addUser=new AddUser(ID,title,desc);
        databaseReference.child("NOTES").child(ID).setValue(addUser).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(),"updated successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        edit1.setText("");
        edit2.setText("");
    }
    public  void deletedata(String ID)
    {
        databaseReference.child("NOTES").child(ID).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(),"updated successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
