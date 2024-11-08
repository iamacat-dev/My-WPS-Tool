package com.iamacat.mywps;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // এখানে true বা false রিটার্ন করলে swipe কাজ করবে না
        return false; // Swipe বন্ধ
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // টাচ ইভেন্ট কাজ করবে না
        return false; // Swipe বন্ধ
    }
}