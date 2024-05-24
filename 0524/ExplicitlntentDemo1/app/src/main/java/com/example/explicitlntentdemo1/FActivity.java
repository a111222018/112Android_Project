package com.example.explicitlntentdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factivity);

        converTempture();

        Button btnreturn=(Button) findViewById(R.id.btnreturn);

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void converTempture(){
        int c;
        double f=0.0;
        String plac="";
        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null){
            c=bundle.getInt("tempC");
            plac=bundle.getString("place");
            f=c*9/5+32;
            TextView output=(TextView) findViewById(R.id.lblOutput);
            output.setText("Temperature in "+plac+" is "+f+" F");
        }
    }
}