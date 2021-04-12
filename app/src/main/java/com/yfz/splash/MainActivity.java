package com.yfz.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 *  作者：游丰泽
 *  简介：基础的导航页
 *  图片涞源：iconfont.cn-littlefish-水果家族
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Util.fullScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoSplashActivityZero(View view){
        startActivity(new Intent(this, SplashZeroActivity.class));
    }
    public void GoSplashActivityOne(View view){
        startActivity(new Intent(this, SplashOneActivity.class));
    }
    public void GoSplashActivityTwo(View view){
        startActivity(new Intent(this, SplashTwoActivity.class));
    }
    public void GoSplashActivityThree(View view){
        startActivity(new Intent(this, SplashThreeActivity.class));
    }



}