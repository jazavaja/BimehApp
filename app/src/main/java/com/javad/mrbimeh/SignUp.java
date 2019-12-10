package com.javad.mrbimeh;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.javad.mrbimeh.MyTextView.CustomEditText;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SignUp extends AppCompatActivity {
    View cv_code;
    View cv_mobiel;
    CustomEditText edtCode;
    CustomEditText edtMobile;
    String mobileTXT;
    TextView txt;
    TextView txt_code;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_sign_up);
        this.cv_mobiel = findViewById(R.id.rl_mobile);
        this.cv_code = findViewById(R.id.rl_code);
        this.txt = (TextView) findViewById(R.id.txt);
        this.txt_code = (TextView) findViewById(R.id.txt_code);
        this.edtMobile = (CustomEditText) findViewById(R.id.edtMobile);
        this.edtCode = (CustomEditText) findViewById(R.id.edtCode);
        this.txt.setText(Html.fromHtml("<font color='#ffffff'> برای شروع،</font><font color='#ffb300'> شماره موبایل </font><font color='#ffffff'>خود را وارد کنید .</font>"), BufferType.SPANNABLE);
        this.txt_code.setText(Html.fromHtml("<font color='#ffffff'>کد </font><font color='#ffb300'> پیامک </font><font color='#ffffff'>شده را وارد کنید.</font>"), BufferType.SPANNABLE);
        this.cv_code.animate().alpha(0.0f).translationY(-200.0f).setDuration(200).start();
        checkVersion();
        if (Store.get(this, Store.signin, "").equals("yes")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    public void btn_send_mobile(View view) {
        if (this.edtMobile.getText().toString().length() == 11) {
            this.mobileTXT = this.edtMobile.getText().toString();
            new Req(this, Req.sendSms(this.mobileTXT), true, true) {
                public void success(String s) throws JSONException {
                    SignUp.this.animate();
                }

                public void Error(VolleyError error) {
                    Sweet.customError(SignUp.this, "دوباره تلاش کنید ");
                }

                public Map<String, String> inputs() {
                    return Req.stringMap();
                }
            };
            return;
        }
        Sweet.errorLenghMobile(this);
    }

    public void checkVersion() {
        new Req(this, Req.version, false, false) {
            public void success(String s) throws JSONException {
                JSONObject jsonObject = new JSONObject(s);
                float version = Float.valueOf(jsonObject.getString("version")).floatValue();
                float myVersion = Float.valueOf("1.0").floatValue();
                if (version > myVersion) {
                    Store.save(SignUp.this, "newVersion", "yes");
                    Store.save(SignUp.this, "link", jsonObject.getString("link"));
                    Sweet.newVersion(SignUp.this, jsonObject.getString("link"));
                }
                if (version == myVersion) {
                    Store.save(SignUp.this, "newVersion", "");
                }
            }

            public void Error(VolleyError error) {
                if (Store.get(SignUp.this, "newVersion", "").equals("yes")) {
                    Sweet.newVersion(SignUp.this, Store.get(SignUp.this, "link", ""));
                }
            }

            public Map<String, String> inputs() {
                return Req.stringMap();
            }
        };
    }

    public void animate() {
        this.cv_mobiel.animate().rotation(30.0f).translationX(-2000.0f).setDuration(800).setListener(new Animator.AnimatorListener() {

            public void onAnimationStart(Animator animation) {
                Toast.makeText(SignUp.this, "عملیات با موفقیت انجام شد", Toast.LENGTH_SHORT).show();
            }

            public void onAnimationEnd(Animator animation) {
                SignUp.this.cv_code.setVisibility(View.VISIBLE);
                SignUp.this.cv_code.animate().alpha(1.0f).translationY(0.0f).setDuration(200).start();
            }

            public void onAnimationCancel(Animator animation) {
            }

            public void onAnimationRepeat(Animator animation) {
            }
        }).start();
    }

    public void btn_send_code(View view) {
        new Req(this, Req.verifySms(this.mobileTXT, this.edtCode.getText().toString()), true, true) {
            public void success(String s) throws JSONException {
                JSONObject jt = new JSONObject(s);
                if (jt.getString("Code").equals("1")) {
                    SignUp.this.startActivity(new Intent(SignUp.this, MainActivity.class));
                    Store.save(SignUp.this, Store.signin, "yes");
                    Store.save(SignUp.this, Store.keyMobile, SignUp.this.mobileTXT);
                }
                if (jt.getString("Code").equals("-4")) {
                    Sweet.customError(SignUp.this, jt.getString("Result"));
                } else {
                    Sweet.errorOpr(SignUp.this);
                }
            }

            public void Error(VolleyError error) {
                Sweet.errorOpr(SignUp.this);
            }

            public Map<String, String> inputs() {
                return null;
            }
        };
    }
}
