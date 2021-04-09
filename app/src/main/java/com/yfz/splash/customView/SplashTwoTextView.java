package com.yfz.splash.customView;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SplashTwoTextView extends androidx.appcompat.widget.AppCompatTextView {
    public SplashTwoTextView(@NonNull Context context) {
        super(context);
        initial();
    }
    public SplashTwoTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initial();
    }
    public SplashTwoTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initial();
    }
    private void initial(){
        this.getPaint().setFakeBoldText(true);
    }
}
