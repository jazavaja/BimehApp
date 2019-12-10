package com.javad.mrbimeh.insuranceFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.javad.mrbimeh.Model.Country;
import com.javad.mrbimeh.Model.TimeTravel;
import com.javad.mrbimeh.MyTextView.NumTextView;
import com.javad.mrbimeh.R;

import java.util.ArrayList;

public class CustomSpinerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Country> countries;
    private LayoutInflater inflter;
    private boolean isTimetravel;
    private ArrayList<TimeTravel> travel;

    CustomSpinerAdapter(Context applicationContext, ArrayList<TimeTravel> travels, boolean timeTravel) {
        this.context = applicationContext;
        this.travel = travels;
        this.isTimetravel = timeTravel;
        this.inflter = LayoutInflater.from(applicationContext);
    }

    CustomSpinerAdapter(Context applicationContext, ArrayList<Country> countries) {
        this.context = applicationContext;
        this.countries = countries;
        this.isTimetravel = false;
        this.inflter = LayoutInflater.from(applicationContext);
    }

    public int getCount() {
        if (this.isTimetravel) {
            return this.travel.size();
        }
        return this.countries.size();
    }

    public Object getItem(int i) {
        if (this.isTimetravel) {
            return this.travel.get(i);
        }
        return this.countries.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = this.inflter.inflate(R.layout.custom_spinner, null);
        NumTextView id = (NumTextView) view.findViewById(R.id.id);
        NumTextView names = (NumTextView) view.findViewById(R.id.name);
        if (this.isTimetravel) {
            id.setText(((TimeTravel) this.travel.get(i)).getId());
            names.setText(((TimeTravel) this.travel.get(i)).getName());
        } else {
            id.setText(((Country) this.countries.get(i)).getId());
            names.setText(((Country) this.countries.get(i)).getName());
        }
        return view;
    }
}
