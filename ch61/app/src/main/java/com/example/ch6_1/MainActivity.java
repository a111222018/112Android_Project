package com.example.ch6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.biometrics.BiometricManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                RadioGroup rgGender=(RadioGroup) findViewById(R.id.rgGender);
                RadioGroup rgType=(RadioGroup) findViewById(R.id.rgType);
                int selectedGenderID = rgGender.getCheckedRadioButtonId();
                int selectedTypeID = rgType.getCheckedRadioButtonId();
                RadioButton selectedGenderradio = findViewById(selectedGenderID);
                RadioButton selectedTyperadio = findViewById(selectedTypeID);
                str += selectedGenderradio.getText().toString() +"\n";
                str += selectedTyperadio.getText().toString() +"\n";
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(str);
            }
        });


    }
}