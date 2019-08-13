package com.lcoa.databasestore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class secondactivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
 public String gender="";
    Button sendbutton1;
    public EditText calendar;
EditText editText1,editText2,editText3;
DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
       // databaseReference= FirebaseDatabase.getInstance().getReference();
databaseReference= FirebaseDatabase.getInstance().getReference();

        editText1=findViewById(R.id.myphn);
        editText2=findViewById(R.id.mycity);
        calendar=(EditText)findViewById(R.id.bithdate);
        sendbutton1=findViewById(R.id.sendbutton);
        sendbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b= new Bundle();
                b=getIntent().getExtras();
                String Username= b.getString("username");
                String Useremail= b.getString("useremail");
                String Userpassword= b.getString("userpassword");
                String dob=editText3.getText().toString();
                String city=editText2.getText().toString();
                String phnno=editText1.getText().toString();


                adduser(Username,Useremail,Userpassword,phnno,city,dob,gender);
            }
        });

        Spinner spinner=findViewById(R.id.myspinner);



        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.gender,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(secondactivity.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String gender=""+ parent.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(),"no item selected in spinner",Toast.LENGTH_LONG).show();

    }
public  void adduser(String Username, String Useremail, String password, String phnno, String city, String dob,String gender)
{
    if(phnno.length()==10 && !TextUtils.isEmpty(city) && !TextUtils.isEmpty(dob))
    {
     // String id= databaseReference.push().getKey();

      //AddUser add= new AddUser(id,Username,Useremail,password,phnno,city,dob,gender);
      //databaseReference.child( id).setValue(add);
      editText1.setText("");
      editText2.setText("");
      editText3.setText("");

    }
    else
    {
        Toast.makeText(getApplicationContext(),"check your details",Toast.LENGTH_LONG).show();
    }
}
}
