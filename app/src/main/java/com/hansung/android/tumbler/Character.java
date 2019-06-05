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
                Tgoal = rb.getText().toString();



                Intent login = new Intent(getApplication(), MainActivity.class);

                login.putExtra("splash", "splash");


                startActivity(login);

                finish();

                Toast.makeText(getApplication(), Tgoal +"님 회원가입을 축하합니다.", Toast.LENGTH_LONG).show();

            }
        });


    }
}
