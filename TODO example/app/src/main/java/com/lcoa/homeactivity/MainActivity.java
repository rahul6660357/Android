package com.lcoa.homeactivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lcoa.homeactivity.Adapter.adapter;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;

List<AddUser> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
recyclerView=findViewById(R.id.myrecycle);
final adapter add = new adapter(this, list);
recyclerView.setAdapter(add);

       RecyclerView.LayoutManager recycle= new  LinearLayoutManager(this);

firebaseDatabase=FirebaseDatabase.getInstance();
databaseReference=firebaseDatabase.getReference("Notes");
databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
        {
            AddUser list1=  dataSnapshot1.getValue(AddUser.class);
            list.add(list1);
            recyclerView.setHasFixedSize(true);
        }
        add.notifyDataSetChanged();
    }


    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,addnotes.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
