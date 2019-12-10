package com.javad.mrbimeh.insuranceFragment;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.android.volley.VolleyError;
import com.javad.mrbimeh.Model.Country;
import com.javad.mrbimeh.Model.InsuranceModel;
import com.javad.mrbimeh.MyTextView.CustomEditText;
import com.javad.mrbimeh.R;
import com.javad.mrbimeh.Req;
import com.javad.mrbimeh.Store;
import com.javad.mrbimeh.Sweet;
import com.javad.mrbimeh.fragments.MessageAdapter;
import com.javad.mrbimeh.inter.item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FireFragment extends Fragment {
    CustomEditText address;
    EditText arzeshAsasie;
    EditText arzeshSakht;
    View btn_buy_fire;
    View btn_estelam_fire;
    LinearLayout buy_fire;
    AppCompatSpinner city;
    CustomEditText codmeli;
    CustomEditText codposti;
    CustomEditText email;
    LinearLayout estelam_fire;
    CardView main;
    EditText metr;
    CustomEditText mobile;
    InsuranceModel model;
    CustomEditText nameFamily;
    SwitchCompat neshest;
    AppCompatSpinner ostan;
    RecyclerView recyclerView;
    CustomEditText tel;
    WebView webPayment;

    /* renamed from: com.javad.mrbimeh.insuranceFragment.FireFragment$1 */
    class C03791 implements OnClickListener {
        C03791() {
        }

        public void onClick(View v) {
            FireFragment.this.setEstelam_fire();
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.FireFragment$2 */
    class C03802 implements OnItemSelectedListener {
        C03802() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Country country = (Country) FireFragment.this.ostan.getSelectedItem();
            if (!country.getId().equals("")) {
                FireFragment.this.getCity(country);
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.FireFragment$3 */
    class C03813 implements OnClickListener {
        C03813() {
        }

        public void onClick(View v) {
            if (FireFragment.this.isNull(FireFragment.this.nameFamily) && FireFragment.this.isNull(FireFragment.this.codmeli) && FireFragment.this.isNull(FireFragment.this.mobile) && FireFragment.this.isNull(FireFragment.this.tel) && FireFragment.this.isNull(FireFragment.this.codposti) && FireFragment.this.isNull(FireFragment.this.address) && FireFragment.this.isNull(FireFragment.this.email) && !FireFragment.this.ostan.getSelectedItem().equals("") && !FireFragment.this.city.getSelectedItem().equals("")) {
                FireFragment.this.setBuy_fire();
            } else {
                Sweet.customError(FireFragment.this.getContext(), "همه موارد رو پر کنید");
            }
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.FireFragment$7 */
    class C03827 extends WebViewClient {
        C03827() {
        }

        public void onPageFinished(WebView view, String url) {
            if (url.contains("success.php")) {
                FireFragment.this.getActivity().finish();
                Sweet.sucessFulOpr(FireFragment.this.getContext());
                FireFragment.this.main.setVisibility(View.VISIBLE);
                FireFragment.this.webPayment.setVisibility(View.GONE);
                FireFragment.this.buy_fire.setVisibility(View.GONE);
                FireFragment.this.estelam_fire.setVisibility(View.VISIBLE);
            }
            if (url.contains("fail.php")) {
                FireFragment.this.getActivity().finish();
                Sweet.errorOpr(FireFragment.this.getContext());
            }
        }

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fire, container, false);
        this.main = (CardView) view.findViewById(R.id.main);
        this.model = new InsuranceModel();
        this.webPayment = (WebView) view.findViewById(R.id.payment);
        this.btn_buy_fire = view.findViewById(R.id.btn_buy_fire);
        this.btn_estelam_fire = view.findViewById(R.id.btn_estelam_fire);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.priceListRecycle);
        this.nameFamily = (CustomEditText) view.findViewById(R.id.nameFamily);
        this.codmeli = (CustomEditText) view.findViewById(R.id.codemeli);
        this.mobile = (CustomEditText) view.findViewById(R.id.mobile);
        this.tel = (CustomEditText) view.findViewById(R.id.telephone);
        this.codposti = (CustomEditText) view.findViewById(R.id.posticode);
        this.address = (CustomEditText) view.findViewById(R.id.address);
        this.email = (CustomEditText) view.findViewById(R.id.email);
        this.ostan = (AppCompatSpinner) view.findViewById(R.id.ostan);
        this.city = (AppCompatSpinner) view.findViewById(R.id.city);
        this.metr = (EditText) view.findViewById(R.id.metraj);
        this.arzeshSakht = (EditText) view.findViewById(R.id.arzeshSakht);
        this.arzeshAsasie = (EditText) view.findViewById(R.id.arzeshAsasie);
        this.neshest = (SwitchCompat) view.findViewById(R.id.neshest);
        this.estelam_fire = (LinearLayout) view.findViewById(R.id.estelam_fire);
        this.buy_fire = (LinearLayout) view.findViewById(R.id.buy_fire);
        getProvice();
        this.btn_estelam_fire.setOnClickListener(new C03791());
        this.ostan.setOnItemSelectedListener(new C03802());
        this.btn_buy_fire.setOnClickListener(new C03813());
        return view;
    }

    public void priceLISTVIEW(final ArrayList<String> name, final ArrayList<String> price) {
        this.estelam_fire.setVisibility(View.GONE);
        this.buy_fire.setVisibility(View.GONE);
        int i = 0;
        this.recyclerView.setVisibility(View.VISIBLE);
        this.recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        MessageAdapter adapter = new MessageAdapter(name, price, new item() {
            public void setOnItemClick(int position) {
                FireFragment.this.model.setName((String) name.get(position));
                FireFragment.this.model.setPrice((String) price.get(position));
                FireFragment.this.estelam_fire.setVisibility(View.GONE);
                FireFragment.this.recyclerView.setVisibility(View.GONE);
                FireFragment.this.buy_fire.setVisibility(View.VISIBLE);
            }
        });
        while (i < name.size()) {
            Log.e("SWQE", (String) name.get(i));
            Log.e("SWQE", (String) price.get(i));
            i++;
        }
        adapter.notifyDataSetChanged();
        this.recyclerView.setAdapter(adapter);
    }

    public void getProvice() {
        new Req(getContext(), Req.proviceURL, true, false) {
            public void success(String s) throws JSONException {
                JSONArray array = new JSONArray(new JSONObject(s).getString("data"));
                ArrayList<Country> list = new ArrayList();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    Country country = new Country();
                    country.setId(object.getString("id"));
                    country.setName(object.getString("name"));
                    list.add(country);
                }
                SpinnerAdapter customSpinerAdapter = new CustomSpinerAdapter(FireFragment.this.getContext(), list);
                FireFragment.this.ostan.setAdapter(customSpinerAdapter);
//                customSpinerAdapter.notifyDataSetChanged();
                Country country2 = (Country) FireFragment.this.ostan.getSelectedItem();
                if (!country2.getId().equals("")) {
                    FireFragment.this.getCity(country2);
                }
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                return null;
            }
        };
    }

    public void getCity(Country country) {
        new Req(getContext(), Req.ciyURL(country.getId()), true, false) {
            public void success(String s) throws JSONException {
                JSONArray array = new JSONArray(new JSONObject(s).getString("data"));
                ArrayList<Country> list = new ArrayList();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    Country country = new Country();
                    country.setId(object.getString("id"));
                    country.setName(object.getString("name"));
                    list.add(country);
                }
                SpinnerAdapter customSpinerAdapter = new CustomSpinerAdapter(FireFragment.this.getContext(), list);
                FireFragment.this.city.setAdapter(customSpinerAdapter);
//                customSpinerAdapter.notifyDataSetChanged();
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                return null;
            }
        };
    }

    public boolean isNull(CustomEditText view) {
        if (view.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    public void setBuy_fire() {
        this.main.setVisibility(View.GONE);
        this.webPayment.setVisibility(View.VISIBLE);
        this.webPayment.setWebViewClient(new C03827());
        this.webPayment.getSettings().setDomStorageEnabled(true);
        this.webPayment.getSettings().setJavaScriptEnabled(true);
        this.webPayment.getSettings().setBuiltInZoomControls(true);
        this.webPayment.getSettings().setDisplayZoomControls(true);
        this.webPayment.loadUrl(Req.bmiFireBuy(this.model.getPrice(), this.nameFamily.getText().toString(),
                this.codmeli.getText().toString(), "1", this.mobile.getText().toString(), this.tel.getText().toString(),
                this.codposti.getText().toString(), this.address.getText().toString(), this.email.getText().toString(),
                this.model.getId(), this.ostan.getSelectedItem().toString(), this.city.getSelectedItem().toString(), Store.getMobile(getContext())));
    }

    public void setEstelam_fire() {
        new Req(getActivity(), Req.bmiFireInquiry(this.metr.getText().toString(), this.arzeshSakht.getText().toString(),
                this.arzeshAsasie.getText().toString()), true, true) {
            public void success(String s) throws JSONException {
                JSONObject jsonObject = new JSONObject(s);
                int i = 0;
                if (jsonObject.getString(NotificationCompat.CATEGORY_STATUS).equals("true")) {
                    JSONArray array = new JSONArray(jsonObject.getString("data"));
                    ArrayList<String> id = new ArrayList();
                    ArrayList<String> name = new ArrayList();
                    ArrayList<String> price = new ArrayList();
                    while (i < array.length()) {
                        JSONObject object = array.getJSONObject(i);
                        id.add(object.getString("id"));
                        name.add(object.getString("name"));
                        price.add(object.getString("price"));
                        i++;
                    }
                    FireFragment.this.priceLISTVIEW(name, price);
                    return;
                }
                Sweet.customError(FireFragment.this.getActivity(), new JSONArray(jsonObject.getString("data")).getJSONObject(0).getString("message"));
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                Map<String, String> map = new HashMap();
                map.put("building", "100");
                map.put("cost", "1000000");
                map.put("furniture", "10000000");
                return map;
            }
        };
    }
}
