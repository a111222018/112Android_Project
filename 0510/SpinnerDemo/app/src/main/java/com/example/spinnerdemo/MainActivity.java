package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnConfirm=(Button)findViewById(R.id.button);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String[] steaks=getResources().getStringArray(R.array.steaks);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        int index=spinner.getSelectedItemPosition();
        TextView output=(TextView)findViewById(R.id.lblOutput);
        output.setText("牛排要 "+steaks[index]);
    }
}