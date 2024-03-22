package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtshow=(TextView) findViewById(R.id.textshow);
        txtshow.setTextSize(36);
        Button btncal=(Button) findViewById(R.id.buttonCalculate);
        Button btncle=(Button) findViewById(R.id.buttonClear);
        btncal.setOnClickListener(this);
        btncle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText edtHeight=(EditText) findViewById(R.id.editTextHeight);
        EditText edtWeight=(EditText) findViewById(R.id.editTextWeight);

        if(v.getId()==R.id.buttonCalculate){
            double height=Double.parseDouble(edtHeight.getText().toString());
            double weight=Double.parseDouble(edtWeight.getText().toString());
            double bmi=weight/Math.pow(height/100.0,2);
            if(bmi>=24){
                txtshow.setTextColor(Color.RED);
            }
            else if(bmi<18.5){
                txtshow.setTextColor(Color.BLUE);
            }
            else{
                txtshow.setTextColor(Color.GREEN);
            }
            txtshow.setText(String.format("%.2f",bmi));
        }
        else{
            edtHeight.setText("0");
            edtWeight.setText("0");
            txtshow.setText("");
        }
    }
}