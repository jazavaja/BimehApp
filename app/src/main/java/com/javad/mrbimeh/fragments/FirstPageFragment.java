package com.javad.mrbimeh.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener;

import com.javad.mrbimeh.MyTextView.NumTextView;
import com.javad.mrbimeh.R;
import com.javad.mrbimeh.Sweet;
import com.javad.mrbimeh.VIPActivity;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog.OnDateSetListener;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;
import de.hdodenhof.circleimageview.CircleImageView;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class FirstPageFragment extends BaseFragment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int PICCARDMELI = 2;
    int PICSIGNUP = 1;
    TextInputEditText address;
    TextInputEditText age;
    LinearLayout birth;
    View btn_accept;
    TextInputEditText family;
    TextInputEditText homeNumber;
    AppCompatCheckBox karShenasBazaryabi;
    AppCompatCheckBox krshnsForosh;
    AppCompatCheckBox krshnsLearn;
    AppCompatCheckBox krshnsMoarefi;
    AppCompatCheckBox krshnsNiro;
    AppCompatCheckBox krshnsPoshtibani;
    TextInputEditText melicode;
    TextInputEditText moaref;
    TextInputEditText name;
    CircleImageView picCardMeli;
    CircleImageView picSignUp;
    NumTextView textBirth;

    /* renamed from: com.javad.mrbimeh.fragments.FirstPageFragment$2 */
    class C03642 implements OnClickListener {

        /* renamed from: com.javad.mrbimeh.fragments.FirstPageFragment$2$1 */
        class C09591 implements OnDateSetListener {
            C09591() {
            }

            @SuppressLint({"SetTextI18n"})
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                NumTextView numTextView = FirstPageFragment.this.textBirth;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(year);
                stringBuilder.append("/");
                stringBuilder.append(monthOfYear);
                stringBuilder.append(1);
                stringBuilder.append("/");
                stringBuilder.append(dayOfMonth);
                numTextView.setText(stringBuilder.toString());
            }
        }

        C03642() {
        }

        public void onClick(View view) {
            PersianCalendar persianCalendar = new PersianCalendar();
            DatePickerDialog.newInstance(new C09591(), persianCalendar.getPersianYear(), persianCalendar.getPersianMonth(), persianCalendar.getPersianDay()).show(((FragmentActivity) Objects.requireNonNull(FirstPageFragment.this.getActivity())).getFragmentManager(), "Datepickerdialog");
        }
    }

    /* renamed from: com.javad.mrbimeh.fragments.FirstPageFragment$3 */
    class C03663 implements OnClickListener {

        /* renamed from: com.javad.mrbimeh.fragments.FirstPageFragment$3$1 */
        class C03651 implements Runnable {
            C03651() {
            }

            public void run() {
                SecondPageFragment fragment = new SecondPageFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", FirstPageFragment.this.gtText(FirstPageFragment.this.name));
                bundle.putString("family", FirstPageFragment.this.gtText(FirstPageFragment.this.family));
                bundle.putString("birth", FirstPageFragment.this.textBirth.getText().toString());
                bundle.putString("age", FirstPageFragment.this.gtText(FirstPageFragment.this.age));
                bundle.putString("moaref", FirstPageFragment.this.gtText(FirstPageFragment.this.moaref));
                bundle.putString("address", FirstPageFragment.this.gtText(FirstPageFragment.this.address));
                bundle.putString("homeNumber", FirstPageFragment.this.gtText(FirstPageFragment.this.homeNumber));
                bundle.putString("melicode", FirstPageFragment.this.gtText(FirstPageFragment.this.melicode));
                bundle.putBoolean("karShenasBazaryabi", FirstPageFragment.this.karShenasBazaryabi.isChecked());
                bundle.putBoolean("krshnsNiro", FirstPageFragment.this.krshnsNiro.isChecked());
                bundle.putBoolean("krshnsPoshtibani", FirstPageFragment.this.krshnsPoshtibani.isChecked());
                bundle.putBoolean("krshnsMoarefi", FirstPageFragment.this.krshnsMoarefi.isChecked());
                bundle.putBoolean("krshnsLearn", FirstPageFragment.this.krshnsLearn.isChecked());
                bundle.putByteArray("picture", FirstPageFragment.this.imageviewToString(FirstPageFragment.this.picSignUp));
                bundle.putByteArray("melicard", FirstPageFragment.this.imageviewToString(FirstPageFragment.this.picCardMeli));
                fragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = FirstPageFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        }

        C03663() {
        }

        public void onClick(View v) {
            if (FirstPageFragment.this.notNull()) {
                new Thread(new C03651()).start();
            } else {
                FirstPageFragment.isNull(FirstPageFragment.this.getActivity());
            }
        }
    }

    /* renamed from: com.javad.mrbimeh.fragments.FirstPageFragment$4 */
    class C03674 implements OnClickListener {
        C03674() {
        }

        public void onClick(View view) {
            Intent photoPickerIntent = new Intent("android.intent.action.PICK");
            photoPickerIntent.setType("image/*");
            FirstPageFragment.this.startActivityForResult(photoPickerIntent, FirstPageFragment.this.PICSIGNUP);
        }
    }

    /* renamed from: com.javad.mrbimeh.fragments.FirstPageFragment$5 */
    class C03685 implements OnClickListener {
        C03685() {
        }

        public void onClick(View view) {
            Intent photoPickerIntent = new Intent("android.intent.action.PICK");
            photoPickerIntent.setType("image/*");
            FirstPageFragment.this.startActivityForResult(photoPickerIntent, FirstPageFragment.this.PICCARDMELI);
        }
    }

    /* renamed from: com.javad.mrbimeh.fragments.FirstPageFragment$1 */
    static class C09581 implements OnSweetClickListener {
        C09581() {
        }

        public void onClick(SweetAlertDialog sweetAlertDialog) {
            sweetAlertDialog.dismiss();
        }
    }

    static void isNull(Activity context) {
        SweetAlertDialog s = new SweetAlertDialog(context, 1).setTitleText("خطـا").setContentText("لطفا همه موارد خالی را پر کنید..").setConfirmText("بــاشـه").setConfirmClickListener(new C09581());
        s.setCancelable(false);
        s.show();
    }

    private void find(View view) {
        this.picCardMeli = (CircleImageView) view.findViewById(R.id.picCardMeli);
        this.btn_accept = view.findViewById(R.id.btn_accept);
        this.name = (TextInputEditText) view.findViewById(R.id.nameSignup);
        this.family = (TextInputEditText) view.findViewById(R.id.familySignup);
        this.birth = (LinearLayout) view.findViewById(R.id.birthhh);
        this.textBirth = (NumTextView) view.findViewById(R.id.txtBirth);
        this.age = (TextInputEditText) view.findViewById(R.id.ageSignup);
        this.address = (TextInputEditText) view.findViewById(R.id.addressSignUp);
        this.homeNumber = (TextInputEditText) view.findViewById(R.id.homeNumber);
        this.melicode = (TextInputEditText) view.findViewById(R.id.melicode);
        this.krshnsForosh = (AppCompatCheckBox) view.findViewById(R.id.krshnsForosh);
        this.karShenasBazaryabi = (AppCompatCheckBox) view.findViewById(R.id.karShenasBazaryabi);
        this.krshnsNiro = (AppCompatCheckBox) view.findViewById(R.id.krshnsNiro);
        this.krshnsPoshtibani = (AppCompatCheckBox) view.findViewById(R.id.krshnsPoshtibani);
        this.krshnsMoarefi = (AppCompatCheckBox) view.findViewById(R.id.krshnsMoarefi);
        this.krshnsLearn = (AppCompatCheckBox) view.findViewById(R.id.krshnsLearn);
        this.picSignUp = (CircleImageView) view.findViewById(R.id.picSignup);
        VIPActivity.header_steps.setVisibility(View.VISIBLE);
        this.moaref = (TextInputEditText) view.findViewById(R.id.moaref);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        find(view);
        btn_acceptClick();
        getFromGallery();
        setBirth();
        return view;
    }

    private void setBirth() {
        this.birth.setOnClickListener(new C03642());
    }

    public void btn_acceptClick() {
        this.btn_accept.setOnClickListener(new C03663());
    }

    public boolean notNull() {
        if (!(gtText(this.name).equals("") || gtText(this.family).equals("") || gtText(this.age).equals("") || gtText(this.address).equals("") || gtText(this.homeNumber).equals("") || gtText(this.melicode).equals(""))) {
            if (!this.textBirth.getText().toString().equals("")) {
                return true;
            }
        }
        return false;
    }

    public byte[] imageviewToString(ImageView img) {
        Bitmap bm = ((BitmapDrawable) img.getDrawable()).getBitmap();
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        bm.compress(CompressFormat.PNG, 100, bao);
        try {
            bao.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bao.toByteArray();
    }

    public String gtText(TextInputEditText editText) {
        return editText.getText().toString();
    }

    public void getFromGallery() {
        this.picSignUp.setOnClickListener(new C03674());
        this.picCardMeli.setOnClickListener(new C03685());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            if (requestCode == this.PICSIGNUP) {
                try {
                    this.picSignUp.setImageBitmap(BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(data.getData())));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Sweet.customError(getContext(), "متاسفانه خطایی رخ داده است");
                }
            }
            if (requestCode == this.PICCARDMELI) {
                try {
                    this.picCardMeli.setImageBitmap(BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(data.getData())));
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    Sweet.customError(getContext(), "متاسفانه خطایی رخ داده است");
                }
                return;
            }
            return;
        }
        Sweet.customError(getContext(), "شما عکسی را انتخاب نکردید");
    }
}
