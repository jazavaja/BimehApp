package com.javad.mrbimeh;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.javad.mrbimeh.MyTextView.NumTextView;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {
    NumTextView address;
    NumTextView age;
    NumTextView birth;
    NumTextView eshterak;
    NumTextView melicode;
    String mob;
    NumTextView namee;
    NumTextView personeli;
    CircleImageView pic;
    NumTextView refer;
    SwipeRefreshLayout refreshLayout;
    NumTextView tamas;
    ImageView back;

    /* renamed from: com.javad.mrbimeh.Profile$1 */
    class C09461 implements OnRefreshListener {
        C09461() {
        }

        public void onRefresh() {
            Log.e("MOBILE", Profile.this.mob);
            Profile.this.load();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_profile);
        find();
        load();
        this.refreshLayout.setOnRefreshListener(new C09461());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }

    public void load() {
        new Req(this, Req.getProfile(this.mob), true, true) {
            @SuppressLint({"SetTextI18n"})
            public void success(String s) throws JSONException {
                JSONObject jsonObject = new JSONArray(s).getJSONObject(0);
                NumTextView numTextView = Profile.this.namee;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("نام و نام خانوادگی :");
                stringBuilder.append(jsonObject.getString("name"));
                stringBuilder.append(jsonObject.getString("family"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.refer;
                stringBuilder = new StringBuilder();
                stringBuilder.append("معرف :");
                stringBuilder.append(jsonObject.getString("refer"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.personeli;
                stringBuilder = new StringBuilder();
                stringBuilder.append("شماره پرسنلی");
                stringBuilder.append(jsonObject.getString("personeli"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.melicode;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(jsonObject.getString("melicode"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.birth;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(jsonObject.getString("birth"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.age;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(jsonObject.getString("age"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.address;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(jsonObject.getString("address"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.tamas;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(jsonObject.getString("mobile"));
                numTextView.setText(stringBuilder.toString());
                numTextView = Profile.this.eshterak;
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(jsonObject.getString("expired_at"));
                numTextView.setText(stringBuilder.toString());
                Picasso.with(Profile.this).load(Uri.parse(jsonObject.getString("picture"))).into(Profile.this.pic);
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                Map<String, String> hashMap = new HashMap();
                hashMap.put("mob", Profile.this.mob);
                return hashMap;
            }
        };
    }

    void find() {
        this.mob = Store.getMobile(this);
        Log.e("j", this.mob);
        this.pic = (CircleImageView) findViewById(R.id.picProfile);
        this.refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        this.namee = (NumTextView) findViewById(R.id.namePR);
        this.refer = (NumTextView) findViewById(R.id.refer);
        this.personeli = (NumTextView) findViewById(R.id.personeli);
        this.melicode = (NumTextView) findViewById(R.id.melicode);
        this.birth = (NumTextView) findViewById(R.id.birth);
        this.age = (NumTextView) findViewById(R.id.age);
        this.address = (NumTextView) findViewById(R.id.address);
        this.tamas = (NumTextView) findViewById(R.id.tamas);
        this.eshterak = (NumTextView) findViewById(R.id.eshterak);
        this.back = (ImageView) findViewById(R.id.back);
    }
}
