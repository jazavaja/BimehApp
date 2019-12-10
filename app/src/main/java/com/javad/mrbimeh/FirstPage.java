package com.javad.mrbimeh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FirstPage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_first_page);
    }

    public void btn_enter(View view) {
        startActivity(new Intent(this, SignUp.class));
    }
}
