package com.javad.mrbimeh;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment;
import com.github.mikephil.charting.components.Legend.LegendOrientation;
import com.github.mikephil.charting.components.Legend.LegendVerticalAlignment;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.YAxisLabelPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

public class Steady extends AppCompatActivity {
    String[] labels = new String[]{"کیف پول", "تعداد فروش", "تعداد مراجعه", "اشتراک گذاری", "بنر تبلیغاتی"};
    protected BarChart mChart1;
    protected BarChart mChart2;
    protected BarChart mChart3;
    BarDataSet barDataSet;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_steady);
        this.mChart1 = (BarChart) findViewById(R.id.bar_chart1);
        this.mChart2 = (BarChart) findViewById(R.id.bar_chart2);
        this.mChart3 = (BarChart) findViewById(R.id.bar_chart3);
        barChart(this.mChart1);
        barChart(this.mChart2);
        barChart(this.mChart3);
    }

    private void barChart(BarChart mChart1) {
        int i;
        YAxis yAxisRight;
        Context context = this;
        BarChart barChart = mChart1;
        ArrayList<BarEntry> entries = new ArrayList();
        entries.add(new BarEntry(0.0f, 45.0f));
        entries.add(new BarEntry(1.0f, 25.0f));
        entries.add(new BarEntry(2.0f, 65.0f));
        entries.add(new BarEntry(3.0f, 55.0f));
        entries.add(new BarEntry(4.0f, 45.0f));
        barChart.setData(new BarData(new BarDataSet(entries, "")));
        barChart.animateY(1000);
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(false);
        barChart.setMaxVisibleValueCount(60);
        mChart1.getDescription().setEnabled(false);
        barChart.setPinchZoom(true);
        barChart.setDrawGridBackground(false);
        XAxis xAxis = mChart1.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1.0f);
        xAxis.setLabelCount(7);
        YAxis leftAxis = mChart1.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15.0f);
        leftAxis.setAxisMinimum(0.0f);
        YAxis rightAxis = mChart1.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setSpaceTop(15.0f);
        rightAxis.setAxisMinimum(0.0f);
        Legend l = mChart1.getLegend();
        l.setVerticalAlignment(LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(LegendHorizontalAlignment.LEFT);
        l.setOrientation(LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(10.0f);
        l.setForm(LegendForm.SQUARE);
        mChart1.getXAxis().setTypeface(MainActivity.typeface);
        mChart1.getAxisLeft().setTypeface(MainActivity.typeface);
        if (MainActivity.height >= 800 && 1000 >= MainActivity.height && MainActivity.width >= 500 && 700 >= MainActivity.width) {
            l.setTextSize(20.0f);
            l.setFormSize(20.0f);
            mChart1.getXAxis().setTextSize(15.0f);
            mChart1.getAxisLeft().setTextSize(15.0f);
        } else if (800 < MainActivity.height || 500 < MainActivity.width) {
            l.setFormSize(29.0f);
            l.setTextSize(20.0f);
            mChart1.getXAxis().setTextSize(20.0f);
            mChart1.getAxisLeft().setTextSize(17.0f);
            i = 0;
            Toast.makeText(context, "تبلت بزرگ", Toast.LENGTH_SHORT).show();
            barDataSet.setColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimaryDark), getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorPrimaryDark), getResources().getColor(R.color.darkGrayCircle));
            barChart.setTouchEnabled(true);
            yAxisRight = mChart1.getAxisRight();
            yAxisRight.setEnabled(false);
            mChart1.getXAxis().setValueFormatter(new LableFormater(labels));
            yAxisRight.isInverted();
            mChart1.notifyDataSetChanged();
            ((BarData) mChart1.getData()).notifyDataChanged();
            mChart1.invalidate();
        } else {
            l.setFormSize(10.0f);
            l.setTextSize(11.0f);
            mChart1.getXAxis().setTextSize(10.0f);
            mChart1.getAxisLeft().setTextSize(10.0f);
        }
        i = 0;
        barDataSet.setColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimaryDark), getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorPrimaryDark), getResources().getColor(R.color.darkGrayCircle));
        barChart.setTouchEnabled(true);
        yAxisRight = mChart1.getAxisRight();
        yAxisRight.setEnabled(false);
        mChart1.getXAxis().setValueFormatter(new LableFormater(labels));
        yAxisRight.isInverted();
        mChart1.notifyDataSetChanged();
        ((BarData) mChart1.getData()).notifyDataChanged();
        mChart1.invalidate();
    }
}
