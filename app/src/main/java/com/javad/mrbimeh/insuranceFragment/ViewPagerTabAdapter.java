package com.javad.mrbimeh.insuranceFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

public class ViewPagerTabAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList();
    ArrayList<String> tabTitles = new ArrayList();

    public void addFragments(Fragment fragments, String titles) {
        this.fragments.add(fragments);
        this.tabTitles.add(titles);
    }

    public ViewPagerTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        return (Fragment) this.fragments.get(position);
    }

    public int getCount() {
        return this.fragments.size();
    }

    public CharSequence getPageTitle(int position) {
        return (CharSequence) this.tabTitles.get(position);
    }
}
