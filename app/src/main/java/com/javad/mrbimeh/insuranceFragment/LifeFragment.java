package com.javad.mrbimeh.insuranceFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.javad.mrbimeh.R;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog.OnDateSetListener;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

public class LifeFragment extends Fragment implements OnDateSetListener {
    TextView txt_birth;

    /* renamed from: com.javad.mrbimeh.insuranceFragment.LifeFragment$1 */
    class C03831 implements OnClickListener {
        C03831() {
        }

        public void onClick(View v) {
            PersianCalendar persianCalendar = new PersianCalendar();
            DatePickerDialog.newInstance(LifeFragment.this, persianCalendar.getPersianYear(), persianCalendar.getPersianMonth(), persianCalendar.getPersianDay()).show(LifeFragment.this.getActivity().getFragmentManager(), "Datepickerdialog");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life, container, false);
        this.txt_birth = (TextView) view.findViewById(R.id.txt_birth);
        this.txt_birth.setOnClickListener(new C03831());
        return view;
    }

    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        int month = monthOfYear + 1;
        int day = dayOfMonth;
        TextView textView;
        StringBuilder stringBuilder;
        if (month < 1 || month > 9) {
            if (day < 1 || day > 9) {
                textView = this.txt_birth;
                stringBuilder = new StringBuilder();
                stringBuilder.append(year);
                stringBuilder.append("/");
                stringBuilder.append(monthOfYear + 1);
                stringBuilder.append("/");
                stringBuilder.append(dayOfMonth);
                textView.setText(stringBuilder.toString());
                return;
            }
            textView = this.txt_birth;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/0");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        } else if (day < 1 || day > 9) {
            textView = this.txt_birth;
            stringBuilder = new StringBuilder();
            stringBuilder.append(year);
            stringBuilder.append("/0");
            stringBuilder.append(monthOfYear + 1);
            stringBuilder.append("/");
            stringBuilder.append(dayOfMonth);
            textView.setText(stringBuilder.toString());
        } else {
            textView = this.txt_birth;
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
