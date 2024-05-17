package com.example.alertdialog;

import static java.lang.Integer.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnabout);
        btn.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("關於本書")
                    .setMessage("Android程式設計與應用\n作者: 陳俊榮\n出版社: 旗標\n出版日期: 2021/07/01\n定價: 380元\nISBN: 9789863126809\n")
                    .setCancelable(true)
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        Button bunexit = findViewById(R.id.btnexit);
        bunexit.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("確認視窗")
                    .setMessage("確定要結束應用程式嗎?")
                    .setCancelable(true)
                    .setPositiveButton("yes", (dialog, which) -> finish())
                    .setNegativeButton("No", (dialog, which) -> Toast.makeText(MainActivity.this, "取消結束應用程式", Toast.LENGTH_LONG).show())
                    .show();
        });

        Button btncolor = findViewById(R.id.btncolor);
        btncolor.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("選擇顏色")
                    .setCancelable(true)
                    .setItems(new String[]{"紅色", "綠色", "藍色","粉色","螢光綠"}, (dialog, which) -> {
                        switch (which) {
                            case 0:
                               btncolor.setBackgroundColor(0xFFFF0000);
                                break;
                            case 1:
                                btncolor.setBackgroundColor(0xFF00FF00);
                                break;
                            case 2:
                                btncolor.setBackgroundColor(0xFF0000FF);
                                break;
                            case 3:
                                btncolor.setBackgroundColor(0xFFFF00FF);
                                break;
                            case 4:
                                btncolor.setBackgroundColor(0xFF00FF00);
                                break;
                        }
                    })
                    .setNegativeButton("取消", (dialog, which) -> Toast.makeText(MainActivity.this, "取消變更顏色", Toast.LENGTH_LONG).show())
                    .show();
        });

        Button btnselect = findViewById(R.id.btnselect);
        ArrayList<String> selected = new ArrayList<String>();
        String[] type=new String[]{"samsun", "oppo", "nokia", "apple"};
        TextView output= findViewById(R.id.txtoutput);
        output.setText("");
        btnselect.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("選擇項目")
                    .setCancelable(true)
                    .setMultiChoiceItems(new String[]{"samsun", "oppo", "nokia", "apple"}, new boolean[]{false, false, false, false, false}, (dialog, which, isChecked) -> {
                        if (isChecked) {
                            selected.add(type[valueOf(which)]);
                            //Toast.makeText(MainActivity.this, "選擇" + which, Toast.LENGTH_LONG).show();
                        } else {
                            selected.remove(String.valueOf(which));
                            //Toast.makeText(MainActivity.this, "取消選擇" + which, Toast.LENGTH_LONG).show();
                        }
                    })
                    //同時放兩個動作
                    .setPositiveButton("確定", (dialog, which) -> {
                        output.setText("");
                        output.setText(selected.toString());
                        selected.removeAll(selected);
                    })
                    .setNegativeButton("取消", (dialog, which) -> Toast.makeText(MainActivity.this, "取消選擇", Toast.LENGTH_LONG).show())
                    .show();
        });


    }
}