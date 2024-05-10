package com.example.spinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private  String[] courses,desserts;

    private Spinner spCourses,spDesserts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = getResources().getStringArray(R.array.courses);
        desserts = getResources().getStringArray(R.array.desserts);

        spCourses = findViewById(R.id.spinner);
        spDesserts = findViewById(R.id.spinner2);

        ArrayAdapter<String> adpCourses=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,courses);
        ArrayAdapter<String> adpDesserts=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,desserts);

        spCourses.setAdapter(adpCourses);
        spDesserts.setAdapter(adpDesserts);

        Button confirm= findViewById(R.id.button);
        confirm.setOnClickListener(v -> {
            String course = spCourses.getSelectedItem().toString();
            String dessert = spDesserts.getSelectedItem().toString();
            TextView output= findViewById(R.id.lblOutput);
            output.setText("主餐:"+course+"\n甜點:"+dessert);
        });

        Button btnModify =(Button) findViewById(R.id.button2);

        btnModify.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                desserts[4]="草莓蛋糕";
                adpDesserts.notifyDataSetChanged();
            }
        }
        );

    }
}