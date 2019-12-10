package com.javad.mrbimeh.fragments;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.javad.mrbimeh.MyTextView.NumTextView;
import com.javad.mrbimeh.R;
import com.javad.mrbimeh.Req;
import com.javad.mrbimeh.Store;
import com.javad.mrbimeh.Sweet;
import com.javad.mrbimeh.VIPActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

public class ThirdPageFragment extends BaseFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    CircleImageView imageView;
    NumTextView karshenas;
    NumTextView melicode;
    NumTextView nameFamily;
    RelativeLayout payment;
    NumTextView personeli;
    NumTextView price;
    ScrollView scrollView;
    WebView webView;

    public int rand() {
        return new Random().nextInt(9000000 - 1000000) + 1000000;
    }

    @SuppressLint({"SetTextI18n"})
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_page, container, false);
        this.nameFamily = (NumTextView) view.findViewById(R.id.nameFamily);
        this.personeli = (NumTextView) view.findViewById(R.id.personeli);
        this.karshenas = (NumTextView) view.findViewById(R.id.karshnas);
        this.melicode = (NumTextView) view.findViewById(R.id.melicode);
        this.price = (NumTextView) view.findViewById(R.id.price);
        this.payment = (RelativeLayout) view.findViewById(R.id.btn_accept);
        this.imageView = (CircleImageView) view.findViewById(R.id.profile);
        this.scrollView = (ScrollView) view.findViewById(R.id.scrollView);
        this.webView = (WebView) view.findViewById(R.id.webview);
        Bundle bundle = getArguments();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bundle.getString("name"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("family"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("birth"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("age"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("moaref"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("address"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("homeNumber"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("melicode"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getBoolean("karShenasBazaryabi"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getBoolean("krshnsNiro"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getBoolean("krshnsPoshtibani"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getBoolean("krshnsMoarefi"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getBoolean("krshnsLearn"));
        stringBuilder.append(" ");
        stringBuilder.append(Arrays.toString(bundle.getByteArray("picture")));
        Log.e("REESSUULLTT22222222", stringBuilder.toString());
        VIPActivity.header_steps.setVisibility(View.VISIBLE);
        if (VERSION.SDK_INT >= 16) {
            VIPActivity.text1.setBackground(getResources().getDrawable(R.drawable.shape_btn_disable));
            VIPActivity.text2.setBackground(getResources().getDrawable(R.drawable.shape_btn_disable));
            VIPActivity.text3.setBackground(getResources().getDrawable(R.drawable.shape_btn));
        }
        String name = bundle.getString("name");
        String family = bundle.getString("family");
        String birth = bundle.getString("birth");
        String meli = bundle.getString("melicode");
        int plan = bundle.getInt("plan");
        NumTextView numTextView = this.nameFamily;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(name);
        stringBuilder2.append(" ");
        stringBuilder2.append(family);
        numTextView.setText(stringBuilder2.toString());
        this.personeli.setText(String.valueOf(rand()));
        this.karshenas.setText("کارشناس");
        this.melicode.setText(meli);
        this.price.setText(getFromPlan(plan));
        this.imageView.setImageBitmap(Bitmap.createScaledBitmap(byteToBitmap(bundle.getByteArray("picture")), 100, 100, false));
        setPayment();
        return view;
    }

    public String getFromPlan(int i) {
        if (i == 3) {
            return "5000";
        }
        if (i == 6) {
            return "10000";
        }
        if (i != 12) {
            return "5000";
        }
        return "20000";
    }

    public Bitmap byteToBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    private void setPayment() {
        final Bundle bundle = getArguments();
        this.payment.setOnClickListener(new OnClickListener() {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            /* renamed from: com.javad.mrbimeh.fragments.ThirdPageFragment$1$1 */
            class C03771 extends WebViewClient {
                C03771() {
                }

                public void onPageFinished(WebView view, String url) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Req.baseURL);
                    stringBuilder.append("api/fail.php");
                    if (url.equals(stringBuilder.toString())) {
                        ThirdPageFragment.this.scrollView.setVisibility(View.VISIBLE);
                        ThirdPageFragment.this.webView.setVisibility(View.GONE);
                        Sweet.errorOpr(ThirdPageFragment.this.getContext());
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(Req.baseURL);
                    stringBuilder.append("api/success.php");
                    if (url.equals(stringBuilder.toString())) {
                        ThirdPageFragment.this.scrollView.setVisibility(View.VISIBLE);
                        ThirdPageFragment.this.webView.setVisibility(View.GONE);
                        Sweet.sucessFulOpr(ThirdPageFragment.this.getContext());
                    }
                }

                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                }
            }

            public void onClick(View view) {
                ThirdPageFragment.this.scrollView.setVisibility(View.GONE);
                ThirdPageFragment.this.webView.setVisibility(View.VISIBLE);
                ThirdPageFragment.this.webView.setWebViewClient(new C03771());
                ThirdPageFragment.this.webView.getSettings().setDomStorageEnabled(true);
                ThirdPageFragment.this.webView.getSettings().setJavaScriptEnabled(true);
                ThirdPageFragment.this.webView.getSettings().setBuiltInZoomControls(true);
                ThirdPageFragment.this.webView.getSettings().setDisplayZoomControls(true);
                try {
                    ThirdPageFragment.this.webView.loadUrl(Req.payment(bundle.getString("moaref"), ThirdPageFragment.this.getFromPlan(bundle.getInt("plan")), bundle.getString("name"), bundle.getString("family"), Store.getMobile(ThirdPageFragment.this.getContext()), bundle.getString("age"), bundle.getString("birth"), bundle.getString("address"), bundle.getString("homeNumber"), bundle.getString("melicode"), bundle.getString("interest"), bundle.getString("subscribe"), bundle.getString("expert"), Base64.encodeToString(bundle.getByteArray("picture"), 8), Base64.encodeToString(bundle.getByteArray("melicard"), 8)));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
