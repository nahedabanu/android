package com.example.android.practiceset2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int weekday=5;
    int weekend=9;
    int optimalHours=56;
    int actualHours=(weekday * 5)+(weekend*2);
    int solution=optimalHours-actualHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void sleepCalculate(View view)
    {
        displayHours(solution);
    }
    public void  displayHours(int solution)
    {
        TextView t =(TextView) findViewById(R.id.text_view_1);
        t.setText(new StringBuilder().append("").append(solution).toString());
    }
    public void avgTravel(View view)
    {
        displayTravelHours(18, 22 ,28);
    }
    public void displayTravelHours(int day1, int day2, int day3)
    {
    TextView t1= (TextView) findViewById(R.id.text_view_2);
    float value=(day1+day2+day3)/3;
    t1.setText(""+value);
    }
}