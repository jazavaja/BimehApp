//package com.javad.mrbimeh.helper;
//
//import android.app.Activity;
//import android.graphics.Color;
//import android.graphics.drawable.Drawable;
//import com.github.mikephil.charting.data.PieEntry;
//import java.util.ArrayList;
//
//public class ListHolder {
//    public static final int[] COLORFUL_COLORS0 = new int[]{Color.argb(255, 222, 185, 0), -1, -1, -1, -1, -1, -1, -1};
//    public static final int[] COLORFUL_COLORS1 = new int[]{-1, Color.argb(255, 222, 185, 0), -1, -1, -1, -1, -1, -1};
//    public static final int[] COLORFUL_COLORS2 = new int[]{-1, -1, Color.argb(255, 222, 185, 0), -1, -1, -1, -1, -1};
//    public static final int[] COLORFUL_COLORS3 = new int[]{-1, -1, -1, Color.argb(255, 222, 185, 0), -1, -1, -1, -1};
//    public static final int[] COLORFUL_COLORS4 = new int[]{-1, -1, -1, -1, Color.argb(255, 222, 185, 0), -1, -1, -1};
//    public static final int[] COLORFUL_COLORS5 = new int[]{-1, -1, -1, -1, -1, Color.argb(255, 222, 185, 0), -1, -1};
//    public static final int[] COLORFUL_COLORS6 = new int[]{-1, -1, -1, -1, -1, -1, Color.argb(255, 222, 185, 0), -1};
//    public static final int[] COLORFUL_COLORS7 = new int[]{-1, -1, -1, -1, -1, -1, -1, Color.argb(255, 222, 185, 0)};
//    Activity activity;
//    public String[] child = new String[]{"امتیاز من", "پیام ها", "سوابق خرید", "مشخصات من", "تنظیمات", "کیف پول", "آموزش خصوصی"};
//    public ArrayList<PieEntry> entries;
//    public String[] mParties = new String[]{"خرید بیمه", "خرید شارژ", "جوایز و آموزش", "تبلیغات", "استخدام شو", "مسابقه", "بچرخون", "بسته اینترنتی"};
//
//    public ListHolder(Activity activity) {
//        this.activity = activity;
//    }
//
//    public ArrayList<PieEntry> general(float count) {
//        this.entries = new ArrayList();
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[0], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[1], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[2], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[3], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[4], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[5], drawableResources(17301506), this.child));
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[6], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / count, this.mParties[7], drawableResources(17301506), null));
//        return this.entries;
//    }
//
//    public ArrayList<PieEntry> child(int count) {
//        this.entries = new ArrayList();
//        this.entries.add(new PieEntry(100.0f / ((float) count), this.child[0], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / ((float) count), this.child[1], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / ((float) count), this.child[2], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / ((float) count), this.child[3], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / ((float) count), this.child[4], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / ((float) count), this.child[5], drawableResources(17301506), null));
//        this.entries.add(new PieEntry(100.0f / ((float) count), this.child[6], drawableResources(17301506), null));
//        return this.entries;
//    }
//
//    private Drawable drawableResources(int id) {
//        return this.activity.getResources().getDrawable(id);
//    }
//}
