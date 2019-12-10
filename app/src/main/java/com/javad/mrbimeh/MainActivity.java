package com.javad.mrbimeh;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.daasuu.ei.Ease;
import com.daasuu.ei.EasingInterpolator;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.javad.mrbimeh.helper.CircleLayout;
import com.mohamadamin.persianmaterialdatetimepicker.date.MonthView;
import com.robohorse.pagerbullet.PagerBullet;
import ir.tapsell.sdk.Tapsell;
import ir.tapsell.sdk.TapsellAd;
import ir.tapsell.sdk.TapsellAdRequestListener;
import ir.tapsell.sdk.TapsellAdRequestOptions;
import ir.tapsell.sdk.TapsellAdShowListener;
import ir.tapsell.sdk.TapsellRewardListener;
import ir.tapsell.sdk.TapsellShowOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    static DisplayMetrics displayMetrics;
    private static boolean firstPage = true;
    static int height;
    public static Typeface typeface;
    static int width;
//    BoomMenuButton boomMenuButton;
    CircleLayout circleLayout;
    ArrayList<Integer> colors;
//    ImageView cursor;
    CustomViewPager customViewPager;
    int deg;
    int deg1;
    int firstDeg = -112;
    FrameLayout first_page;
    FrameLayout total_page;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    LinearLayout ll_1;
    public DrawerLayout mDrawerLayout;
    ImageView menu;
    private NavigationView navigationView;
    CircleLayout pie;
    CircleLayout pie1;
    View rl_chart;
    int secondDeg = -115;
    LinearLayout shareYourCode;
    FrameLayout second_page;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    ImageView user_btn1;
    ImageView user_btn2;
    View view1;
    View view11;
    View view12;
    View view13;
    View view14;
    View view15;
    View view17;
    View view18;
    View view2;
    View view21;
    View view22;
    View view23;
    View view24;
    View view25;
    View view26;
    View view27;
    View view3;
    View view4;
    View view5;
    View view6;
    View view7;
    View view8;
    PagerBullet viewPagerr;

    /* renamed from: com.javad.mrbimeh.MainActivity$1 */
    class C03531 implements OnClickListener {

        public void onClick(View v) {
//            MainActivity.this.changeColorSelectedPageFirst(MainActivity.this.view1,
//                    MainActivity.this.view2, MainActivity.this.view3,
//                    MainActivity.this.view4, MainActivity.this.view5,
//                    MainActivity.this.view7, MainActivity.this.view8);
        }
    }

    /* renamed from: com.javad.mrbimeh.MainActivity$3 */
    class user1 implements OnClickListener {

        public void onClick(View v) {

                    changePage();

        }
    }
    class user2 implements OnClickListener {

        public void onClick(View v) {

                    changePage();

        }
    }

    private void changePage() {

        total_page.animate().scaleX(0).scaleY(0).setInterpolator(new EasingInterpolator(Ease.BACK_IN)).setDuration(400).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                total_page.animate().scaleX(1).scaleY(1).setInterpolator(new EasingInterpolator(Ease.BACK_OUT)).setDuration(400).start();

                if (firstPage){
                    first_page.setVisibility(View.GONE);
                    second_page.setVisibility(View.VISIBLE);
                    firstPage = false;
                }else {
                    first_page.setVisibility(View.VISIBLE);
                    second_page.setVisibility(View.GONE);
                    firstPage = true;
                }

            }
        }, 400);

    }

    /* renamed from: com.javad.mrbimeh.MainActivity$7 */
