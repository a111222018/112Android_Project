package com.example.ui_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_string);

        TextView textshow=(TextView) findViewById(R.id.textViewShow);
        Intent intent=getIntent();
        textshow.setText(intent.getStringExtra("userInput")+" 您好!");
    }
}