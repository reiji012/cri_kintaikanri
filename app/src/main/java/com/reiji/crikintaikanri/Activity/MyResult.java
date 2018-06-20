package com.reiji.crikintaikanri.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.reiji.crikintaikanri.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_result);

        Calendar calendar = Calendar.getInstance();       //カレンダーを取得

        SimpleDateFormat format = new SimpleDateFormat("MM月dd日　HH時mm分");


        TextView startTime = (TextView)findViewById(R.id.startTime);
        startTime.setText(format.format("出勤時間: " + calendar.getTime()));

        Intent intent = getIntent();

    }

    public void confirm(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //バックキーの制御
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode != KeyEvent.KEYCODE_BACK){
            return super.onKeyDown(keyCode, event);
        } else {
            return false;
        }
    }
}
