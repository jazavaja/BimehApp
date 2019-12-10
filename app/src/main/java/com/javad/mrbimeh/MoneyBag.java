package com.javad.mrbimeh;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import com.android.volley.VolleyError;
import com.javad.mrbimeh.MyTextView.NumTextView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MoneyBag extends AppCompatActivity {
    AppCompatSpinner bankList;
    TextInputEditText cartNumber;
    TextInputEditText hesab;
    TextInputEditText nameAfamily;
    TextInputEditText price;
    TextInputEditText shaba;
    NumTextView taiid;
    ImageView back;

    /* renamed from: com.javad.mrbimeh.MoneyBag$1 */
    class C03571 implements OnClickListener {
        C03571() {
        }

        public void onClick(View view) {
            new Req(MoneyBag.this, Req.balance, true, true) {
                public void success(String s) throws JSONException {
                    JSONObject jsonObject = new JSONObject(s);
                    if (jsonObject.getString("Code").equals("1")) {
                        Sweet.customSuccess(MoneyBag.this, jsonObject.getString("Result"));
                    } else {
                        Sweet.customError(MoneyBag.this, jsonObject.getString("Result"));
                    }
                }

                public void Error(VolleyError error) {
                }

                public Map<String, String> inputs() {
                    Map<String, String> input = new HashMap();
                    input.put("name", String.valueOf(MoneyBag.this.nameAfamily));
                    input.put("hesab", String.valueOf(MoneyBag.this.hesab));
                    input.put("cardNumber", String.valueOf(MoneyBag.this.cartNumber));
                    input.put("price", String.valueOf(MoneyBag.this.price));
                    input.put("bank", String.valueOf(MoneyBag.this.bankList.getSelectedItem().toString()));
                    input.put("shaba", String.valueOf(MoneyBag.this.shaba));
                    return input;
                }
            };
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_money_bag);
        find();
        setBankList();
        taiidFun();
    }

    void find() {
        this.nameAfamily = (TextInputEditText) findViewById(R.id.nameMB);
        this.hesab = (TextInputEditText) findViewById(R.id.hesab);
        this.cartNumber = (TextInputEditText) findViewById(R.id.cartNumber);
        this.price = (TextInputEditText) findViewById(R.id.price);
        this.shaba = (TextInputEditText) findViewById(R.id.shaba);
        this.bankList = (AppCompatSpinner) findViewById(R.id.bankList);
        this.taiid = (NumTextView) findViewById(R.id.taiid);
        this.back = (ImageView) findViewById(R.id.back);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }

    void taiidFun() {
        this.taiid.setOnClickListener(new C03571());
    }

    void setBankList() {
//        SpinnerAdapter adapter = new ArrayAdapter(this, 17367048, getResources().getStringArray(R.array.bank));
//        adapter.setDropDownViewResource(17367049);
//        this.bankList.setAdapter(adapter);
    }
}
