package com.javad.mrbimeh.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList();

    public void addFragments(Fragment fragments) {
        this.fragments.add(fragments);
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        return (Fragment) this.fragments.get(position);
    }

    public int getCount() {
        return this.fragments.size();
    }

    private void setHttpInURl(String[] ll) {
        for (int i = 0; i < ll.length; i++) {
            if (!ll[i].contains("http://")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(ll[i]);
                ll[i] = stringBuilder.toString();
            }
        }
    }
}
