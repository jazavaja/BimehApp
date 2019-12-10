package com.javad.mrbimeh.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.javad.mrbimeh.R;
import com.javad.mrbimeh.VIPActivity;

public class PageFragment extends BaseFragment {
    View btn_lets_go;

    /* renamed from: com.javad.mrbimeh.fragments.PageFragment$1 */
    class C03741 implements OnClickListener {

        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = PageFragment.this.getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new FirstPageFragment());
            fragmentTransaction.commit();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        this.btn_lets_go = view.findViewById(R.id.btn_lets_go);
        VIPActivity.header_steps.setVisibility(View.GONE);
        this.btn_lets_go.setOnClickListener(new C03741());
        return view;
    }
}
