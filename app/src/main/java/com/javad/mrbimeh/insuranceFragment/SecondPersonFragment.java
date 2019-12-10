package com.javad.mrbimeh.insuranceFragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
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
import com.makeramen.roundedimageview.RoundedImageView;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog.OnDateSetListener;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SecondPersonFragment extends Fragment implements OnDateSetListener {
    CustomEditText address;
    View btn_buy_car;
    View btn_est_car;
    LinearLayout buy_car;
    AppCompatSpinner city;
    CustomEditText codeposti;
    CustomEditText email;
    LinearLayout est_car;
    AppCompatSpinner karbariKhodro;
    CustomEditText mobile;
    InsuranceModel model;
    AppCompatSpinner modelCar;
    CustomEditText nation;
    int numBimeName = 7;
    int numCardMeli = 6;
    int numPoshtCar = 5;
    int numRoCar = 4;
    AppCompatSpinner ostan;
    RoundedImageView picBimeName;
    RoundedImageView picCardMeli;
    RoundedImageView picPoshtCar;
    RoundedImageView picRoCar;
    AppCompatSpinner poshseshMali;
    RecyclerView recyclerView;
    AppCompatSpinner salTakhfif;
    CustomEditText tel;
    TextView txt_ins_history;
    AppCompatSpinner typeCar;
    WebView webPayment;
    CustomEditText yearBuild;

    /* renamed from: com.javad.mrbimeh.insuranceFragment.SecondPersonFragment$2 */
    class C03842 implements OnClickListener {
        C03842() {
        }

        public void onClick(View view) {
            SecondPersonFragment.this.getfromGALLARY(SecondPersonFragment.this.numRoCar);
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.SecondPersonFragment$3 */
    class C03853 implements OnClickListener {
        C03853() {
        }

        public void onClick(View view) {
            SecondPersonFragment.this.getfromGALLARY(SecondPersonFragment.this.numPoshtCar);
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.SecondPersonFragment$4 */
    class C03864 implements OnClickListener {
        C03864() {
        }

        public void onClick(View view) {
            SecondPersonFragment.this.getfromGALLARY(SecondPersonFragment.this.numCardMeli);
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.SecondPersonFragment$5 */
    class C03875 implements OnClickListener {
        C03875() {
        }

        public void onClick(View view) {
            SecondPersonFragment.this.getfromGALLARY(SecondPersonFragment.this.numBimeName);
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.SecondPersonFragment$6 */
    class C03886 implements OnClickListener {
        C03886() {
        }

        public void onClick(View v) {
            SecondPersonFragment.this.setRequestInquiry();
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.SecondPersonFragment$7 */
    class C03897 implements OnClickListener {
        C03897() {
        }

        public void onClick(View v) {
            SecondPersonFragment.this.setRequsryBuy();
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.SecondPersonFragment$8 */
    class C03908 implements OnClickListener {
        C03908() {
        }

        public void onClick(View v) {
            PersianCalendar persianCalendar = new PersianCalendar();
            DatePickerDialog.newInstance(SecondPersonFragment.this, persianCalendar.getPersianYear(), persianCalendar.getPersianMonth(), persianCalendar.getPersianDay()).show(SecondPersonFragment.this.getActivity().getFragmentManager(), "Datepickerdialog");
        }
    }

    public void priceLISTVIEW(final ArrayList<String> name, final ArrayList<String> price) {
        this.est_car.setVisibility(View.GONE);
        int i = 0;
        this.recyclerView.setVisibility(View.GONE);
        this.buy_car.setVisibility(View.GONE);
        this.recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        MessageAdapter adapter = new MessageAdapter(name, price, new item() {
            public void setOnItemClick(int position) {
                SecondPersonFragment.this.model.setName((String) name.get(position));
                SecondPersonFragment.this.model.setPrice((String) price.get(position));
                SecondPersonFragment.this.est_car.setVisibility(View.GONE);
                SecondPersonFragment.this.recyclerView.setVisibility(View.GONE);
                SecondPersonFragment.this.buy_car.setVisibility(View.GONE);
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

    public void onClickIMG() {
        this.picRoCar.setOnClickListener(new C03842());
        this.picPoshtCar.setOnClickListener(new C03853());
        this.picCardMeli.setOnClickListener(new C03864());
        this.picBimeName.setOnClickListener(new C03875());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_person, container, false);
        this.btn_buy_car = view.findViewById(R.id.btn_buy_car);
        this.btn_est_car = view.findViewById(R.id.btn_est_car);
        this.model = new InsuranceModel();
        this.txt_ins_history = (TextView) view.findViewById(R.id.txt_bimeNamePre);
        this.buy_car = (LinearLayout) view.findViewById(R.id.buy_car);
        this.est_car = (LinearLayout) view.findViewById(R.id.estelam_car);
        this.typeCar = (AppCompatSpinner) view.findViewById(R.id.typeCar);
        this.modelCar = (AppCompatSpinner) view.findViewById(R.id.modelCar);
        this.karbariKhodro = (AppCompatSpinner) view.findViewById(R.id.karbariKhodro);
        this.salTakhfif = (AppCompatSpinner) view.findViewById(R.id.salTakhfif);
        this.poshseshMali = (AppCompatSpinner) view.findViewById(R.id.posheshMali);
        this.yearBuild = (CustomEditText) view.findViewById(R.id.yearBuild);
        this.nation = (CustomEditText) view.findViewById(R.id.codemeli);
        this.mobile = (CustomEditText) view.findViewById(R.id.mobile);
        this.tel = (CustomEditText) view.findViewById(R.id.telephone);
        this.codeposti = (CustomEditText) view.findViewById(R.id.codeposti);
        this.address = (CustomEditText) view.findViewById(R.id.address);
        this.email = (CustomEditText) view.findViewById(R.id.email);
        this.ostan = (AppCompatSpinner) view.findViewById(R.id.ostan);
        this.city = (AppCompatSpinner) view.findViewById(R.id.city);
        this.picRoCar = (RoundedImageView) view.findViewById(R.id.picRoCar);
        this.picBimeName = (RoundedImageView) view.findViewById(R.id.picBimeName);
        this.picCardMeli = (RoundedImageView) view.findViewById(R.id.picCardMeli);
        this.picPoshtCar = (RoundedImageView) view.findViewById(R.id.picPoshtCar);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        getTypeCar();
        setSalTakhfif();
        setPoshseshMali();
        setKarbariKhodro();
        getProvice();
        onClickIMG();
        this.btn_est_car.setOnClickListener(new C03886());
        this.btn_buy_car.setOnClickListener(new C03897());
        this.txt_ins_history.setOnClickListener(new C03908());
        return view;
    }

    public void getfromGALLARY(int whichImage) {
        Intent photoPickerIntent = new Intent("android.intent.action.PICK");
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, whichImage);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void setRequestInquiry() {
        new Req(getContext(), Req.bmiSalesInquiry(((Country) this.modelCar.getSelectedItem()).getId(), this.yearBuild.getText().toString(), ((Country) this.salTakhfif.getSelectedItem()).getId(), ((Country) this.poshseshMali.getSelectedItem()).getId(), this.txt_ins_history.getText().toString(), ((Country) this.karbariKhodro.getSelectedItem()).getId()), true, true) {
            public void success(String s) throws JSONException {
                JSONObject jsonObject = new JSONObject(s);
                if (jsonObject.getString(NotificationCompat.CATEGORY_STATUS).equals("true")) {
                    JSONArray array = new JSONArray(jsonObject.getString("data"));
                    ArrayList<String> id = new ArrayList();
                    ArrayList<String> name = new ArrayList();
                    ArrayList<String> price = new ArrayList();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        id.add(object.getString("id"));
                        name.add(object.getString("name"));
                        price.add(object.getString("price"));
                    }
                    SecondPersonFragment.this.priceLISTVIEW(name, price);
                }
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                return null;
            }
        };
    }

    public void getTypeCar() {
        this.typeCar.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = (Country) SecondPersonFragment.this.typeCar.getSelectedItem();
                if (!country.getId().equals("")) {
                    SecondPersonFragment.this.getModelCar(country);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        new Req(getContext(), Req.getTypeCar, true, true) {
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
                SpinnerAdapter customSpinerAdapter = new CustomSpinerAdapter(SecondPersonFragment.this.getContext(), list);
                SecondPersonFragment.this.typeCar.setAdapter(customSpinerAdapter);
//                customSpinerAdapter.notifyDataSetChanged();
                Country country2 = (Country) SecondPersonFragment.this.typeCar.getSelectedItem();
                if (!country2.getId().equals("")) {
                    SecondPersonFragment.this.getModelCar(country2);
                }
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                return Req.stringMap();
            }
        };
    }

    public void setSalTakhfif() {
        ArrayList<Country> list = new ArrayList();
        String[] text = new String[]{"فاقد بیمه نامه", "حق بیمه پایه", "یک سال تخفیف", "دو سال تخفیف", "سه سال تخفیف", "چهار سال تخفیف", "پنج سال تخفیف", "شش سال تخفیف", "هفت سال تخفیف", "هشت سال تخفیف"};
        for (int i = 0; i < text.length; i++) {
            Country country = new Country();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + 1);
            stringBuilder.append("");
            country.setId(stringBuilder.toString());
            country.setName(text[i]);
            list.add(country);
        }
        SpinnerAdapter adapter = new CustomSpinerAdapter(getContext(), list);
        this.salTakhfif.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    public void setPoshseshMali() {
        ArrayList<Country> list = new ArrayList();
        String[] text = new String[]{"77000000", "100000000"};
        for (int i = 0; i < text.length; i++) {
            Country country = new Country();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + 1);
            stringBuilder.append("");
            country.setId(stringBuilder.toString());
            country.setName(text[i]);
            list.add(country);
        }
        SpinnerAdapter adapter = new CustomSpinerAdapter(getContext(), list);
        this.poshseshMali.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    public void setKarbariKhodro() {
        ArrayList<Country> list = new ArrayList();
        String[] text = new String[]{"شخصی", "تاکسی شهری", "تاکسی بین شهری", "عمومی"};
        for (int i = 0; i < text.length; i++) {
            Country country = new Country();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i + 1);
            stringBuilder.append("");
            country.setId(stringBuilder.toString());
            country.setName(text[i]);
            list.add(country);
        }
        SpinnerAdapter adapter = new CustomSpinerAdapter(getContext(), list);
        this.karbariKhodro.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    private void getModelCar(Country country) {
        new Req(getContext(), Req.Model(country.getId()), true, true) {
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
                SpinnerAdapter customSpinerAdapter = new CustomSpinerAdapter(SecondPersonFragment.this.getContext(), list);
                SecondPersonFragment.this.modelCar.setAdapter(customSpinerAdapter);
//                customSpinerAdapter.notifyDataSetChanged();
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                return null;
            }
        };
    }

    private String imageToBase64(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, baos);
        return Base64.encodeToString(baos.toByteArray(), 0);
    }

    public void setRequsryBuy() {
        Country oostan = (Country) this.ostan.getSelectedItem();
        Country shahr = (Country) this.city.getSelectedItem();
        this.webPayment.setVisibility(View.GONE);
        this.webPayment.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                if (url.contains("success.php")) {
                    SecondPersonFragment.this.getActivity().finish();
                    Sweet.sucessFulOpr(SecondPersonFragment.this.getContext());
                }
                if (url.contains("fail.php")) {
                    SecondPersonFragment.this.getActivity().finish();
                    Sweet.errorOpr(SecondPersonFragment.this.getContext());
                }
            }

            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        this.webPayment.getSettings().setDomStorageEnabled(true);
        this.webPayment.getSettings().setJavaScriptEnabled(true);
        this.webPayment.getSettings().setBuiltInZoomControls(true);
        this.webPayment.getSettings().setDisplayZoomControls(true);
        this.webPayment.loadUrl(Req.bmiSalesBuy(this.model.getPrice(), this.nation.getText().toString(), this.mobile.getText().toString(), this.tel.getText().toString(), this.codeposti.getText().toString(), this.address.getText().toString(), this.email.getText().toString(), String.valueOf(this.mobile.getId()), oostan.getId(), imageToBase64(this.picCardMeli), imageToBase64(this.picRoCar), imageToBase64(this.picPoshtCar), imageToBase64(this.picBimeName), shahr.getId(), Store.getMobile(getContext())));
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
                SpinnerAdapter customSpinerAdapter = new CustomSpinerAdapter(SecondPersonFragment.this.getContext(), list);
                SecondPersonFragment.this.ostan.setAdapter(customSpinerAdapter);
//                customSpinerAdapter.notifyDataSetChanged();
                Country country2 = (Country) SecondPersonFragment.this.ostan.getSelectedItem();
                if (!country2.getId().equals("")) {
                    SecondPersonFragment.this.getCity(country2);
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
                SpinnerAdapter customSpinerAdapter = new CustomSpinerAdapter(SecondPersonFragment.this.getContext(), list);
                SecondPersonFragment.this.city.setAdapter(customSpinerAdapter);
//                customSpinerAdapter.notifyDataSetChanged();
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                return null;
            }
        };
    }

    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        int month = monthOfYear + 1;
        int day = dayOfMonth;
        TextView textView;
        StringBuilder stringBuilder;
        if (month < 1 || month > 9) {
            if (day < 1 || day > 9) {
                textView = this.txt_ins_history;
                stringBuilder = new StringBuilder();
                stringBuilder.append(year);
                stringBuilder.append("/");
                stringBuilder.append(monthOfYear + 1);
                stringBuilder.append("/");
                stringBuilder.append(dayOfMonth);
                textView.setText(stringBuilder.toString());
                return;
            }
            textView = this.txt_ins_history;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/0");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        } else if (day < 1 || day > 9) {
            textView = this.txt_ins_history;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/0");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        } else {
            textView = this.txt_ins_history;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/0");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/0");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        }
    }
}
