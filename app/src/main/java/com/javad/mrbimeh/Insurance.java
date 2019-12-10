package com.javad.mrbimeh;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.javad.mrbimeh.MyTextView.NumTextView;
import com.javad.mrbimeh.insuranceFragment.FireFragment;
import com.javad.mrbimeh.insuranceFragment.LifeFragment;
import com.javad.mrbimeh.insuranceFragment.SecondPersonFragment;
import com.javad.mrbimeh.insuranceFragment.TravelFragment;
import com.javad.mrbimeh.insuranceFragment.ViewPagerTabAdapter;
import java.util.Objects;

public class Insurance extends AppCompatActivity {
    TabLayout tabLayout;
    String[] text;
    ViewPager viewPager;
    ViewPagerTabAdapter viewPagerTabAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_insurance);

        this.tabLayout = (TabLayout) findViewById(R.id.tb);
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        this.text = new String[]{"بیمه آتش سوزی", "بیمه مسافرتی", "بیمه شخص ثالث", "بیمه عمر"};
        this.viewPagerTabAdapter = new ViewPagerTabAdapter(getSupportFragmentManager());
        int i = 0;
        this.viewPagerTabAdapter.addFragments(new FireFragment(), this.text[0]);
        this.viewPagerTabAdapter.addFragments(new TravelFragment(), this.text[1]);
        this.viewPagerTabAdapter.addFragments(new SecondPersonFragment(), this.text[2]);
        this.viewPagerTabAdapter.addFragments(new LifeFragment(), this.text[3]);
        this.viewPager.setAdapter(this.viewPagerTabAdapter);
        this.tabLayout.setupWithViewPager(this.viewPager);
        TextView linearLayoutOne = (NumTextView) ((LayoutInflater) Objects.requireNonNull(getSystemService("layout_inflater"))).
                inflate(R.layout.cus_tab_layout, null, false).findViewById(R.id.tabTitle);
        linearLayoutOne.setText(this.text[0]);
        while (true) {
            int i2 = i;
            if (i2 < this.tabLayout.getTabCount()) {
                linearLayoutOne.setText(this.text[i2]);
                this.tabLayout.getTabAt(i2).setCustomView(linearLayoutOne);
                i = i2 + 1;
            } else {
                this.viewPagerTabAdapter.notifyDataSetChanged();
                return;
            }
        }
    }
}
