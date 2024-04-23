package com.example.ui_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }
    public void submit(View view){
        EditText EditTextinput=(EditText) findViewById(R.id.editTextInput);
        String input=EditTextinput.getText().toString();

        Intent intent=new Intent(this, DisplayStringActivity.class);
        intent.putExtra("userInput",input);
        startActivity(intent);
    }
}