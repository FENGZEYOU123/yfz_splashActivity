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
 * setDotInfor设置圆点信息,页数，长宽，
 */
public class DotLayout extends LinearLayout {
    private Context mContext;
    private Paint mPaintDotSelected;
    private Paint mPaintDotUnSelected;
    private float mDotCornersRadius=10f;
    private RectF mRectF;
    private int mPageNumber=0;
    private int mDotWidth=0;
    private int mDotHeight =0;
    private float mDotArcRate=0;
    private float mDotMargin=0;


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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
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
    }
    //设置圆点信息-数量-高-宽
    public void setDotInformation(int pageNumber, int dotHeight, int dotWidth, float dotMargin,float mDotArcRate){
        mPageNumber = pageNumber; //数量
        mDotHeight  = dotHeight; //高
        mDotWidth   = dotWidth; //宽
        mDotMargin  = dotMargin; //间距
        this.getLayoutParams().height= (int)(mDotHeight);
        this.getLayoutParams().width = (int)(mDotWidth * pageNumber + mDotMargin * (pageNumber-1));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getWidth(),getHeight(), mPaintDotSelected);

//        if(mPageNumber>0 && mMaxWidth>0 && mMaxHeight>0) { //必须传入数量,方块长宽,才开始绘制
//           int i=0;
//           while(i<mPageNumber){
//               mRectF.left=i*(mMaxWidth/mPageNumber);
//               mRectF.top=0;
//               mRectF.right=mRectF.left+mDotRadius;
//               mRectF.bottom=getHeight();
//               canvas.drawRoundRect(mRectF, mDotCornersRadius, mDotCornersRadius, mPaintDotSelected);
//               i++;
//           }
//        }
    }

}

