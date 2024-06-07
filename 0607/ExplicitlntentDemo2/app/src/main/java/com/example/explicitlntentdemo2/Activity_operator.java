package com.example.explicitlntentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity_operator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator);

        Button btn2=(Button)findViewById(R.id.button2);

        RadioButton rdbDivide=(RadioButton)findViewById(R.id.rdbDivide);
        rdbDivide.setOnCheckedChangeListener((buttonView, isChecked) -> {
            CheckBox chkDivide=(CheckBox)findViewById(R.id.chkDivide);
            if (isChecked) {
                chkDivide.setEnabled(true);
            } else {
                chkDivide.setEnabled(false);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opd1, opd2;
                double result = 0.0;
                RadioButton rdoAdd, rdoSub, rdoMul, rdoDiv;
                CheckBox chkDivide;

                Bundle bundle = Activity_operator.this.getIntent().getExtras();
                if (bundle == null) return;
                opd1 = Integer.parseInt(bundle.getString("opd1"));
                opd2 = Integer.parseInt(bundle.getString("opd2"));

                rdoAdd = (RadioButton) findViewById(R.id.rdbAdd);
                rdoSub = (RadioButton) findViewById(R.id.rdbSubtract);
                rdoMul = (RadioButton) findViewById(R.id.rdbMultiply);
                rdoDiv = (RadioButton) findViewById(R.id.rdbDivide);
                if (rdoAdd.isChecked())
                    result = opd1 + opd2;
                else if (rdoSub.isChecked())
                    result = opd1 - opd2;
                else if (rdoMul.isChecked())
                    result = opd1 * opd2;

                chkDivide = (CheckBox) findViewById(R.id.chkDivide);
                if (rdoDiv.isChecked()) {
                    chkDivide.setEnabled(true);
                    if (chkDivide.isChecked()) {
                        result = opd1 / opd2;

                    }
                    else{
                        result = opd1 / (double) opd2;
                    }
                }
                else{
                    chkDivide.setEnabled(false);
                }
                Intent rIntent = new Intent();

                Bundle rBundle = new Bundle();
                rBundle.putDouble("result", result);
                rIntent.putExtras(rBundle);
                setResult(RESULT_OK, rIntent);
                finish();

            }
        });


    }

}