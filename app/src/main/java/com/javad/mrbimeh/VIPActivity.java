package com.javad.mrbimeh;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.javad.mrbimeh.fragments.PageFragment;

public class VIPActivity extends AppCompatActivity {
    public static View header_steps;
    public static TextView text1;
    public static TextView text2;
    public static TextView text3;
    FrameLayout container;
    FragmentTransaction fragmentTransaction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_vip);
        this.container = (FrameLayout) findViewById(R.id.container);
        header_steps = findViewById(R.id.header_steps);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        header_steps.setVisibility(View.GONE);
        this.fragmentTransaction = getSupportFragmentManager().beginTransaction();
        this.fragmentTransaction.replace(R.id.container, new PageFragment());
        this.fragmentTransaction.commit();
    }
}
