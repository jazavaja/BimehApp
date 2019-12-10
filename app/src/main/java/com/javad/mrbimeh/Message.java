package com.javad.mrbimeh;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.javad.mrbimeh.fragments.MessageAdapter;
import com.javad.mrbimeh.inter.item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Message extends AppCompatActivity {
    MessageAdapter adapter;
    List<String> body = new ArrayList();
    RecyclerView recyclerView;
    SwipeRefreshLayout refreshLayout;
    List<String> title = new ArrayList();
    ImageView back;

    /* renamed from: com.javad.mrbimeh.Message$1 */
    class C09441 implements item {
        C09441() {
        }

        public void setOnItemClick(int position) {
        }
    }

    /* renamed from: com.javad.mrbimeh.Message$2 */
    class C09452 implements OnRefreshListener {
        C09452() {
        }

        public void onRefresh() {
            Log.e("ADAP", Message.this.recyclerView.getAdapter().toString());
            Message.this.loadServer();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_message);
        this.refreshLayout = (SwipeRefreshLayout) findViewById(R.id.ref);
        this.back = (ImageView) findViewById(R.id.back);
        this.adapter = new MessageAdapter(this.title, this.body, new C09441());
        this.refreshLayout.setOnRefreshListener(new C09452());
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setAdapter(this.adapter);
        loadServer();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }

    public void loadServer() {
        new Req(this, Req.getMassage, true, false) {
            public void success(String s) throws JSONException {
                int i = 0;
                if (Message.this.refreshLayout.isRefreshing()) {
                    Message.this.refreshLayout.setRefreshing(false);
                }
                JSONArray array = new JSONArray(s);
                while (i < array.length()) {
                    JSONObject object = array.getJSONObject(i);
                    Message.this.title.add(object.getString("title"));
                    Message.this.body.add(object.getString("body"));
                    Log.e("MESSAGE_TEST", (String) Message.this.title.get(i));
                    Log.e("MESSAGE_TEST", (String) Message.this.body.get(i));
                    i++;
                }
                Message.this.adapter.notifyDataSetChanged();
            }

            public void Error(VolleyError error) {
                if (Message.this.refreshLayout.isRefreshing()) {
                    Message.this.refreshLayout.setRefreshing(false);
                }
            }

            public Map<String, String> inputs() {
                return Req.stringMap();
            }
        };
    }
}
