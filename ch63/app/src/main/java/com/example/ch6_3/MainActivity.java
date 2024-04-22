package com.example.ch6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaDrm;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    private TextView output;
    private EditText txt;
    private RadioGroup rg;
    private RadioGroup rt;

    private  String str = "";
    private  String gender="";
    private  String ticket="";
    private  int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得View物件
        output = (TextView) findViewById(R.id.lblOutput);
        // 註冊傾聽者物件
        rg = (RadioGroup) findViewById(R.id.rgGender);
        rt = (RadioGroup) findViewById(R.id.rgticket);
        rg.setOnCheckedChangeListener(this);
        rt.setOnCheckedChangeListener(this);
        txt = (EditText) findViewById(R.id.txtName);
        txt.addTextChangedListener(this);
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        show(rg.getCheckedRadioButtonId(),"txt");
    }
    @Override
    public void afterTextChanged(Editable editable) {
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        if(radioGroup==rg){
            show(i,"rg");
        }
        else{
            show(i,"rt");
        }
        //Log.v("test", String.valueOf(i)); // Verbose (最詳細) 日誌
        //show(i);
    }
    public void show(int i,String g) {

        str = txt.getText().toString() + "張";
        RadioButton selcted = (RadioButton) findViewById(i);
        if(g=="rg"){
            gender= (String) selcted.getText();
        }
        else if(g=="rt"){
            ticket= (String) selcted.getText();

        }

        String[] ticketype = ticket.split("\n");
        sum=Integer.parseInt(ticketype[0])*Integer.parseInt(ticketype[1]);
        output.setText(gender+"\n"+ticketype[0]+str+"\n"+"金額"+sum );
    }
}