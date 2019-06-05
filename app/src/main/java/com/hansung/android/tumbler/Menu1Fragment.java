package com.hansung.android.tumbler;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1Fragment extends Fragment {

    private BluetoothSPP bt;

    @Nullable
    private  ImageView imgview;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_menu1, container,false);


        imgview = (ImageView) rootView.findViewById(R.id.img);
        imgview.post(new Runnable(){
            @Override
            public void run(){
                ((AnimationDrawable) imgview.getBackground()).start();
            }
        });




        return rootView;

    }



}