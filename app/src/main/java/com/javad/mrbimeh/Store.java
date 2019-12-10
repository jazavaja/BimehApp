package com.javad.mrbimeh;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Store {
    public static String keZirmajmoe = "zirmajmoe";
    public static String keyIncome = "income";
    public static String keyMoaref = "moaref";
    public static String keyMobile = "mob";
    public static String signin = "signin";

    public static String getTapTarget(Context context) {
        return get(context, "tap", "");
    }

    public static SharedPreferences base(Context context) {
        return context.getSharedPreferences("Javad", 0);
    }

    public static void save(Context context, String key, String value) {
        Editor editor = base(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String get(Context context, String key, String defult) {
        return base(context).getString(key, defult);
    }

    public static void newVersionSet(Context context) {
        save(context, "newVersion", "yes");
    }

    public static String getMobile(Context context) {
        return get(context, "mob", "09909645710");
    }
}
