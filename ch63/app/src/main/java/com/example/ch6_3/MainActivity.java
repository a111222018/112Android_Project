//a111222018
package com.example.ch6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaDrm;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    private Button submit;
    private  String str = "0";
    private  String gender="";
    private String[] ticketype={"",""};
    private  String ticket="";
    private  int sum=0;

    private int n=0;
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
        txt = (EditText) findViewById(R.id.editTextNumber);
        txt.setText("");
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


        RadioButton selcted = (RadioButton) findViewById(i);
        if(g=="rg"){
            gender= (String) selcted.getText();

        }
        else if(g=="rt"){
            ticket= (String) selcted.getText();
            ticketype = ticket.split("\n");
            if(txt.getText().toString().equals("")){
                n=0;

            }
            //Log.v("test1",txt.getText().toString());
            else {
                n = Integer.parseInt(txt.getText().toString());
            }
            sum=n*Integer.parseInt(ticketype[1]);
        }
        else{
            if(!txt.getText().toString().equals("") & gender!="" & ticketype[1]!=""){
                //Log.v("test",txt.getText().toString());

                str = txt.getText().toString() + "張";
                sum=Integer.parseInt(txt.getText().toString())*Integer.parseInt(ticketype[1]);


            }
            else{
                if(txt.getText().toString().equals("")){
                    str = "0" + "張";
                }
                //Log.v("test1",txt.getText().toString());
                else {
                    str = txt.getText().toString() + "張";
                }
                sum=0;
            }


        }


        output.setText(gender+"\n"+ticketype[0]+str+"\n"+"金額"+sum );
    }
    public void submit(View view){
        Intent intent=new Intent(this, result.class);
        intent.putExtra("result",output.getText());
        startActivity(intent);
    }
}