package com.hansung.android.tumbler;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Menu0Fragment extends Fragment {
    @Nullable
    private View imgview;
    private ImageView img;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_menu0, container,false);

        imgview = (View) rootView.findViewById(R.id.view_transition_drawable);
        imgview.post(new Runnable(){
            @Override
            public void run(){
                ((AnimationDrawable) imgview.getBackground()).start();
            }
        });

        img = (ImageView) rootView.findViewById(R.id.img);
        img.post(new Runnable(){
            @Override
            public void run(){
                ((AnimationDrawable) img.getBackground()).start();
            }
        });
        return rootView;

    }

}
