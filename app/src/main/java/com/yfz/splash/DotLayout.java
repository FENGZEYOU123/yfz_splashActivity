package com.yfz.splash;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/**
 * 作者：游丰泽
 * 简介：自定义绘制原点指示器，用于翻页
 */
public class DotLayout extends LinearLayout {
    private Context mContext;
    private Paint mPaintDotSelected;
    private Paint mPaintDotUnSelected;
    private float mDotCornersRadius=10f;
    private RectF mRectF;
    private int mPageNumber=0;


    public DotLayout(Context context) {
        super(context);
        initial(context);
    }
    public DotLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initial(context);
    }
    public DotLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initial(context);
    }
    //初始化
    private void initial(Context context){
        this.mContext=context;
        this.mRectF=new RectF();
        initial_paint_dot_selected();
        initial_paint_dot_unSelected();
        this.setBackgroundColor(Color.TRANSPARENT);

    }
    //初始化-画笔-圆点-被选中的
    private void initial_paint_dot_selected(){
        this.mPaintDotSelected=new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mPaintDotSelected.setStyle(Paint.Style.FILL);
        this.mPaintDotSelected.setColor(Color.BLACK);
    }
    //初始化-画笔-圆点-未被选中的
    private void initial_paint_dot_unSelected(){
        this.mPaintDotUnSelected=new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mPaintDotUnSelected.setStyle(Paint.Style.STROKE);
        this.mPaintDotUnSelected.setColor(Color.GRAY);
        this.mPaintDotUnSelected.setStrokeWidth(2f);
    }
    //刷新绘制
    public void refreshUI(){
        this.invalidate();
    }
    //传入页面数量
    public void setPageNumber(int pageNumber){
        this.mPageNumber=pageNumber;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mPageNumber>0) { //必须传入数量才绘制
            mRectF.left=0;
            mRectF.top=0;
            mRectF.right=getWidth();
            mRectF.bottom=getHeight();
            canvas.drawRoundRect(mRectF, mDotCornersRadius, mDotCornersRadius, mPaintDotSelected);
        }
    }

}

