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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Util.fullScreen(this);
    }

    public void GoSplashActivityBase(View view){
        startActivity(new Intent(this, SplashBaseActivity.class));
    }

    public void GoSplashActivityOne(View view){
        startActivity(new Intent(this, SplashOneActivity.class));
    }
}