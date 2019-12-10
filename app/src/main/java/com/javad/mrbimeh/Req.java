package com.javad.mrbimeh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.util.Log;
import cn.pedant.SweetAlert.SweetAlertDialog;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public abstract class Req extends Volley {
    public static String balance;
//    public static String baseURL = "http://teamtext.ir/mrbime/";
    public static String baseURL = "https://webimeh.com/";
    public static String bmiOmrBuy;
    public static String bmiOmrInquiry;
    public static String bmiTripBuy;
    public static String bmiTripInquiry;
    public static String educational;
    public static String getMassage;
    public static String getSlider;
    public static String getTypeCar;
    public static String proviceURL;
    public static String putReward;
    public static String signUpVip;
    public static String upgrade;
    public static String version;

    public abstract void Error(VolleyError volleyError);

    public abstract Map<String, String> inputs();

    public abstract void success(String str) throws JSONException;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/third-party/province");
        proviceURL = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/brand");
//        stringBuilder.append("api/Brand.php");
        getTypeCar = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/putReward.php");
        putReward = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Omr/bmiOmr.php");
        bmiOmrInquiry = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Omr/bmiOmr.php");
        bmiOmrBuy = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Trip/bmiTrip.php");
        bmiTripInquiry = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Trip/bmiTrip.php");
        bmiTripBuy = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/upgrade.php");
        upgrade = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/getmessage.php");
        getMassage = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/signup.php");
        signUpVip = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/getslider.php");
        getSlider = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/version.php");
        version = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/edu.php");
        educational = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/balance.php");
        balance = stringBuilder.toString();
    }

    public static String Model(String country) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Model.php?brand=");
        stringBuilder.append(country);
        return stringBuilder.toString();
    }

    public static String ciyURL(String provice) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://webimeh.com/api/third-party/city?Province_id=");
