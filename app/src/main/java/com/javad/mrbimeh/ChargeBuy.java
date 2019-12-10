package com.javad.mrbimeh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.aigestudio.wheelpicker.WheelPicker;
import com.aigestudio.wheelpicker.WheelPicker.OnItemSelectedListener;
import java.util.ArrayList;

public class ChargeBuy extends AppCompatActivity {
    private WheelPicker wheelPicker;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_charge_buy);
        this.wheelPicker = (WheelPicker) findViewById(R.id.wheel_picker);
        final ArrayList<String> list = new ArrayList();
        list.add("1000 تومانی");
        list.add("2000 تومانی");
        list.add("5000 تومانی");
        list.add("10000 تومانی");
        list.add("20000 تومانی");
        this.wheelPicker.setCurved(false);
        this.wheelPicker.setItemTextColor(-16777216);
        this.wheelPicker.setCyclic(false);
        this.wheelPicker.setItemSpace(150);
        this.wheelPicker.setTypeface(MainActivity.typeface);
        if (MainActivity.height >= 800 && 1000 >= MainActivity.height && MainActivity.width >= 500 && 700 >= MainActivity.width) {
            this.wheelPicker.setItemTextSize(30);
        } else if (MainActivity.height >= 500 && 800 >= MainActivity.height && MainActivity.width >= 400 && 500 >= MainActivity.width) {
            this.wheelPicker.setItemTextSize(50);
        } else if (500 < MainActivity.height || 400 < MainActivity.width) {
            this.wheelPicker.setItemTextSize(50);
            Toast.makeText(this, "تبلت بزرگ", 0).show();
        } else {
            this.wheelPicker.setItemTextSize(20);
        }
        this.wheelPicker.setData(list);
        this.wheelPicker.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                switch (position) {
                    case 0:
                        Toast.makeText(ChargeBuy.this, (CharSequence) list.get(position), 0).show();
                        return;
                    case 1:
                        Toast.makeText(ChargeBuy.this, (CharSequence) list.get(position), 0).show();
                        return;
                    case 2:
                        Toast.makeText(ChargeBuy.this, (CharSequence) list.get(position), 0).show();
                        return;
                    case 3:
                        Toast.makeText(ChargeBuy.this, (CharSequence) list.get(position), 0).show();
                        return;
                    case 4:
                        Toast.makeText(ChargeBuy.this, (CharSequence) list.get(position), 0).show();
                        return;
                    default:
                        return;
                }
            }
        });
    }
}
