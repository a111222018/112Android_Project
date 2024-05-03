package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private ImageView img;
    private int[] rdbID={R.id.rdbDog,R.id.rdbMouse,R.id.rdbRabbit, R.id.rdbElephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView) findViewById(R.id.imgOutput);
    }





    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton rdb=(RadioButton) findViewById(checkedId);
        if(rdb.getId()==R.id.rdbDog){
            img.setImageResource(R.mipmap.dog);
        }
        else if(rdb.getId()==R.id.rdbMouse){
            img.setImageResource(R.mipmap.mouse);
        }
        else if(rdb.getId()==R.id.rdbRabbit){
            img.setImageResource(R.mipmap.rabbit);
        }
        else if(rdb.getId()==R.id.rdbElephant){
            img.setImageResource(R.mipmap.elephant);
        }
    }
}