//        stringBuilder.append("http://www.teamtext.ir/mrbime/api/City.php?id=");
        stringBuilder.append(provice);
        return stringBuilder.toString();
    }

    public static String sendSms(String mobile) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/sendsms.php?mobile=");
        stringBuilder.append(mobile);
        return stringBuilder.toString();
    }

    public static String verifySms(String mobile, String code) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/verifysms.php?mobile=");
        stringBuilder.append(mobile);
        stringBuilder.append("&code=");
        stringBuilder.append(code);
        return stringBuilder.toString();
    }

    public static String bmiFireInquiry(String building, String cost, String futit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Fire/bmiFire.php?mode=inquiry&building=");
        stringBuilder.append(building);
        stringBuilder.append("&cost=");
        stringBuilder.append(cost);
        stringBuilder.append("&furniture=");
        stringBuilder.append(futit);
        return stringBuilder.toString();
    }

    public static String payment(String upper, String price, String name, String family, String mobile, String age, String birth,
                                 String address, String homeNumber, String meliCode, String interest, String subscribe,
                                 String expert, String pic, String picMeli) throws UnsupportedEncodingException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Signup/purchase.php?upper=");
        stringBuilder.append(upper);
        stringBuilder.append("&price=");
        stringBuilder.append(price);
        stringBuilder.append("&name=");
        stringBuilder.append(name);
        stringBuilder.append("&mobile=");
        stringBuilder.append(mobile);
        stringBuilder.append("&family=");
        stringBuilder.append(family);
        stringBuilder.append("&age=");
        stringBuilder.append(age);
        stringBuilder.append("&birth=");
        stringBuilder.append(birth);
        stringBuilder.append("&address=");
        stringBuilder.append(address);
        stringBuilder.append("&homenumber=");
        stringBuilder.append(homeNumber);
        stringBuilder.append("&melicode=");
        stringBuilder.append(meliCode);
        stringBuilder.append("&interest=");
        stringBuilder.append(interest);
        stringBuilder.append("&subscribe=");
        stringBuilder.append(subscribe);
        stringBuilder.append("&expert=");
        stringBuilder.append(expert);
        stringBuilder.append("&picture=");
        stringBuilder.append(URLEncoder.encode(pic, "UTF-8"));
        stringBuilder.append("&picmeli=");
        stringBuilder.append(URLEncoder.encode(picMeli, "UTF-8"));
        return stringBuilder.toString();
    }

    public static String bmiFireBuy(String price, String Name, String NationCode, String Zone, String Mobile, String Tel, String PostalCode, String Address,
                                    String Email, String Id, String province, String city, String marketingId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Fire/bmiFire.php?mode=buy&price=");
        stringBuilder.append(price);
        stringBuilder.append("&Name=");
        stringBuilder.append(Name);
        stringBuilder.append("&NationCode=");
        stringBuilder.append(NationCode);
        stringBuilder.append("&Zone=");
        stringBuilder.append(Zone);
        stringBuilder.append("&Mobile=");
        stringBuilder.append(Mobile);
        stringBuilder.append("&Tel=");
        stringBuilder.append(Tel);
        stringBuilder.append("&PostalCode=");
        stringBuilder.append(PostalCode);
        stringBuilder.append("&Address=");
        stringBuilder.append(Address);
        stringBuilder.append("&Email=");
        stringBuilder.append(Email);
        stringBuilder.append("&Id=");
        stringBuilder.append(Id);
        stringBuilder.append("&Province_id=");
        stringBuilder.append(province);
        stringBuilder.append("&City_id=");
        stringBuilder.append(city);
        stringBuilder.append("&Marketing_code=mrbimeh_webimeh_insurance_");
        stringBuilder.append(marketingId);
        return stringBuilder.toString();
    }

    public static String bmiSalesInquiry(String model, String year, String salTakhfif, String posheshMali, String date_insu_later, String karbari) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Sales/bmiSales.php?mode=inquiry&model=");
        stringBuilder.append(model);
        stringBuilder.append("&year=");
        stringBuilder.append(year);
        stringBuilder.append("&Discount=");
        stringBuilder.append(salTakhfif);
        stringBuilder.append("&Coverage=");
        stringBuilder.append(posheshMali);
        stringBuilder.append("&CarUser=");
        stringBuilder.append(karbari);
        stringBuilder.append("&InsuranceDate=");
        stringBuilder.append(date_insu_later);
        return stringBuilder.toString();
    }

    public static String bmiSalesBuy(String price, String nation, String mobile, String tel, String postalCode, String address, String email, String id, String province, String NationalCodePic, String CarCardTopPic, String CarCardBottomPic, String InsurancePic, String city, String marketing_code) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/Sales/bmiSales.php?mode=buy&price=");
        stringBuilder.append(price);
        stringBuilder.append("&mobile=");
        stringBuilder.append(mobile);
        stringBuilder.append("&tel=");
        stringBuilder.append(tel);
        stringBuilder.append("&postalCode=");
        stringBuilder.append(postalCode);
        stringBuilder.append("&address");
        stringBuilder.append(address);
        stringBuilder.append("&email=");
        stringBuilder.append(email);
        stringBuilder.append("&id=");
        stringBuilder.append(id);
        stringBuilder.append("&province=");
        stringBuilder.append(province);
        stringBuilder.append("&NationalCodePic=");
        stringBuilder.append(NationalCodePic);
        stringBuilder.append("&CarCardTopPic=");
        stringBuilder.append(CarCardTopPic);
        stringBuilder.append("&CarCardBottomPic=");
        stringBuilder.append(CarCardBottomPic);
        stringBuilder.append("&InsurancePic=");
        stringBuilder.append(InsurancePic);
        stringBuilder.append("&city=");
        stringBuilder.append(city);
        stringBuilder.append("&marketing_code=");
        stringBuilder.append(marketing_code);
        stringBuilder.append("&nation=");
        stringBuilder.append(nation);
        return stringBuilder.toString();
    }

    public static String getProfile(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseURL);
        stringBuilder.append("api/getprofile.php?mobile=");
        stringBuilder.append(s);
        return stringBuilder.toString();
    }

    public Req(Context context, String url, boolean turnProgress, boolean turnError) {
        sendRequest(context, url, turnProgress, turnError);
    }

    private void sendRequest(final Context context, String url, final boolean turnProgress, boolean turnError) {
        final SweetAlertDialog dialog = Sweet.progress(context);
        if (turnProgress) {
            dialog.show();
        }
        final boolean z = turnError;
        final Context context2 = context;
        final boolean z2 = turnProgress;
        final SweetAlertDialog sweetAlertDialog = dialog;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Listener<String>() {
            public void onResponse(String response) {
                Log.e("PASOKH", response);
                if (turnProgress) {
                    dialog.dismiss();
                }
                try {
                    Req.this.success(response);
                } catch (JSONException e) {
                    Log.e("REESWpond", response);
                    Log.e("KHATAjson", e.getMessage());
                    Sweet.customError(context, e.getMessage());
                }
            }
        }, new ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorStringReq", error.toString());
                Req.this.Error(error);
                if (z) {
                    Sweet.errorOpr(context2);
                }
                if (z2) {
                    sweetAlertDialog.dismiss();
                }
            }
        }) {
            protected Map<String, String> getParams() {
                Log.e("USSSED", "SSSSSSS");
                Map<String,String> map=new HashMap<>();

//                map.putAll(Req.this.inputs());
                map.put("auth", "$2y$12$xm73TXe6Mkf4B19nC.ZyUer.9qcz0XdnEY.uXQ/qCExZFgSfadhFC");

                return map;
            }
        };
        stringRequest.setShouldCache(false);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(4000, 0, 1.0f));
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.getCache().clear();
        requestQueue.add(stringRequest);
    }

    private boolean isNetworkAvailable(Context context) {
        @SuppressLint("WrongConstant") ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (NetworkInfo anInfo : info) {
                    if (anInfo.getState() == State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Map<String, String> stringMap() {
        Map<String, String> map = new HashMap();
        map.put("auth", "$2y$12$xm73TXe6Mkf4B19nC.ZyUer.9qcz0XdnEY.uXQ/qCExZFgSfadhFC");
        return map;
    }
}
