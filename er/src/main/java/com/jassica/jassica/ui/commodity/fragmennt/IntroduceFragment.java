package com.jassica.jassica.ui.commodity.fragmennt;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jassica.jassica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceFragment extends Fragment {


    public IntroduceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_introduce, container, false);
    }

}
