package com.yfz.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.fullScreen(this);
    }

    public void GoSplashActivityOne(View view){
        startActivity(new Intent(this,SplashOneActivity.class));
    }
}