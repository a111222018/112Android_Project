package com.example.w3_androidproject_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int counter;
    public  void add_click(View view){

        TextView output=findViewById(R.id.textView);
        counter=Integer.parseInt(output.getText().toString());
        counter++;
        output.setText(Integer.toString(counter));
    }

    public  void reset_click(View view){
        //int counter;
        TextView output=findViewById(R.id.textView);
        output.setText(R.string.initial_value);
    }

    public  void reduce_click(View view){
        TextView output=findViewById(R.id.textView);
        counter=Integer.parseInt(output.getText().toString());
        counter--;
        output.setText(Integer.toString(counter));
    }
}