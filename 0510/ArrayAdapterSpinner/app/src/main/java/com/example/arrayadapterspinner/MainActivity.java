package com.example.arrayadapterspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner drink,temp;

    private TextView txv;

    private String[] tempSet1={"冰","去冰","溫"};
    private String[] tempSet2={"冰","去冰"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv=(TextView)findViewById(R.id.order);
        temp=(Spinner)findViewById(R.id.temp);

        drink=(Spinner)findViewById(R.id.drink);
        drink.setOnItemSelectedListener(this);

        Button submit=(Button)findViewById(R.id.btnOrder);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txv.setText("飲料:"+drink.getSelectedItem().toString()+"\n甜度:"+temp.getSelectedItem().toString());
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String[] tempSet=null;
        if(position==3)
            tempSet=tempSet2;
        else
            tempSet=tempSet1;

        temp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tempSet));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}