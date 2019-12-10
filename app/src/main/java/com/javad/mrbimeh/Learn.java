package com.javad.mrbimeh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.android.volley.VolleyError;
import com.javad.mrbimeh.fragments.LearnFragment;
import com.javad.mrbimeh.fragments.ViewPagerAdapter;
import com.javad.mrbimeh.fragments.ViewPagerCustomDuration;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Learn extends AppCompatActivity {
    ViewPagerCustomDuration viewPager;
    ViewPagerAdapter viewPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_learn);
        this.viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        this.viewPager = (ViewPagerCustomDuration) findViewById(R.id.viewpager);
        this.viewPager.setAdapter(this.viewPagerAdapter);
        this.viewPager.setCurrentItem(0);
        this.viewPager.setScrollDurationFactor(3.0d);

        new Req(this, Req.educational, true, true) {
            public void success(String s) throws JSONException {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String body = jsonObject.getString("body");
                    String pic = jsonObject.getString("pic");
                    String voice = jsonObject.getString("voice");
                    String video = jsonObject.getString("video");

                    LearnFragment fragment1 = new LearnFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("body", body);
                    bundle.putString("pic", pic);
                    bundle.putString("voice", voice);
                    bundle.putString("video", video);
                    fragment1.setArguments(bundle);
                    Learn.this.viewPagerAdapter.addFragments(fragment1);
                }
                viewPagerAdapter.notifyDataSetChanged();
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                return Req.stringMap();
            }
        };
    }
}
