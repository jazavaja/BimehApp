package com.javad.mrbimeh.MyTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class NumTextView extends AppCompatTextView {
    public static Typeface tf;

    public NumTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public NumTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        tf = Typeface.createFromAsset(getContext().getAssets(), "font/kodak.ttf");
        setTypeface(tf, 0);
    }
}
