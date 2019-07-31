package com.lcoa.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;
    EditText amount,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen

        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button3=findViewById(R.id.btn3);
        button4=findViewById(R.id.btn4);
        button5=findViewById(R.id.btn5);
        button6=findViewById(R.id.btn6);
        button7=findViewById(R.id.btn7);
        button8=findViewById(R.id.btn8);
        button9=findViewById(R.id.btn9);
        button10=findViewById(R.id.btn10);
        button11=findViewById(R.id.btn11);
        button12=findViewById(R.id.btn12);
        amount=findViewById(R.id.india);
        //  result=findViewById(R.id.result);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 69.52;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch(Exception e)
                {

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 17.91;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch(Exception e)
                {

                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 10.04;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch(Exception e)
                {

                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 38.62;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch (Exception e)
                {

                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 0.88;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch(Exception e)
                {

                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 0.0049;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch(Exception e)
                {

                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 0.15;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch (Exception e)
                {

                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 0.64;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch(Exception e)
                {

                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 40.77;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch(Exception e)
                {

                }
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 0.82;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch (Exception e)
                {

                }
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 33.46;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch (Exception e)
                {

                }
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int number = Integer.parseInt(amount.getText().toString());
                    double x = 0.0423;
                    double f = number / x;
                    Toast.makeText(MainActivity.this, Double.toString(f), Toast.LENGTH_LONG).show();

                    EditText result = (EditText) findViewById(R.id.result);
                    result.setText(Double.toString(f));
                }
                catch (Exception e)
                {

                }
            }
        });





    }
}
