package com.hansung.android.tumbler;


import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */

public class Menu3Fragment extends Fragment implements TimePicker.OnTimeChangedListener{

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Context context;
    PendingIntent pendingIntent;
    Calendar mCalendar;
    TextView tp_text;
    Button btn_start;
    Button btn_end;
    int hour, min;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu3, container, false);
        alarm_timepicker = (TimePicker)view.findViewById(R.id.timepicker);
        mCalendar = Calendar.getInstance();
        tp_text = (TextView) view.findViewById(R.id.tp_text);
        if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hour = alarm_timepicker.getHour();
            min = alarm_timepicker.getMinute();
        } else {
            hour = alarm_timepicker.getCurrentHour();
            min = alarm_timepicker.getCurrentMinute();
        }
        int hourofDay = mCalendar.get(mCalendar.HOUR_OF_DAY);
        int minute = mCalendar.get(mCalendar.MINUTE);
        int second  = mCalendar.get(mCalendar.SECOND);
        alarm_timepicker.setOnTimeChangedListener(this);
        btn_start = (Button) view.findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int hourOfDay = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                tp_text.setText("예약 시간 : " + hourOfDay +" 시 " + minute + " 분 " + "으로 예약되셨습니다");
                Toast.makeText(getContext().getApplicationContext(),"알람 예약되었습니다",Toast.LENGTH_LONG).show();
                createNotification();
            }
        });
        btn_end = (Button) view.findViewById(R.id.btn_end);
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp_text.setText("알람 시간을 설정해주세요" );
            }
        });
        return view;
    }
    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        tp_text.setText("예약 시간 : " + hourOfDay +" 시 " + minute + " 분 ");

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void createNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(), "default");
        int hourOfDay = alarm_timepicker.getHour();
        int minute = alarm_timepicker.getMinute();

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("알람이 설정되었습니다.");
        builder.setContentText("예약 시간 : " + hourOfDay +" 시 " + minute + " 분 " + "으로 예약되셨습니다");

        builder.setColor(Color.WHITE);
        // 사용자가 탭을 클릭하면 자동 제거
        builder.setAutoCancel(true);

        // 알림 표시
        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }
        notificationManager.notify(1, builder.build());
    }
}