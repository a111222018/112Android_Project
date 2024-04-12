package com.example.lifecircle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private  final  String TAG="LifeCircleTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG,"Oncreat");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart () {
        Log.v(TAG,"OnSrart");
        super.onStart();
    }

    @Override
    protected void onRestart () {
        Log.v(TAG,"onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume () {
        Log.v(TAG,"onResume");
        super.onResume();
    }

    @Override
    protected void onStop () {
        Log.v(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy () {
        Log.v(TAG,"onDestroy");
        super.onDestroy();
    }

}