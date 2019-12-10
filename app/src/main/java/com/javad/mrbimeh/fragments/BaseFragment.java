package com.javad.mrbimeh.fragments;

import android.support.v4.app.Fragment;
import android.view.animation.Animation;
import com.labo.kaji.fragmentanimations.MoveAnimation;

public abstract class BaseFragment extends Fragment {
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return MoveAnimation.create(3, enter, 100);
    }
}
