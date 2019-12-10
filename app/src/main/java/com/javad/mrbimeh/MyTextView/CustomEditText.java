package com.javad.mrbimeh.MyTextView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class CustomEditText extends AppCompatEditText {
    public CustomEditText(Context context) {
        super(context);
        setIranTypeFace(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setIranTypeFace(context);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setIranTypeFace(context);
    }

    private void setIranTypeFace(Context context) {
        if (!isInEditMode()) {
            setTypeface(getFont(context));
        }
    }

    public Typeface getFont(Context context) {
        return Typeface.createFromAsset(context.getAssets(), "font/kodak.ttf");
    }
}