//    class C03567 implements Runnable {
//
//        public void run() {
//            for (int i = 0; i < MainActivity.this.boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++) {
//                String m = null;
//                StringBuilder stringBuilder;
//                switch (i) {
//                    case 0:
//                        stringBuilder = new StringBuilder();
//                        stringBuilder.append("شماره موبایل شما :");
//                        stringBuilder.append(Store.getMobile(MainActivity.this));
//                        m = stringBuilder.toString();
//                        break;
//                    case 1:
//                        stringBuilder = new StringBuilder();
//                        stringBuilder.append("درامد شما");
//                        stringBuilder.append(Store.get(MainActivity.this, Store.keyIncome, "0"));
//                        m = stringBuilder.toString();
//                        break;
//                    case 2:
//                        stringBuilder = new StringBuilder();
//                        stringBuilder.append("تعداد زیر مجوعه ");
//                        stringBuilder.append(Store.get(MainActivity.this, Store.keZirmajmoe, "0"));
//                        m = stringBuilder.toString();
//                        break;
//                    case 3:
//                        stringBuilder = new StringBuilder();
//                        stringBuilder.append("معرف شما ");
//                        stringBuilder.append(Store.get(MainActivity.this, Store.keyMoaref, "آقای بیمه"));
//                        m = stringBuilder.toString();
//                        break;
//                    default:
//                        break;
//                }
//                MainActivity.this.boomMenuButton.addBuilder(((Builder) new Builder().normalImageRes(R.drawable.score)).subNormalText(m));
//            }
//        }
//    }

    /* renamed from: com.javad.mrbimeh.MainActivity$4 */
    class C09434 implements OnNavigationItemSelectedListener {
        C09434() {
        }

        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.about:
                    Toast.makeText(MainActivity.this.getApplicationContext(), "آقای بیمه برای سهولت در خرید بیمه و شارز و راهی برای کسب درامد کاربران ایجاد شده است", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.contact_us:
                    Toast.makeText(MainActivity.this.getApplicationContext(), "گروه برنامه نویسی تیم تکست محمد جواد سرلک", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.money_bag:
                    MainActivity.this.goToWallet();
                    break;
                case R.id.rates:
                    break;
                case R.id.settings:
                    break;
                case R.id.share:
                    MainActivity.this.textShare();
                    break;
                case R.id.support:
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Mrbime.info", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return true;
        }
    }

    /* renamed from: com.javad.mrbimeh.MainActivity$5 */
    class C10965 implements TapsellAdRequestListener {

        /* renamed from: com.javad.mrbimeh.MainActivity$5$1 */
        class C10951 implements TapsellAdShowListener {

            /* renamed from: com.javad.mrbimeh.MainActivity$5$1$1 */
            class C10941 implements TapsellRewardListener {

                public void onAdShowFinished(TapsellAd tapsellAd, boolean b) {
                    if (tapsellAd.isRewardedAd()) {
                        MainActivity.this.putReward();
                    } else {
                        Sweet.customError(MainActivity.this, "ویدئو را کامل مشاهده نکردید..");
                    }
                }
            }

            public void onOpened(TapsellAd tapsellAd) {
                Tapsell.setRewardListener(new C10941());
            }

            public void onClosed(TapsellAd tapsellAd) {
                Sweet.customError(MainActivity.this, "شما ویدئو را بستید");
            }
        }

        public void onError(String s) {
            Sweet.customError(MainActivity.this, s);
        }

        public void onAdAvailable(TapsellAd tapsellAd) {
            tapsellAd.show(MainActivity.this, null, new C10951());
        }

        public void onNoAdAvailable() {
            Sweet.customError(MainActivity.this, "ویدیویی قابل نمایش نیست");
        }

        public void onNoNetwork() {
            Sweet.customError(MainActivity.this, "اینترنت متصل نیست");
        }

        public void onExpiring(TapsellAd tapsellAd) {
        }
    }

    private void refrence() {
        this.deg = 51;
        this.deg1 = 51;
        this.first_page = (FrameLayout) findViewById(R.id.first_page);
        this.total_page = (FrameLayout) findViewById(R.id.total_page);
        this.second_page = (FrameLayout) findViewById(R.id.second_page);
        this.ll_1 = (LinearLayout) findViewById(R.id.ll_1);
        this.pie = (CircleLayout) findViewById(R.id.pie1);
        this.pie1 = (CircleLayout) findViewById(R.id.pie2);
        this.view1 = findViewById(R.id.rlc1);
        this.view2 = findViewById(R.id.rlc2);
        this.view3 = findViewById(R.id.rlc3);
        this.view4 = findViewById(R.id.rlc4);
        this.view5 = findViewById(R.id.rlc5);
        this.view7 = findViewById(R.id.rlc7);
        this.view8 = findViewById(R.id.rlc8);
        this.txt1 = (TextView) findViewById(R.id.txt1);
        this.txt2 = (TextView) findViewById(R.id.txt2);
        this.txt3 = (TextView) findViewById(R.id.txt3);
        this.txt4 = (TextView) findViewById(R.id.txt4);
        this.txt5 = (TextView) findViewById(R.id.txt5);
        this.txt6 = (TextView) findViewById(R.id.txt6);
        this.txt7 = (TextView) findViewById(R.id.txt7);
        this.txt8 = (TextView) findViewById(R.id.txt8);
        this.img1 = (ImageView) findViewById(R.id.icon1);
        this.img2 = (ImageView) findViewById(R.id.icon2);
        this.img3 = (ImageView) findViewById(R.id.icon3);
        this.img4 = (ImageView) findViewById(R.id.icon4);
        this.img5 = (ImageView) findViewById(R.id.icon5);
        this.img6 = (ImageView) findViewById(R.id.icon6);
        this.img7 = (ImageView) findViewById(R.id.icon7);
        this.img8 = (ImageView) findViewById(R.id.icon8);
        this.view21 = findViewById(R.id.rls21);
        this.view22 = findViewById(R.id.rls22);
        this.view23 = findViewById(R.id.rls23);
        this.view24 = findViewById(R.id.rls24);
        this.view25 = findViewById(R.id.rls25);
        this.view26 = findViewById(R.id.rls26);
//        this.view27 = findViewById(R.id.rls27);
        this.view11 = findViewById(R.id.view11);
        this.view12 = findViewById(R.id.view12);
        this.view13 = findViewById(R.id.view13);
        this.view14 = findViewById(R.id.view14);
        this.view15 = findViewById(R.id.view15);
        this.view17 = findViewById(R.id.view17);
        this.view18 = findViewById(R.id.view18);
        this.shareYourCode = findViewById(R.id.shareYourCode);
        this.viewPagerr = (PagerBullet) findViewById(R.id.cus);
//        this.boomMenuButton = (BoomMenuButton) findViewById(R.id.boomMenu);
        this.circleLayout = (CircleLayout) findViewById(R.id.pie);
        displayMetrics = getResources().getDisplayMetrics();
        densty();
        typeface = Typeface.createFromAsset(getApplicationContext().getAssets(), "font/iran_sans.ttf");
//        this.cursor = (ImageView) findViewById(R.id.cursor);
        this.user_btn1 = (ImageView) findViewById(R.id.user_btn1);
        this.user_btn2 = (ImageView) findViewById(R.id.user_btn2);
        this.rl_chart = findViewById(R.id.rl_chart);
        this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.menu = (ImageView) findViewById(R.id.menu);
        this.view1.setOnClickListener(new C03531());
        this.view1.setOnClickListener(this);
        this.view2.setOnClickListener(this);
        this.view3.setOnClickListener(this);
        this.view4.setOnClickListener(this);
        this.view5.setOnClickListener(this);
        this.view7.setOnClickListener(this);
        this.view8.setOnClickListener(this);

        this.view21.setOnClickListener(this);
        this.view22.setOnClickListener(this);
        this.view23.setOnClickListener(this);
        this.view24.setOnClickListener(this);
        this.view25.setOnClickListener(this);
        this.view26.setOnClickListener(this);

        this.shareYourCode.setOnClickListener(this);
//        this.view21.setOnClickListener(this);
//        this.view22.setOnClickListener(this);
//        this.view23.setOnClickListener(this);
//        this.view24.setOnClickListener(this);
//        this.view25.setOnClickListener(this);
//        this.view26.setOnClickListener(this);
//        this.view27.setOnClickListener(this);
//        mianbor();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.drawer);
        refrence();
        navigationDrawer();
        user_btn1();
        user_btn2();
        setSlider();
        showCase();
    }

    public void textShare() {
        StringBuilder shareBody = new StringBuilder();
        shareBody.append(Store.getMobile(this));
        shareBody.append("دوست من برنامه اقای بیمه رو نصب کن که میتونی باش کسب درامد کنی! کد معرف منو بزن تا امتیاز بگیری");

        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.SUBJECT", "Subject Here");
        sharingIntent.putExtra("android.intent.extra.TEXT", shareBody.toString());
        startActivity(Intent.createChooser(sharingIntent, "انتخاب یکی از روش ها"));
    }

    private void showCase() {

        try {

            if (Store.getTapTarget(this).equals("")) {
                new TapTargetSequence((Activity) this).targets(TapTarget.forView(findViewById(R.id.ll_1),
                        "تو این بخش میتونید بیمه بخرید و کسب درآمد کنید").titleTypeface(fontForTarget()).cancelable(false),
                        TapTarget.forView(findViewById(R.id.ll_2), "میتونید شارژ بخرید").titleTypeface(fontForTarget()).cancelable(false),
                        TapTarget.forView(findViewById(R.id.ll_3),
                                "انواع آموزش های آقای بیمه رو میتونی اینجا ببینی").titleTypeface(fontForTarget()).cancelable(false),
                        TapTarget.forView(findViewById(R.id.ll_4), "میتونی با دیدن ویدیو های تبلیغاتی کسب درامد کنی").titleTypeface(fontForTarget()).cancelable(false),
                        TapTarget.forView(findViewById(R.id.ll_5), "اینجا ثبت نام برای کارمدان مجازی ماست با امکانات فوق العاده").titleTypeface(fontForTarget()).cancelable(false),
                        TapTarget.forView(findViewById(R.id.boomMenu), "خلاصه پروفایل خودتو میتونی ببینی").titleTypeface(fontForTarget()).cancelable(false),
                        TapTarget.forView(findViewById(R.id.ll_7), "با بچرخون امتیاز بگیر برای خرید شارژ").titleTypeface(fontForTarget()).cancelable(false),
                        TapTarget.forView(findViewById(R.id.ll_8),
                                "اینجا میتونی بسته اینترنتی بخری و در کنار کسب درامد کنی").textColor(R.color.mdtp_transparent_black).outerCircleColor(R.color.red).cancelable(false)).start();
                Store.save(this, "tap", "yes");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Typeface fontForTarget() {
        return Typeface.createFromAsset(getAssets(), "font/nazi.ttf");
    }

    public void setSlider() {
        new Req(this, Req.getSlider, false, false) {
            public void success(String s) throws JSONException {
                JSONArray jsonArray = new JSONArray(s);
                String[] strings = new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    strings[i] = jsonArray.getJSONObject(i).getString("pic");
                    Log.e("LINKPIC", strings[i]);
                }
                MainActivity.this.customViewPager = new CustomViewPager(MainActivity.this, strings, false);
                MainActivity.this.viewPagerr.setAdapter(MainActivity.this.customViewPager);
                MainActivity.this.customViewPager.notifyDataSetChanged();
            }

            public void Error(VolleyError error) {
                MainActivity.this.customViewPager = new CustomViewPager(MainActivity.this, null, true);
                MainActivity.this.viewPagerr.setAdapter(MainActivity.this.customViewPager);
                MainActivity.this.customViewPager.notifyDataSetChanged();
            }

            public Map<String, String> inputs() {
                return Req.stringMap();
            }
        };
    }

    public void user_btn1() {
        this.user_btn1.setOnClickListener(new user1());
    }

    public void user_btn2() {
        this.user_btn2.setOnClickListener(new user2());
    }

    private void navigationDrawer() {
        this.menu.setOnClickListener(this);
        this.navigationView.setNavigationItemSelectedListener(new C09434());
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.menu) {
            this.mDrawerLayout.openDrawer(5);
        }
//        else if (id == R.id.view2) {
//            changeColorSelectedPageFirst(this.view1, this.view2, this.view3, this.view4, this.view5, this.view7, this.view8);
//            this.cursor.animate().rotation(0.0f).setDuration(50).start();
//        } else if (id != R.id.view2) {
            switch (id) {
                case R.id.rlc3:
//                    changeColorSelectedPageFirst(this.view3, this.view2, this.view1, this.view4, this.view5, this.view7, this.view8);
//                    this.cursor.animate().rotation((float) (this.deg * 2)).setDuration(50).start();
                    goToLearn();
                    return;
                case R.id.rlc4:
//                    changeColorSelectedPageFirst(this.view4, this.view1, this.view2, this.view3, this.view5, this.view7, this.view8);
//                    this.cursor.animate().rotation((float) (this.deg * 3)).setDuration(50).start();
                    try {
                        TapsellAdRequestOptions options = new TapsellAdRequestOptions();
                        TapsellShowOptions showOptions = new TapsellShowOptions();
                        showOptions.setBackDisabled(true);
                        showOptions.setRotationMode(5);
                        options.setCacheType(2);
                        Tapsell.requestAd(this, null, options, new C10965());
                    }catch (Exception e){
                        e.printStackTrace();
                        Log.e("tapsell ads", e.getMessage().toString());
                    }
                    return;
                case R.id.rlc5:
//                    changeColorSelectedPageFirst(this.view5, this.view1, this.view2, this.view3, this.view4, this.view7, this.view8);
//                    this.cursor.animate().rotation((float) (this.deg * 4)).setDuration(50).start();
                    goToEmploy();
                    return;
                case R.id.rlc7:
//                            changeColorSelectedPageFirst(this.view7, this.view1, this.view2, this.view3, this.view4, this.view5, this.view8);
//                            this.cursor.animate().rotation((float) (this.deg * 6)).setDuration(50).start();
                    goToTurn();
                    return;
                case R.id.rlc8:
//                            changeColorSelectedPageFirst(this.view8, this.view1, this.view3, this.view4, this.view5, this.view7, this.view2);
//                            this.cursor.animate().rotation((float) (this.deg * 7)).setDuration(50).start();
                    Sweet.nextVersionShow(this);

                    return;
                case R.id.rlc1:
//                            changeColorSelectedPageSecond(this.view21, this.view22, this.view23, this.view24, this.view25, this.view26, this.view27);
//                            this.cursor.animate().rotation(0.0f).setDuration(50).start();
                    goToInsurance();
                    return;
                case R.id.rlc2:
//                            changeColorSelectedPageSecond(this.view22, this.view21, this.view23, this.view24, this.view25, this.view26, this.view27);
//                            this.cursor.animate().rotation((float) this.deg1).setDuration(50).start();
                    Sweet.nextVersionShow(this);

                    return;
                case R.id.shareYourCode:

                    shareYourSelf();

                    return;
                case R.id.rls21:
//                            changeColorSelectedPageSecond(this.view24, this.view22, this.view23, this.view21, this.view25, this.view26, this.view27);
//                            this.cursor.animate().rotation((float) (this.deg1 * 3)).setDuration(50).start();
                    goToMessage();
                    return;
                case R.id.rls22:
//                            changeColorSelectedPageSecond(this.view24, this.view22, this.view23, this.view21, this.view25, this.view26, this.view27);
//                            this.cursor.animate().rotation((float) (this.deg1 * 3)).setDuration(50).start();
                    Sweet.nextVersionShow(this);
                    return;
                case R.id.rls23:
//                            changeColorSelectedPageSecond(this.view25, this.view22, this.view23, this.view24, this.view21, this.view26, this.view27);
//                            this.cursor.animate().rotation((float) (this.deg1 * 4)).setDuration(50).start();
                    goToProfile();
                    return;
                case R.id.rls24:
//                            changeColorSelectedPageSecond(this.view26, this.view22, this.view23, this.view24, this.view25, this.view21, this.view27);
//                            this.cursor.animate().rotation((float) (this.deg1 * 5)).setDuration(50).start();
                    Sweet.nextVersionShow(this);
                    return;
                case R.id.rls25:
//                            changeColorSelectedPageSecond(this.view27, this.view22, this.view23, this.view24, this.view25, this.view26, this.view21);
//                            this.cursor.animate().rotation((float) (this.deg1 * 6)).setDuration(50).start();
                    goToWallet();
                    return;
                case R.id.rls26:
//                            changeColorSelectedPageSecond(this.view27, this.view22, this.view23, this.view24, this.view25, this.view26, this.view21);
//                            this.cursor.animate().rotation((float) (this.deg1 * 6)).setDuration(50).start();
                    Sweet.nextVersionShow(this);
                    return;
                default:
                    return;
//                    }

        }
    }

    public static void densty() {
        height = Math.round(((float) displayMetrics.heightPixels) / displayMetrics.density);
        width = Math.round(((float) displayMetrics.widthPixels) / displayMetrics.density);
        Log.e(MonthView.VIEW_PARAMS_HEIGHT, String.valueOf(height));
        Log.e("width", String.valueOf(width));
    }

//    private void changeColorSelectedPageFirst(View rls1, View rls2, View rls3, View rls4, View rls5, View rls7, View rls8) {
//        rls1.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircularSelected));
//        rls2.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        rls3.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        rls4.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        rls5.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        rls7.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        rls8.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        this.view11.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircularSelected));
//        this.view12.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        this.view13.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        this.view14.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        this.view15.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        this.view17.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        this.view18.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//    }
//
//    private void changeColorSelectedPageSecond(View view1, View view2, View view3, View view4, View view5, View view6, View view7) {
//        view1.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircularSelected));
//        view2.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        view3.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        view4.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        view5.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        view6.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//        view7.setBackgroundColor(getResources().getColor(R.color.colorBackgroundCircular));
//    }

    public void ll_1(View view) {
//        this.cursor.animate().rotation(0.0f).setDuration(10).start();
        goToInsurance();
        if (this.pie.getAngleOffset() != ((float) this.firstDeg)) {
            this.pie.setAngleOffset((float) this.firstDeg);
        }
    }

    public void ll_2(View view) {
//        this.cursor.animate().rotation((float) this.deg).setDuration(10).start();
        Sweet.nextVersionShow(this);
        if (this.pie.getAngleOffset() != ((float) (this.firstDeg + (this.deg * 1)))) {
            this.pie.setAngleOffset((float) (this.firstDeg + (this.deg * 1)));
        }
    }

    public void ll_3(View view) {
//        changeColorSelectedPageFirst(this.view3, this.view1, this.view2, this.view4, this.view5, this.view7, this.view8);
//        this.cursor.animate().rotation((float) (this.deg * 2)).setDuration(10).start();
        if (this.pie.getAngleOffset() != ((float) (this.firstDeg + (this.deg * 2)))) {
            this.pie.setAngleOffset((float) (this.firstDeg + (this.deg * 2)));
        }
        goToLearn();
    }

    public void ll_4(View view) {
//        changeColorSelectedPageFirst(this.view4, this.view1, this.view2, this.view3, this.view5, this.view7, this.view8);
//        this.cursor.animate().rotation((float) (this.deg * 3)).setDuration(10).start();
        if (this.pie.getAngleOffset() != ((float) (this.firstDeg + (this.deg * 3)))) {
            this.pie.setAngleOffset((float) (this.firstDeg + (this.deg * 3)));
        }
        TapsellAdRequestOptions options = new TapsellAdRequestOptions();
        TapsellShowOptions showOptions = new TapsellShowOptions();
        showOptions.setBackDisabled(true);
        showOptions.setRotationMode(5);
        options.setCacheType(2);
        Tapsell.requestAd(this, null, options, new C10965());
    }

    private void putReward() {
        new Req(this, Req.putReward, true, true) {
            public void success(String s) throws JSONException {
                JSONObject jsonObject = new JSONObject(s);
                if (jsonObject.getString("code").equals("1")) {
                    Sweet.customSuccess(MainActivity.this, jsonObject.getString("Result"));
                } else {
                    Sweet.customError(MainActivity.this, jsonObject.getString("Result"));
                }
            }

            public void Error(VolleyError error) {
            }

            public Map<String, String> inputs() {
                Map<String, String> stringMap = new HashMap();
                stringMap.put("mobile", Store.getMobile(MainActivity.this));
                return stringMap;
            }
        };
    }

    public void ll_5(View view) {
//        changeColorSelectedPageFirst(this.view5, this.view1, this.view2, this.view3, this.view4, this.view7, this.view8);
//        this.cursor.animate().rotation((float) (this.deg * 4)).setDuration(10).start();
        goToEmploy();
        if (this.pie.getAngleOffset() != ((float) (this.firstDeg + (this.deg * 4)))) {
            this.pie.setAngleOffset((float) (this.firstDeg + (this.deg * 4)));
        }
    }

    public void ll_6(View view) {
//        changeColorSelectedPageFirst(this.view1, this.view2, this.view3, this.view4, this.view5, this.view7, this.view8);
//        this.cursor.animate().rotation((float) (this.deg * 5)).setDuration(10).start();
        if (this.pie.getAngleOffset() != ((float) (this.firstDeg + (this.deg * 5)))) {
            this.pie.setAngleOffset((float) (this.firstDeg + (this.deg * 5)));
        }
    }

//    public void mianbor() {
//        new Thread(new C03567()).start();
//    }

    public void ll_7(View view) {
//        changeColorSelectedPageFirst(this.view7, this.view1, this.view2, this.view3, this.view4, this.view5, this.view8);
//        this.cursor.animate().rotation((float) (this.deg * 5)).setDuration(10).start();
        goToTurn();
        if (this.pie.getAngleOffset() != ((float) (this.firstDeg + (this.deg * 5)))) {
            this.pie.setAngleOffset((float) (this.firstDeg + (this.deg * 5)));
        }
    }

    public void ll_8(View view) {
//        changeColorSelectedPageFirst(this.view1, this.view2, this.view3, this.view4, this.view5, this.view7, this.view8);
//        this.cursor.animate().rotation((float) (this.deg * 6)).setDuration(10).start();
        Sweet.nextVersionShow(this);
        if (this.pie.getAngleOffset() != ((float) (this.firstDeg + (deg * 6)))) {
            this.pie.setAngleOffset((float) (this.firstDeg + (deg * 6)));
        }
    }

    public void ll_21(View view) {
//        changeColorSelectedPageSecond(this.view21, this.view22, this.view23, this.view24, this.view25, this.view26, this.view27);
//        this.cursor.animate().rotation((float) (this.deg1 * 0)).setDuration(10).start();
        if (this.pie1.getAngleOffset() != ((float) this.secondDeg)) {
            this.pie1.setAngleOffset((float) this.secondDeg);
        }
    }

    public void ll_22(View view) {
//        changeColorSelectedPageSecond(this.view22, this.view21, this.view23, this.view24, this.view25, this.view26, this.view27);
//        this.cursor.animate().rotation((float) (this.deg1 * 1)).setDuration(50).start();
        goToMessage();
        if (this.pie1.getAngleOffset() != ((float) (this.secondDeg + this.deg1))) {
            this.pie1.setAngleOffset((float) (this.secondDeg + this.deg1));
        }
    }

    public void ll_23(View view) {
//        changeColorSelectedPageSecond(this.view23, this.view22, this.view21, this.view24, this.view25, this.view26, this.view27);
//        this.cursor.animate().rotation((float) (this.deg1 * 2)).setDuration(10).start();
        if (this.pie1.getAngleOffset() != ((float) (this.secondDeg + (this.deg1 * 2)))) {
            this.pie1.setAngleOffset((float) (this.secondDeg + (this.deg1 * 2)));
        }
    }

    public void ll_24(View view) {
//        changeColorSelectedPageSecond(this.view24, this.view22, this.view23, this.view21, this.view25, this.view26, this.view27);
//        this.cursor.animate().rotation((float) (this.deg1 * 3)).setDuration(50).start();
        goToProfile();
        if (this.pie1.getAngleOffset() != ((float) (this.secondDeg + (this.deg1 * 3)))) {
            this.pie1.setAngleOffset((float) (this.secondDeg + (this.deg1 * 3)));
        }
    }

    public void ll_25(View view) {
//        changeColorSelectedPageSecond(this.view25, this.view22, this.view23, this.view24, this.view21, this.view26, this.view27);
//        this.cursor.animate().rotation((float) (this.deg1 * 4)).setDuration(10).start();
        if (this.pie1.getAngleOffset() != ((float) (this.secondDeg + (this.deg1 * 4)))) {
            this.pie1.setAngleOffset((float) (this.secondDeg + (this.deg1 * 4)));
        }
    }

    public void ll_26(View view) {
//        changeColorSelectedPageSecond(this.view26, this.view22, this.view23, this.view24, this.view25, this.view21, this.view27);
//        this.cursor.animate().rotation((float) (this.deg1 * 5)).setDuration(10).start();
        goToWallet();
        if (this.pie1.getAngleOffset() != ((float) (this.secondDeg + (this.deg1 * 5)))) {
            this.pie1.setAngleOffset((float) (this.secondDeg + (this.deg1 * 5)));
        }
    }

    public void ll_27(View view) {
//        changeColorSelectedPageSecond(this.view27, this.view22, this.view23, this.view24, this.view25, this.view26, this.view21);
//        this.cursor.animate().rotation((float) (this.deg1 * 6)).setDuration(10).start();
        if (this.pie1.getAngleOffset() != ((float) (this.secondDeg + (this.deg1 * 6)))) {
            this.pie1.setAngleOffset((float) (this.secondDeg + (this.deg1 * 6)));
        }
    }

    public void goToCharge() {
        startActivity(new Intent(this, ChargeBuy.class));
    }

    public void goToInternet() {
        startActivity(new Intent(this, InternetBuy.class));
    }

    public void goToEmploy() {
        startActivity(new Intent(this, VIPActivity.class));
    }

    public void goToTurn() {
        startActivity(new Intent(this, TurnIt.class));
    }

    public void goToMessage() {
        startActivity(new Intent(this, Message.class));
    }

    public void goToWallet() {
        startActivity(new Intent(this, MoneyBag.class));
    }

    public void goToLearn() {
        startActivity(new Intent(this, Learn.class));
    }

    public void goToProfile() {
        startActivity(new Intent(this, Profile.class));
    }

    public void goToInsurance() {
        startActivity(new Intent(this, Insurance.class));
    }

    public void clickEstelam(View view) {
    }

    private void shareYourSelf(){

        String shareBody = "این کد معرف منه:  222525252236";
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "ارسال کد معرف برای آشنایان"));
    }

    @Override
    public void onBackPressed() {

        if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)){

            mDrawerLayout.closeDrawer(Gravity.RIGHT);

        }else {

            super.onBackPressed();

        }
    }
}
