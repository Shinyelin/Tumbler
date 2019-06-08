package com.hansung.android.tumbler;


import android.content.Intent;

import android.database.Cursor;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageButton;

import android.widget.Toast;


/**
 * Created by 박성균 on 2015-04-11.
 */

public class Member extends Info {

    EditText NAME, AGE, HEIGHT, WEIGHT;

    String Tname, Tpass, Tnum, Tweight;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_member);

        NAME = (EditText) findViewById(R.id.name);

        AGE = (EditText) findViewById(R.id.age);

        HEIGHT = (EditText) findViewById(R.id.height);

        WEIGHT = (EditText) findViewById(R.id.weight);


        Button join = (Button) findViewById(R.id.join);

        join.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Tname = NAME.getText().toString();

                Tpass = AGE.getText().toString();   //나이

                Tnum = HEIGHT.getText().toString();     //키

                Tweight = WEIGHT.getText().toString();

                Cursor cursor = database.rawQuery("SELECT name, num, major, water FROM " + tableName, null);

                int count = cursor.getCount();

                for (int i = 0; i < count; i++) {

                    cursor.moveToNext();


                    Cname = cursor.getString(0);

                    Cheight = cursor.getString(1);

                    Cweight = cursor.getString(2);

                    Cwater = cursor.getString(3);  //물마신 값넣는 필드에서 값가져옴


                }

                if (Tname.length() < 1) {

                    Toast.makeText(getApplicationContext(), "이름을 정확하게 입력해주세요.",

                            Toast.LENGTH_SHORT).show();

                } else if (Tpass.length() < 1) {

                    Toast.makeText(getApplicationContext(), "나이를 정확하게 입력해주세요.",

                            Toast.LENGTH_SHORT).show();

                } else if (Tname.equals(Cname)) {

                    Toast.makeText(getApplicationContext(), "이미 등록된 이름입니다." + Tnum.length() + "" + Tname + "" + Cname,

                            Toast.LENGTH_SHORT).show();

                } else if (Tnum.length() < 2) {

                    Toast.makeText(getApplicationContext(), "키를 정확히 입력해주세요.",

                            Toast.LENGTH_SHORT).show();

                } else if (Tweight.length() < 2) {

                    Toast.makeText(getApplicationContext(), "몸무게를 정확히 입력해주세요.",

                            Toast.LENGTH_SHORT).show();

                } else {

                    try {

                        if (database != null) {

                            database.execSQL("INSERT INTO " + tableName + "(name, pass,  num, major, water) VALUES" +

                                    "(" + "'" + Tname + "'" + "," + "'" + Tpass + "'" + "," + "'" + Tnum + "'" + "," + "'" + Tweight  + "'" + "," + ""+ ")");

                        }


                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                    Intent login = new Intent(getApplication(), Character.class);

                    login.putExtra("splash", "splash");


                    startActivity(login);

                   finish();
                    Toast.makeText(getApplication(), Cwater +"님 회원가입을 축하합니다.", Toast.LENGTH_LONG).show();




                }


            }
        });

    }


}


