package com.example.explicitlntentdemo2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    ActivityResultLauncher launcher=registerForActivityResult(new ResultContract(),result ->{
        output.setText(result);
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output=(TextView)findViewById(R.id.lblOutput);
        Button button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch(true);
            }
        });
    }
    class ResultContract extends ActivityResultContract<Boolean, String> {//Boolean是傳送資料的型態，String是接收資料的型態

        @NonNull
        @Override
        //傳送資料

        public Intent createIntent(@NonNull Context context, Boolean aBoolean) {
            Intent intent=new Intent(MainActivity.this,Activity_operator.class);
            Bundle bundle=new Bundle();
            bundle.putString("opd1",((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            bundle.putString("opd2",((EditText) findViewById(R.id.txtOpd2)).getText().toString());
            intent.putExtras(bundle);
            return intent;
        }

        @Override
        //接收資料
        public String parseResult(int i, @Nullable Intent intent) {
            Bundle bundle=intent.getExtras();
            Double result=bundle.getDouble("result");
            return result.toString();
        }
    }

}