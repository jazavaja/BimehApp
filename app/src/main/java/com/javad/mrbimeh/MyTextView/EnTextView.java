package com.javad.mrbimeh.MyTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class EnTextView extends TextView {
    public EnTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EnTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EnTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "font/Gabriola.ttf"), 0);
    }
}
