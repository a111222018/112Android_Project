package com.example.w4_tem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void submit(View view){
        EditText input=(EditText) findViewById(R.id.editTextText);
        TextView result=(TextView) findViewById(R.id.textResult);
        Double tem =Double.parseDouble(input.getText().toString())*(9/5)+32;
        result.setText("華氏溫度:"+String.format("%.2f",tem) );
    }
}