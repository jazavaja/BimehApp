package com.javad.mrbimeh;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener;
import com.javad.mrbimeh.Model.InsuranceModel;
import com.javad.mrbimeh.fragments.MessageAdapter;
import com.javad.mrbimeh.inter.item;
import com.javad.mrbimeh.inter.tryAgin;
import java.util.List;

public abstract class Sweet {

    /* renamed from: com.javad.mrbimeh.Sweet$3 */
    static class C09513 implements OnSweetClickListener {
        C09513() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    /* renamed from: com.javad.mrbimeh.Sweet$4 */
    static class C09524 implements OnSweetClickListener {
        C09524() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    /* renamed from: com.javad.mrbimeh.Sweet$5 */
    static class C09535 implements OnSweetClickListener {
        C09535() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    /* renamed from: com.javad.mrbimeh.Sweet$6 */
    static class C09546 implements OnSweetClickListener {
        C09546() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    /* renamed from: com.javad.mrbimeh.Sweet$7 */
    static class C09557 implements OnSweetClickListener {
        C09557() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    /* renamed from: com.javad.mrbimeh.Sweet$8 */
    static class C09568 implements OnSweetClickListener {
        C09568() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    /* renamed from: com.javad.mrbimeh.Sweet$9 */
    static class C09579 implements OnSweetClickListener {
        C09579() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    public static InsuranceModel showDialog(Activity context, final List<String> id, final List<String> name, final List<String> price) {
        Dialog dialog = new Dialog(context);
        View view = context.getLayoutInflater().inflate(R.layout.custom_price_list, null);
        RecyclerView lv = (RecyclerView) view.findViewById(R.id.recyclerView);
        final InsuranceModel model = new InsuranceModel();
        lv.setAdapter(new MessageAdapter(name, price, new item() {
            public void setOnItemClick(int position) {
                model.setId((String) id.get(position));
                model.setName((String) name.get(position));
                model.setPrice((String) price.get(position));
            }
        }));
        dialog.setContentView(view);
        dialog.show();
        return model;
    }

    public static InsuranceModel dialogFire(Context context, List<String> id, List<String> name, List<String> price) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_price_list);
        RecyclerView listView = (RecyclerView) dialog.findViewById(R.id.recyclerView);
        InsuranceModel model = new InsuranceModel();
        final InsuranceModel insuranceModel = model;
        final List<String> list = id;
        final List<String> list2 = name;
        final List<String> list3 = price;
        final Dialog dialog2 = dialog;
        listView.setAdapter(new MessageAdapter(name, price, new item() {
            public void setOnItemClick(int position) {
                insuranceModel.setId((String) list.get(position));
                insuranceModel.setName((String) list2.get(position));
                insuranceModel.setPrice((String) list3.get(position));
                dialog2.dismiss();
            }
        }));
        dialog.show();
        return model;
    }

    public static void nextVersionShow(Context context) {
        SweetAlertDialog s = new SweetAlertDialog(context, 3).setTitleText("نسخه بعدی").setContentText("این قسمت را در نسخه بعدی میبینید").setConfirmText("باشه").setConfirmClickListener(new C09513());
        s.setCancelable(false);
        s.show();
    }

    public static void sucessFulOpr(Context context) {
        SweetAlertDialog s = new SweetAlertDialog(context, 2).setTitleText("موفق").setContentText("عملیات موفق بود").setConfirmClickListener(new C09524());
        s.setCancelable(false);
        s.show();
    }

    public static SweetAlertDialog progress(Context context) {
        SweetAlertDialog s = new SweetAlertDialog(context, 5).setTitleText("لطفا صبر کنید").setConfirmClickListener(new C09535());
        s.setCancelable(false);
        return s;
    }

    public static void errorOpr(Context context) {
        SweetAlertDialog s = new SweetAlertDialog(context, 2).setTitleText("خطا").setContentText("عملیات ناموفق دوباره تلاش کنید").setConfirmClickListener(new C09546());
        s.setCancelable(false);
        s.show();
    }

    public static void errorLenghMobile(Context context) {
        SweetAlertDialog s = new SweetAlertDialog(context, 1).setTitleText("خطا").setContentText("شماره موبایل صحیح نمی باشد").setConfirmText("باشه").setConfirmClickListener(new C09557());
        s.setCancelable(false);
        s.show();
    }

    public static void customError(Context context, String text) {
        SweetAlertDialog s = new SweetAlertDialog(context, 1).setTitleText("خطا").setContentText(text).setConfirmText("باشه").setConfirmClickListener(new C09568());
        s.setCancelable(false);
        s.show();
    }

    public static void customSuccess(Context context, String text) {
        SweetAlertDialog s = new SweetAlertDialog(context, 2).setTitleText("موفق").setContentText(text).setConfirmText("باشه").setConfirmClickListener(new C09579());
        s.setCancelable(false);
        s.show();
    }

    public static void netError(final Activity context, final tryAgin tryAgin) {
        SweetAlertDialog s = new SweetAlertDialog(context, 1).setTitleText("خطـا").setContentText("لـطـفا اتـصـال خـود را چـک کـنـیـد..").setCancelText("خروج").setCancelClickListener(new OnSweetClickListener() {
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                context.finish();
            }
        }).setConfirmText("تلاش دوباره").setConfirmClickListener(new OnSweetClickListener() {
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                tryAgin.tryy();
            }
        });
        s.setCancelable(false);
        s.show();
    }

    public static void isNull(Activity context) {
        SweetAlertDialog s = new SweetAlertDialog(context, 1).setTitleText("خطـا").setContentText("لطفا همه موارد خالی را پر کنید..").setConfirmText("بــاشـه").setConfirmClickListener(new OnSweetClickListener() {
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.dismiss();
            }
        });
        s.setCancelable(false);
        s.show();
    }

    public static void newVersion(final Activity context, final String link) {
        SweetAlertDialog s = new SweetAlertDialog(context, 1).setTitleText("نسخه جدید").setContentText("لطفا گزینه دانلود را بزنید").setConfirmText("خروج").setCancelText("دانلود").setCancelClickListener(new OnSweetClickListener() {
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(link)));
            }
        }).setConfirmClickListener(new OnSweetClickListener() {
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                context.finish();
            }
        });
        s.setCancelable(false);
        s.show();
    }
}
