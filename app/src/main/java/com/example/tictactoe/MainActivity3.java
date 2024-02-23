package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myFun();
    }
//    void myFun(){
//        TextView t=findViewById(R.id.textView1);
//        t.setText("hello");
//
//    }

    //global access part
    int gameState[]={2,2,2,2,2,2,2,2,2};

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8} ,
            {0,4,8},{2,4,6}};
    boolean isGamePlaying=true;
    int currentMove=1;


    //game code

    public void tap(View v){
        ImageView iv=(ImageView)v;
        int tappedSquare=Integer.parseInt(v.getTag().toString());
        Toast.makeText(this, gameState[0]+" "+gameState[1]+" "+gameState[2]+" "+gameState[3]+" "+gameState[4]+" "+gameState[5]+" "+gameState[6]+" "+gameState[7]+" "+gameState[8], Toast.LENGTH_LONG).show();

        if(gameState[tappedSquare]==2){

            if(currentMove==1){
                iv.setImageResource(R.drawable.x);
                gameState[tappedSquare]=currentMove;
                currentMove=0;
                cpuMove(currentMove,iv,tappedSquare);
            }
        }
    }
    public void cpuMove(int crtMove,ImageView iv,int tapVal){

    }





}