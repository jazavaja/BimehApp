package com.javad.mrbimeh;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/* compiled from: Steady */
class LableFormater implements IAxisValueFormatter {
    private final String[] labels;

    LableFormater(String[] labels) {
        this.labels = labels;
    }

    public String getFormattedValue(float value, AxisBase axis) {
        return this.labels[(int) value];
    }
}
