package com.yfz.splash.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * 作者：游丰泽
 * 简介：自定义绘制圆点指示器，用于翻页
 * setPointerStyle设置圆点信息,页数，长宽，（选中和未选中的不同时设置）
 */
public class DotPointerDiffSizeView extends LinearLayout {
    private Context mContext;
    private Paint mPaintDotSelected;
    private Paint mPaintDotUnSelected;
    private Rect mRect;
    private int mPageNumber=0;
    private int mSelectedWidth =0;
    private int mSelectedHeight =0;
    private int mUnSelectedWidth =0;
    private int mUnSelectedHeight =0;
    private float mDotMargin=0;
    private int mSelectedPosition=0;
    private Drawable mDotDrawableSelected;
    private Drawable mDotDrawableUnSelected;

    public DotPointerDiffSizeView(Context context) {
        super(context);
        initial(context);
    }
    public DotPointerDiffSizeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initial(context);
    }
    public DotPointerDiffSizeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initial(context);
    }
    //初始化
    private void initial(Context context){
        this.mContext=context;
        this.mRect=new Rect();
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
        this.mPaintDotUnSelected.setStrokeWidth(3f);
    }
    //刷新绘制
    public void refreshUI(){
        this.invalidate();
    }

    //设置圆点信息-数量-高-宽
    public void setPointerStyle(int pageNumber, int selectedHeight, int selectedWidth,int unSelectedHeight, int unSelectedWidth,  float dotMargin, Drawable dotDrawableSelected, Drawable dotDrawableUnSelected){
        mPageNumber = pageNumber; //数量
        mSelectedHeight = selectedHeight; //选中的高
        mSelectedWidth = selectedWidth; //选中的宽
        mUnSelectedHeight=unSelectedHeight; //未选中的高
        mUnSelectedWidth=unSelectedWidth;//未选中的宽
        mDotMargin  = dotMargin; //间距
        mDotDrawableSelected=dotDrawableSelected;
        mDotDrawableUnSelected=dotDrawableUnSelected;
        this.getLayoutParams().height= (int)(mSelectedHeight>mUnSelectedHeight?mSelectedHeight:mUnSelectedHeight);
        this.getLayoutParams().width = (int)(mSelectedWidth* pageNumber + (mDotMargin+mSelectedWidth/2) * (pageNumber-1));
    }
    //设置当前选中的页面
    public void refreshPointer(int currentPagePosition){
        mSelectedPosition=currentPagePosition;
        refreshUI();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRect.top=0;
        mRect.bottom=getHeight();
        mRect.left=0;
        mRect.right=getWidth();
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);                                                                 
        canvas.drawRect(mRect,paint);
        if(mPageNumber>0 && mSelectedWidth >0 && mSelectedHeight >0) { //必须传入数量,Dot长宽,才开始绘制
           int i=0;
           while(i<mPageNumber){
               if(mSelectedPosition==i) {
                   mRect.top=0;
                   mRect.bottom=mSelectedHeight;
                   mRect.left=(int)(i*(mSelectedWidth +mDotMargin));
                   mRect.right=mRect.left+ mSelectedWidth;
                   mDotDrawableSelected.setBounds(mRect);
                   mDotDrawableSelected.draw(canvas);
               }else {
                   mRect.top=(getHeight()-mUnSelectedHeight)/2;
                   mRect.bottom=mRect.top+mUnSelectedHeight;
                   mRect.left=(int)(i*(mUnSelectedWidth +mDotMargin));
                   mRect.right=mRect.left+ mUnSelectedWidth;
                   mDotDrawableUnSelected.setBounds(mRect);
                   mDotDrawableUnSelected.draw(canvas);
               }
               i++;
           }
        }
    }

}

