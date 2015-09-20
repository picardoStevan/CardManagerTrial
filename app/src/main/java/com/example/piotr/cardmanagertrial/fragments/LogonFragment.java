package com.example.piotr.cardmanagertrial.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.piotr.cardmanagertrial.R;
import com.example.piotr.cardmanagertrial.misc.Utils;

/**
 * Created by Piotr on 20.09.2015.
 */
public class LogonFragment extends Fragment {
    ProgressBar progressBar;
    Utils utils;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        utils = new Utils(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_logon, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        return rootView;
    }
}
