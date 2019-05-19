package com.hansung.android.tumbler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Intent intent = new Intent(this, Member.class);
        startActivity(intent);
        finish();

    }
}
