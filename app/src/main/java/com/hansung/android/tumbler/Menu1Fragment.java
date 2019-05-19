package com.hansung.android.tumbler;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu1Fragment extends Fragment {


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