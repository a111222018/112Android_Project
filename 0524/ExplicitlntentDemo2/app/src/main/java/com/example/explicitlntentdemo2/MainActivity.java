package com.example.explicitlntentdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output=(TextView)findViewById(R.id.lblOutput);
        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtopd1,txtopd2;
                txtopd1=(EditText)findViewById(R.id.txtOpd1);
                txtopd2=(EditText)findViewById(R.id.txtOpd2);
                Intent intent=new Intent(MainActivity.this,Activity_operator.class);
                Bundle bundle=new Bundle();
                bundle.putString("opd1",txtopd1.getText().toString());
                bundle.putString("opd2",txtopd2.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode,resultCode,data);
        //requestCode is the code that we have sent to the activity
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Bundle bundle=data.getExtras();
                double result=bundle.getDouble("result");
                TextView lblOutput=(TextView)findViewById(R.id.lblOutput);
                lblOutput.setText("計算結果"+result);
            }
        }

    }
}