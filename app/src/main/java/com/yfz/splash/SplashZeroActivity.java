package com.yfz.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yfz.splash.customView.RectanglePointerView;

import java.util.ArrayList;

/**
 * 作者：游丰泽
 * 简介：导航页,翻到最后一页显示按钮
 * 风格1：添加自绘制的翻页圆点指示
 */
public class SplashZeroActivity extends AppCompatActivity {

    private LayoutInflater layoutInflater;
    private ViewPager mViewPager;
    private ArrayList<View> mArrayList;
    private View mView1,mView2,mView3;
    private Button mButton;
    private RectanglePointerView mRectanglePointerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Util.fullScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_zero);
        initialView();
        initialViewPager();
    }
    private void initialView(){
        layoutInflater=getLayoutInflater().from(this);
        mViewPager=findViewById(R.id.viewPager);
        mRectanglePointerView =findViewById(R.id.rectanglePointerView);
        mView1=layoutInflater.inflate(R.layout.splash_zero_view_1,null);
        mView2=layoutInflater.inflate(R.layout.splash_zero_view_2,null);
        mView3=layoutInflater.inflate(R.layout.splash_zero_view_3,null);
        mButton=mView3.findViewById(R.id.button);
        mArrayList=new ArrayList<>(); //将想要展示的view储存到数组中
        mArrayList.add(mView1);
        mArrayList.add(mView2);
        mArrayList.add(mView3);
        mViewPager.setAdapter(new ViewPagerAdapter()); //添加视图桥梁
        mViewPager.setOnPageChangeListener(new ViewPagerChangeListener()); //监听页面状态
        mViewPager.setOffscreenPageLimit(mArrayList.size()-1);  //允许最大view缓存数量
        mViewPager.setOverScrollMode(mViewPager.OVER_SCROLL_NEVER); //去掉翻到顶页和尾页的水波纹

        mRectanglePointerView.setPointerStyle(mArrayList.size(),20,200,getResources().getDrawable(R.drawable.splash_zero_dot_selected),getResources().getDrawable(R.drawable.splash_zero_dot_unselected));

    }
    private void initialViewPager(){

    }
    //添加切换页面
    class ViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return mArrayList.size(); //返回记录的view最大数量
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.d("TAG", "instantiateItem: "+position);
            container.addView(mArrayList.get(position));
            return mArrayList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mArrayList.get(position));
        }
    }
    //监听页面状态
    class  ViewPagerChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            Log.d("TAG", "onPageScrolled: "+position+" "+positionOffset+" "+positionOffsetPixels);
            mRectanglePointerView.refreshPointer(position,positionOffset); //刷新条形指示器

        }
        @Override
        public void onPageSelected(int position) {  //翻到最后一页才显示按钮
            if(position==mArrayList.size()-1){
                mButton.setVisibility(View.VISIBLE);
            }else {
                mButton.setVisibility(View.GONE);
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    //结束按钮
    public void clickFinish(View view){
        finish();
    }

}