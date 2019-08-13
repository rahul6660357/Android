package com.lcoa.databasestore;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
EditText edit1, edit2, edit3;
Button btn1;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=findViewById(R.id.myedit1);
        edit2=findViewById(R.id.myedit2);
        btn1=findViewById(R.id.mybtn);
        edit3=findViewById(R.id.mypass);
firebaseAuth=FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edit1.getText().toString();
                String email=edit2.getText().toString();
                String password= edit3.getText().toString();

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(getApplicationContext(),"check your details ",Toast.LENGTH_LONG).show();
                }
                else if(password.length()<6 && email.length()<6)
                {
                    Toast.makeText(getApplicationContext(),"enter a strong password",Toast.LENGTH_LONG).show();
                }
                else {
                    loginapp(email,password);
                    Intent intent = new Intent(MainActivity.this, secondactivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", name);
                    bundle.putString("useremail", email);
                    bundle.putString("userpassword", password);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    edit1.setText("");
                    edit2.setText("");
                    edit3.setText("");
                }
            }
        });
    }   public void loginapp(String str1,String str2)
    {
        firebaseAuth.createUserWithEmailAndPassword(str1,str2).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"login successfully",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"login failed please check your password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
