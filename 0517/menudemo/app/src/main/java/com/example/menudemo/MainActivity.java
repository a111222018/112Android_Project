package com.example.menudemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);


        
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        TextView textView = findViewById(R.id.lblOutput);
        int tmp;
        double result;
        EditText txttmp = findViewById(R.id.txtTemp);
        tmp=Integer.parseInt(txttmp.getText().toString());
        if(item.getItemId()==R.id.toC){
            result = (tmp-32)*5/9;
            textView.setText("Result: "+result);
        }
        else if(item.getItemId()==R.id.toF){
            result = (tmp*9/5)+32;
            textView.setText("Result: "+result);
        }
        return super.onOptionsItemSelected(item);
    }
}