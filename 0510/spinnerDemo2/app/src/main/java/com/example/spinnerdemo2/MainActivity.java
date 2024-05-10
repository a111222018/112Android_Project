package com.example.spinnerdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private EditText opd1, opd2;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opd1 = findViewById(R.id.txtOpd1);
        opd2 = findViewById(R.id.txtOpd2);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position) {
            try {
                if (position == 0) {
                    result.setText("Addition: " + (Integer.parseInt(opd1.getText().toString()) + Integer.parseInt(opd2.getText().toString())));
                } else if (position == 1) {
                    result.setText("Subtraction: " + (Integer.parseInt(opd1.getText().toString()) - Integer.parseInt(opd2.getText().toString())));
                } else if (position == 2) {
                    result.setText("Multiplication: " + (Integer.parseInt(opd1.getText().toString()) * Integer.parseInt(opd2.getText().toString())));
                } else if (position == 3) {
                    result.setText("Division: " + (Integer.parseInt(opd1.getText().toString()) / Integer.parseInt(opd2.getText().toString())));
                }
            } catch (Exception e) {
                result.setText("請輸入數字");
            }
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}