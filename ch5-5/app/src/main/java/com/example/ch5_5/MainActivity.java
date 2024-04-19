package com.example.ch5_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    TextView txtoutput;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtoutput=(TextView)findViewById(R.id.txtOutput);
        txtoutput.setTextSize(25);
        layout=(ConstraintLayout) findViewById(R.id.activity_main);
        layout.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int act=event.getAction();
        switch (act){
            case MotionEvent.ACTION_DOWN:
                txtoutput.setText("ACTION_DOWN");
                txtoutput.setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_UP:
                txtoutput.setText("ACTION_UP");
                txtoutput.setTextColor(Color.GREEN);
                break;
            case MotionEvent.ACTION_MOVE:
                float x=event.getX();
                float y=event.getY();
                txtoutput.setText("x="+x+" y="+y);
                txtoutput.setTextColor(Color.BLUE);
                break;
        }
        return false;
    }
}