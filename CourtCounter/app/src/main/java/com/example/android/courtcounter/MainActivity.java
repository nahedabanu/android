package com.example.android.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void addThreeToTeamA(View v){
        scoreTeamA+=3;
        displayTeamAScore(scoreTeamA);
    }
    public void addTwoToTeamA(View v){
        scoreTeamA+=2;
        displayTeamAScore(scoreTeamA);
    }
    public void addOneToTeamA(View v){
        scoreTeamA+=1;
        displayTeamAScore(scoreTeamA);
    }
    public void addThreeToTeamB(View v){
        scoreTeamB+=3;
        displayTeamBScore(scoreTeamB);
    }
    public void addTwoToTeamB(View v){
        scoreTeamB+=2;
        displayTeamBScore(scoreTeamB);
    }
    public void addOneToTeamB(View v){
        scoreTeamB+=1;
        displayTeamBScore(scoreTeamB);
    }
    public void displayTeamAScore( int number){
        TextView t =(TextView) findViewById(R.id.team_A_score);
        t.setText(String.valueOf(number));
    }
    public void displayTeamBScore( int number){
        TextView t =(TextView) findViewById(R.id.team_B_score);
        t.setText(String.valueOf(number));
    }
    public void resetScoreToZero(View v)
    {
        scoreTeamA=0;
        scoreTeamB=0;
        displayTeamAScore(scoreTeamA);
        displayTeamBScore(scoreTeamB);
    }

}