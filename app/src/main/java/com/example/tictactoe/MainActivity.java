package com.example.tictactoe;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp[]=new MediaPlayer[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp[0]=MediaPlayer.create(this,R.raw.mario);
        mp[1]=MediaPlayer.create(this,R.raw.success);
        mp[2]=MediaPlayer.create(this,R.raw.error1);
        mp[3]=MediaPlayer.create(this,R.raw.welcome);
        mp[3].start();
    }
    boolean isGameActive=true;
    int currentPlayer=0;
    int[] squareState={2,2,2,2,2,2,2,2,2};
    int[][] winConditions={{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8} ,
            {0,4,8},{2,4,6}};


    public void tap(View v){

        ImageView iv=(ImageView)v;
//        Toast.makeText(this,iv.getTag().toString(), Toast.LENGTH_SHORT).show();
        int tappedTag=Integer.parseInt(iv.getTag().toString());

        if(squareState[tappedTag]==2 && isGameActive){
//            Toast.makeText(this, "value stored", Toast.LENGTH_SHORT).show();
            squareState[tappedTag]=currentPlayer;
//            Toast.makeText(this, squareState[0]+" "+squareState[1]+" "+squareState[2]+" "+squareState[3]+" "+squareState[4]+" "+squareState[5]+" "+squareState[6]+" "+squareState[7]+" "+squareState[8], Toast.LENGTH_LONG).show();
//            iv.setTranslationY(-1000f);
            mp[0].start();
            TextView status=findViewById(R.id.textView);
            if(currentPlayer==0){
                iv.setImageResource(R.drawable.x);

                status.setText("O's Turn Tap To Play");
                currentPlayer=1;
            }
            else{

                iv.setImageResource(R.drawable.o);
                status.setText("X's Turn Tap To Play");
                currentPlayer=0;
            }
        }

        //checking if someone won or not

        TextView t=findViewById(R.id.textView);
        TextView head=findViewById(R.id.textView1);
       for(int arr[]:winConditions)
       {
         if(squareState[arr[0]]==squareState[arr[1]] && squareState[arr[1]]==squareState[arr[2]] && squareState[arr[0]]!=2){
//             Toast.makeText(this, "in winning block", Toast.LENGTH_SHORT).show();
             if(squareState[arr[0]]==0)
             {
                 t.setText("X IS WON");
                 mp[0].pause();
                 mp[1].start();
                 isGameActive=false;
                 head.setText("PLEASE RESTART THE GAME");
             }
             else if(squareState[arr[0]]==1){
                 t.setText("O IS WON");
                 isGameActive=false;
                 mp[0].pause();
                 mp[1].start();
                 head.setText("PLEASE RESTART THE GAME");
             }

         }


       }
       if(isGameActive && squareState[0]!=2 && squareState[1]!=2 && squareState[2]!=2 && squareState[3]!=2 && squareState[4]!=2 && squareState[5]!=2 && squareState[6]!=2 && squareState[7]!=2 && squareState[8]!=2 ){
           TextView ttail=findViewById(R.id.textView);
           ttail.setText("MATCH IS DRAW");
       }

       }


       public void gameReset(View v){
           mp[2].start();
           TextView head=findViewById(R.id.textView1);
           head.setText("Player VS Player");
           TextView tDown=findViewById(R.id.textView);
           tDown.setText("TAP TO PLAY");
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        for(int u=0;u<9;u++){
            squareState[u]=2;
        }
        isGameActive=true;


      }


    }
