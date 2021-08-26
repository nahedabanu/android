package com.example.android.customcomponent;
import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView simpleText = (TextView) findViewById(R.id.simple);
        simpleText.setText("That is a simple TextView");
    }
}