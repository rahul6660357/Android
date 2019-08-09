package com.lco.tictactoe;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button[][] button= new Button[3][3];
private boolean player1turn=true;
private int roundcount;

private int player1points;
private int player2points;
private TextView textplayer1,textplayer2,textplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 16) {
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//for full screen
        setContentView(R.layout.activity_main);
        textplayer1 = findViewById(R.id.text1);
        textplayer2 = findViewById(R.id.text2);
        textplayer = findViewById(R.id.myview);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "btn" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                button[i][j] = findViewById(resID);
                button[i][j].setOnClickListener(this);
            }
        }
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        button[i][j].setText("");
                    }
                }
                roundcount=0;
                textplayer.setText("");
            }
        });
    }
    public  void onClick(View v){
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("0");
        }
        roundcount++;
        if (checkforwin()) {
            if (player1turn) {
                player1wins();
            } else {
                player2Wins();
            }
        } else if (roundcount == 9) {
            draw();
        } else {
            player1turn = !player1turn;
        }


    }

    private boolean checkforwin() {
        String feild[][] = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                feild[i][j] = button[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (feild[i][0] == feild[i][1] && feild[i][1] == feild[i][2] && !feild[i][0].equals("")) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (feild[0][i] == feild[1][i] && feild[1][i] == feild[2][i] && !feild[0][i].equals("")) {
                return true;
            }
        }
        if (feild[0][0] == feild[1][1] && feild[1][1] == feild[2][2] && !feild[0][0].equals("")) {
            return true;
        }
        if (feild[0][2] == feild[1][1] && feild[1][1] == feild[2][0] && !feild[0][2].equals("")) {
            return true;
        }


        return false;

    }

    private void player1wins() {
        player1points++;
        textplayer.setText("player 1 wins");
        //Toast.makeText(this,"player 1 wins",Toast.LENGTH_LONG).show();
        updatepointsText();
       // resetBoard();
    }

    private void player2Wins() {
        player2points++;
        textplayer.setText("player 2 wins");
        //Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatepointsText();
        //resetBoard();
    }

    private void draw() {
        textplayer.setText("draw");
        //Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatepointsText() {
        textplayer1.setText("no. of times player1 wins:" + player1points);
        textplayer2.setText("no. of times player2 wins:" + player2points);
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setText("");
            }
        }
        roundcount = 0;
        player1turn = true;
    }
}