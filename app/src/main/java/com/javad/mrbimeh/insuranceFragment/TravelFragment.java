package com.javad.mrbimeh.insuranceFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.javad.mrbimeh.Model.Country;
import com.javad.mrbimeh.Model.TimeTravel;
import com.javad.mrbimeh.R;
import com.javad.mrbimeh.Req;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog.OnDateSetListener;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TravelFragment extends Fragment implements OnDateSetListener {
    View btn_buy;
    View btn_estelam;
    AppCompatSpinner costYoro;
    AppCompatSpinner countrySpinner;
    LinearLayout ll_buy_travel;
    LinearLayout ll_estelam_travel;
    AppCompatSpinner travelTime;
    TextView txt_birth_travel;

    /* renamed from: com.javad.mrbimeh.insuranceFragment.TravelFragment$1 */
    class C03911 implements OnClickListener {
        C03911() {
        }

        public void onClick(View v) {
            TravelFragment.this.ll_estelam_travel.setVisibility(View.VISIBLE);
            TravelFragment.this.ll_buy_travel.setVisibility(View.GONE);
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.TravelFragment$2 */
    class C03922 implements OnClickListener {
        C03922() {
        }

        public void onClick(View v) {
            final Country country = (Country) TravelFragment.this.countrySpinner.getSelectedItem();
            final TimeTravel timeTravel = (TimeTravel) TravelFragment.this.travelTime.getSelectedItem();
            final String str = (String) TravelFragment.this.costYoro.getSelectedItem();
            new Req(TravelFragment.this.getContext(), Req.bmiTripInquiry, true, true) {
                public void success(String s) throws JSONException {
                    new JSONObject(s).getString("");
                    TravelFragment.this.ll_buy_travel.setVisibility(View.VISIBLE);
                    TravelFragment.this.ll_estelam_travel.setVisibility(View.GONE);
                }

                public void Error(VolleyError error) {
                }

                public Map<String, String> inputs() {
                    Map<String, String> map = new HashMap();
                    map.put("country", country.getId());
                    map.put("timeTravel", timeTravel.getId());
                    map.put("cost", str);
                    map.put("birth", TravelFragment.this.txt_birth_travel.getText().toString());
                    return map;
                }
            };
        }
    }

    /* renamed from: com.javad.mrbimeh.insuranceFragment.TravelFragment$3 */
    class C03933 implements OnClickListener {
        C03933() {
        }

        public void onClick(View v) {
            PersianCalendar persianCalendar = new PersianCalendar();
            DatePickerDialog.newInstance(TravelFragment.this, persianCalendar.getPersianYear(), persianCalendar.getPersianMonth(), persianCalendar.getPersianDay()).show(TravelFragment.this.getActivity().getFragmentManager(), "Datepickerdialog");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_travel, container, false);
        this.btn_buy = view.findViewById(R.id.btn_buy_travel);
        this.btn_estelam = view.findViewById(R.id.btn_est_travel);
        this.txt_birth_travel = (TextView) view.findViewById(R.id.txt_birth_travel);
        this.ll_estelam_travel = (LinearLayout) view.findViewById(R.id.ll_estelam_travel);
        this.ll_buy_travel = (LinearLayout) view.findViewById(R.id.ll_buy_travel);
        this.countrySpinner = (AppCompatSpinner) view.findViewById(R.id.country);
        this.travelTime = (AppCompatSpinner) view.findViewById(R.id.timeTravel);
        this.costYoro = (AppCompatSpinner) view.findViewById(R.id.costyoro);
        this.countrySpinner.setAdapter(new CustomSpinerAdapter(getContext(), country()));
        this.travelTime.setAdapter(new CustomSpinerAdapter(getContext(), travelTime(), true));
        this.costYoro.setAdapter(new ArrayAdapter(getContext(), 17367048, costYoro()));
        this.btn_buy.setOnClickListener(new C03911());
        this.btn_estelam.setOnClickListener(new C03922());
        this.txt_birth_travel.setOnClickListener(new C03933());
        return view;
    }

    @SuppressLint({"SetTextI18n"})
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        int month = monthOfYear + 1;
        int day = dayOfMonth;
        TextView textView;
        StringBuilder stringBuilder;
        if (month < 1 || month > 9) {
            if (day < 1 || day > 9) {
                textView = this.txt_birth_travel;
                stringBuilder = new StringBuilder();
                stringBuilder.append(year);
                stringBuilder.append("/");
                stringBuilder.append(monthOfYear + 1);
                stringBuilder.append("/");
                stringBuilder.append(dayOfMonth);
                textView.setText(stringBuilder.toString());
                return;
            }
            textView = this.txt_birth_travel;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/0");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        } else if (day < 1 || day > 9) {
            textView = this.txt_birth_travel;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/0");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        } else {
            textView = this.txt_birth_travel;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/0");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/0");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        }
    }

    public ArrayList<Country> country() {
        ArrayList<Country> countries = null;
        String json = null;
        JSONObject is = null;
        try {
            InputStream is2 = getActivity().getAssets().open("country.json");
            byte[] buffer = new byte[is2.available()];
            is2.read(buffer);
            is2.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonArray = new JSONArray(new JSONObject(json).getString("data"));
            countries = new ArrayList();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                Country country = new Country();
                country.setId(o.getString("id"));
                country.setName(o.getString("name"));
                countries.add(country);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return countries;
    }

    public ArrayList<TimeTravel> travelTime() {
        String json = null;
        ArrayList<TimeTravel> countries = null;
        InputStream is = null;
        try {
            is = getActivity().getAssets().open("timetravel.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonArray = new JSONArray(new JSONObject(json).getString("data"));
            countries = new ArrayList();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                TimeTravel country = new TimeTravel();
                country.setId(o.getString("id"));
                country.setName(o.getString("name"));
                countries.add(country);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return countries;
    }

    public String[] costYoro() {
        return new String[]{"10000", "15000", "30000", "50000", "60000"};
    }
}
