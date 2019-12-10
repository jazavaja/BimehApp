package com.javad.mrbimeh.fragments;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.javad.mrbimeh.R;
import com.javad.mrbimeh.VIPActivity;

public class SecondPageFragment extends BaseFragment {
    View btn_accept;
    RadioGroup radioGroup;

    /* renamed from: com.javad.mrbimeh.fragments.SecondPageFragment$1 */
    class C03761 implements OnClickListener {

        /* renamed from: com.javad.mrbimeh.fragments.SecondPageFragment$1$1 */
        class C03751 implements Runnable {

            public void run() {
                int idRadioButton = SecondPageFragment.this.radioGroup.getCheckedRadioButtonId();
                if (idRadioButton != 0) {
                    ThirdPageFragment fragment = new ThirdPageFragment();
                    Bundle bundle = new Bundle();
                    bundle.putAll(SecondPageFragment.this.getBundel());
                    bundle.putInt("plan", SecondPageFragment.this.getFromPlan(idRadioButton));
                    fragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = SecondPageFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                }
            }
        }

        C03761() {
        }

        public void onClick(View v) {
            new Thread(new C03751()).start();
        }
    }

    public void tost(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_page, container, false);
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
        stringBuilder.append(bundle.getString("address"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("homeNumber"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("melicode"));
        stringBuilder.append(" ");
        stringBuilder.append(bundle.getString("moaref"));
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
        stringBuilder.append(bundle.getByteArray("picture").toString());
        Log.e("REESSUULLTT", stringBuilder.toString());
        this.btn_accept = view.findViewById(R.id.btn_accept);
        this.radioGroup = (RadioGroup) view.findViewById(R.id.groupRadio);
        if (VERSION.SDK_INT >= 16) {
            VIPActivity.text1.setBackground(getResources().getDrawable(R.drawable.shape_btn_disable));
            VIPActivity.text2.setBackground(getResources().getDrawable(R.drawable.shape_btn));
            VIPActivity.text3.setBackground(getResources().getDrawable(R.drawable.shape_btn_disable));
        }
        this.btn_accept.setOnClickListener(new C03761());
        return view;
    }

    public int getFromPlan(int id) {
        if (id == R.id.salane) {
            return 12;
        }
        if (id == R.id.seMahe || id != R.id.sixMahe) {
            return 3;
        }
        return 6;
    }

    public Bundle getBundel() {
        Bundle bundle = getArguments();
        bundle.getString("name");
        bundle.getString("family");
        bundle.getString("birth");
        bundle.getString("age");
        bundle.getString("mobile");
        bundle.getString("moaref");
        bundle.getString("address");
        bundle.getString("homeNumber");
        bundle.getBoolean("karShenasBazaryabi");
        bundle.getBoolean("krshnsNiro");
        bundle.getBoolean("krshnsPoshtibani");
        bundle.getBoolean("krshnsMoarefi");
        bundle.getBoolean("krshnsLearn");
        bundle.getString("melicode");
        bundle.getByteArray("picture");
        bundle.getByteArray("melicard");
        return bundle;
    }
}
