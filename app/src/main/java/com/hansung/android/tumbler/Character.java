package com.hansung.android.tumbler;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Character extends Info {
    String Tgoal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chracter);
        Button b = (Button)findViewById(R.id.character_finish);
        final RadioGroup rg= (RadioGroup)findViewById(R.id.character_radio);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                RadioButton rb =(RadioButton) findViewById(id);
                if(rb.getId()==R.id.character_beauty){
                    Tgoal = "beauty";
                }
               else if(rb.getId()==R.id.character_diet){
                    Tgoal = "diet";
                }else{
                   Tgoal = "health";
                }
                database.execSQL("UPDATE " + tableName + " SET character = " +"'"+Tgoal+"'"+ " WHERE name ="+"'"+Member.Tname+"';");
                Cursor cursor = database.rawQuery("SELECT name, num, major, character, water FROM " + tableName, null);

                int count = cursor.getCount();

                for (int i = 0; i < count; i++) {

                    cursor.moveToNext();


                    Cname = cursor.getString(0);

                    Cheight = cursor.getString(1);

                    Cweight = cursor.getString(2);

                    Ccharacter = cursor.getString(3);  //물마신 값넣는 필드에서 값가져옴

                    Cwater = cursor.getString(4);  //물마신 값넣는 필드에서 값가져옴



                    // Cwater 이라는 코드에 물 마신 값을 넣어줍니다.

                }



                Intent login = new Intent(getApplication(), MainActivity.class);

                login.putExtra("splash", "splash");


                startActivity(login);

                finish();

                Toast.makeText(getApplication(), Ccharacter +"님 회원가입을 축하합니다.", Toast.LENGTH_LONG).show();

            }
        });


    }
}
