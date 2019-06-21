package com.hansung.android.tumbler;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1Fragment extends Fragment {

    private BluetoothSPP bt;
    Button btn_1;
    Button btn_2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_menu1, container,false);
        btn_1 = (Button) rootView.findViewById(R.id.btn_1);
        btn_2 = (Button) rootView.findViewById(R.id.btn_2);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.ch_menu0Fragment();
//                ((MainActivity) getActivity()).switchFragment(0);
                Toast.makeText(getContext().getApplicationContext(),"얼마 남지 않았어요",Toast.LENGTH_LONG).show();

            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.ch_menu4Fragment();
//                ((MainActivity) getActivity()).switchFragment(0);
                Toast.makeText(getContext().getApplicationContext(),"일주일간 당신은 얼마나 마셨나요?",Toast.LENGTH_LONG).show();

            }
        });
        return rootView;

    }



}