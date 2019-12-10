package com.javad.mrbimeh.fragments;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import java.lang.reflect.Field;

public class ViewPagerCustomDuration extends ViewPager {
    private ScrollerCustomDuration mScroller = null;

    public ViewPagerCustomDuration(Context context) {
        super(context);
        postInitViewPager();
    }

    public ViewPagerCustomDuration(Context context, AttributeSet attrs) {
        super(context, attrs);
        postInitViewPager();
    }

    private void postInitViewPager() {
        Field scroller = null;
        try {
            scroller = ViewPager.class.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);
            try {
                this.mScroller = new ScrollerCustomDuration(getContext(), (Interpolator) interpolator.get(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            try {
                scroller.set(this, this.mScroller);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
    }

    public void setScrollDurationFactor(double scrollDurationFactor) {
        this.mScroller.setScrollDurationFactor(scrollDurationFactor);
    }
}
