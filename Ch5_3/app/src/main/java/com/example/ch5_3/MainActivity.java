package com.example.ch5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {

    private  final float original_size=20;
    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=(TextView) findViewById(R.id.lblOutput);
        output.setTextSize(original_size);
        Button btnEnlarge=(Button) findViewById(R.id.large);
        btnEnlarge.setOnClickListener(this);
        btnEnlarge.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
            float size=output.getTextSize();//此時的size為px
            output.setTextSize(pxTosp(this,size)+5);
            Log.v("SIZE", String.valueOf(size));

    }

    @Override
    public boolean onLongClick(View v) {
        output.setTextSize(original_size);
        return false;
    }

    public  static  int pxTosp(Context context,float pxValue){
        final float fontScale=context.getResources().getDisplayMetrics().scaledDensity;
        return  (int)(pxValue/fontScale+0.5f);
    }
}