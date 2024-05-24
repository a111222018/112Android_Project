package com.example.datetimepickerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private TextView txtOutput;
    private Calendar dt=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOutput = findViewById(R.id.lblOutput);
        Button btnDate = findViewById(R.id.buttonDate);
        Button btnTime = findViewById(R.id.buttonTime);


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DatePickerDialog dlg=new DatePickerDialog(MainActivity.this,
                        MainActivity.this,
                        dt.get(Calendar.YEAR),
                        dt.get(Calendar.MONTH),
                        dt.get(Calendar.DAY_OF_MONTH));
                dlg.getDatePicker().setMinDate(System.currentTimeMillis());
                dlg.show();
            }

        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TimePickerDialog dlg=new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                                dt.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                dt.set(Calendar.MINUTE, minute);
                                txtOutput.setText("Time: "+dt.getTime().toString());
                            }
                        },
                        dt.get(Calendar.HOUR_OF_DAY),
                        dt.get(Calendar.MINUTE),
                        false);
                dlg.show();
            }

        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        dt.set(Calendar.YEAR, year);
        dt.set(Calendar.MONTH, month);
        dt.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        txtOutput.setText("Date: "+dt.getTime().toString());
    }


}