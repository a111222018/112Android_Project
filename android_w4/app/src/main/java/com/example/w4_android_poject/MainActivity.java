package com.example.w4_android_poject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void submit(View view){
        EditText edtName=(EditText) findViewById(R.id.editTextText);
        TextView show=(TextView) findViewById(R.id.textView2);
        String name=edtName.getText().toString();
        show.setText("你的名字:"+name);
    }
}