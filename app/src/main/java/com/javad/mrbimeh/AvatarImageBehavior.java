package com.javad.mrbimeh;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import de.hdodenhof.circleimageview.CircleImageView;

public class AvatarImageBehavior extends Behavior<CircleImageView> {
    private static final int EXTRA_FINAL_AVATAR_PADDING = 80;
    private static final float MIN_AVATAR_PERCENTAGE_SIZE = 0.3f;
    private static final String TAG = "behavior";
    private float mAvatarMaxSize;
    private float mChangeBehaviorPoint;
    private Context mContext;
    private float mCustomFinalHeight;
    private float mCustomFinalYPosition;
    private float mCustomStartHeight;
    private float mCustomStartToolbarPosition;
    private float mCustomStartXPosition;
    private float mFinalLeftAvatarPadding;
    private int mFinalXPosition;
    private int mFinalYPosition;
    private int mStartHeight;
    private float mStartPosition;
    private float mStartToolbarPosition;
    private int mStartXPosition;
    private int mStartYPosition;

    public AvatarImageBehavior(Context context, AttributeSet attrs) {
        this.mContext = context;
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AvatarImageBehavior);
            this.mCustomFinalYPosition = a.getDimension(1, 0.0f);
            this.mCustomStartXPosition = a.getDimension(4, 0.0f);
            this.mCustomStartToolbarPosition = a.getDimension(3, 0.0f);
            this.mCustomStartHeight = a.getDimension(2, 0.0f);
            this.mCustomFinalHeight = a.getDimension(0, 0.0f);
            a.recycle();
        }
        init();
        this.mFinalLeftAvatarPadding = context.getResources().getDimension(R.dimen.spacing_normal);
    }

    private void init() {
        bindDimensions();
    }

    private void bindDimensions() {
        this.mAvatarMaxSize = this.mContext.getResources().getDimension(R.dimen.image_width);
    }

    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {
        maybeInitProperties(child, dependency);
        float expandedPercentageFactor = dependency.getY() / ((float) ((int) this.mStartToolbarPosition));
        float heightFactor;
        if (expandedPercentageFactor < this.mChangeBehaviorPoint) {
            heightFactor = (this.mChangeBehaviorPoint - expandedPercentageFactor) / this.mChangeBehaviorPoint;
            float distanceYToSubtract = (((float) (this.mStartYPosition - this.mFinalYPosition)) * (1.0f - expandedPercentageFactor)) + ((float) (child.getHeight() / 2));
            child.setX(((float) this.mStartXPosition) - ((((float) (this.mStartXPosition - this.mFinalXPosition)) * heightFactor) + ((float) (child.getHeight() / 2))));
            child.setY(((float) this.mStartYPosition) - distanceYToSubtract);
            float heightToSubtract = (((float) this.mStartHeight) - this.mCustomFinalHeight) * heightFactor;
            LayoutParams lp = (LayoutParams) child.getLayoutParams();
            lp.width = (int) (((float) this.mStartHeight) - heightToSubtract);
            lp.height = (int) (((float) this.mStartHeight) - heightToSubtract);
            child.setLayoutParams(lp);
        } else {
            heightFactor = (((float) (this.mStartYPosition - this.mFinalYPosition)) * (1.0f - expandedPercentageFactor)) + ((float) (this.mStartHeight / 2));
            child.setX((float) (this.mStartXPosition - (child.getWidth() / 2)));
            child.setY(((float) this.mStartYPosition) - heightFactor);
            LayoutParams lp2 = (LayoutParams) child.getLayoutParams();
            lp2.width = this.mStartHeight;
            lp2.height = this.mStartHeight;
            child.setLayoutParams(lp2);
        }
        return true;
    }

    private void maybeInitProperties(CircleImageView child, View dependency) {
        if (this.mStartYPosition == 0) {
            this.mStartYPosition = (int) dependency.getY();
        }
        if (this.mFinalYPosition == 0) {
            this.mFinalYPosition = dependency.getHeight() / 2;
        }
        if (this.mStartHeight == 0) {
            this.mStartHeight = child.getHeight();
        }
        if (this.mStartXPosition == 0) {
            this.mStartXPosition = (int) (child.getX() + ((float) (child.getWidth() / 2)));
        }
        if (this.mFinalXPosition == 0) {
            this.mFinalXPosition = this.mContext.getResources().getDimensionPixelOffset(R.dimen.abc_action_bar_content_inset_material) + (((int) this.mCustomFinalHeight) / 2);
        }
        if (this.mStartToolbarPosition == 0.0f) {
            this.mStartToolbarPosition = dependency.getY();
        }
        if (this.mChangeBehaviorPoint == 0.0f) {
            this.mChangeBehaviorPoint = (((float) child.getHeight()) - this.mCustomFinalHeight) / (((float) (this.mStartYPosition - this.mFinalYPosition)) * 2.0f);
        }
    }

    public int getStatusBarHeight() {
        int resourceId = this.mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return this.mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }
}
