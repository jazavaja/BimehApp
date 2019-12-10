package com.javad.mrbimeh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Employ extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_employ);
    }

    public void vip_click(View view) {
        startActivity(new Intent(this, VIPActivity.class));
    }

    public void steady(View view) {
//        startActivity(new Intent(this, Steady.class));
    }

    public void learn(View view) {
        startActivity(new Intent(this, Learn.class));
    }
}
