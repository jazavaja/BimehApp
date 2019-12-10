package com.javad.mrbimeh;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.squareup.picasso.Picasso;

public class CustomViewPager extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private String[] linkPic;
    private boolean loadFromFile;

    public CustomViewPager(Context context, String[] linkPic, boolean loadFromFile) {
        this.context = context;
        this.linkPic = linkPic;
        this.loadFromFile = loadFromFile;
        this.layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public int getCount() {
        if (this.loadFromFile) {
            return 3;
        }
        return this.linkPic.length;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = this.layoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        int[] def = new int[]{R.drawable.sliderone, R.drawable.slidertwo, R.drawable.sliderthree};
        if (this.loadFromFile) {
            Picasso.with(this.context).load(def[position]).into(imageView);
        } else {
            setHttpInURl(this.linkPic);
            Picasso.with(this.context).load(this.linkPic[position]).placeholder((int) R.drawable.travel).fit().centerCrop().error((int) R.drawable.travel).into(imageView);
        }
        container.addView(itemView);
        return itemView;
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    private void setHttpInURl(String[] ll) {
        for (int i = 0; i < ll.length; i++) {
            if (!ll[i].contains("http://")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("http://");
                stringBuilder.append(ll[i]);
                ll[i] = stringBuilder.toString();
            }
        }
    }
}
