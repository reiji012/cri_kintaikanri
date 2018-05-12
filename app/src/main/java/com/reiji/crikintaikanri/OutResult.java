package com.reiji.crikintaikanri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class OutResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_result);

        Calendar cal = Calendar.getInstance();       //カレンダーを取得

        int iYear = cal.get(Calendar.YEAR);         //年を取得
        int iMonth = cal.get(Calendar.MONTH);       //月を取得
        int iDate = cal.get(Calendar.DATE);         //日を取得
        int iHour = cal.get(Calendar.HOUR_OF_DAY);         //時を取得
        int iMinute = cal.get(Calendar.MINUTE);    //分を取得

        String strDay = iMonth + "月" + iDate + "日　";     //日付を表示形式で設定
        String strTime = iHour + "時" + iMinute + "分"; //時刻を表示形式で設

        TextView outTime = (TextView)findViewById(R.id.outTime);
        outTime.setText("退勤時間：" + strDay + strTime);

        Intent intent = getIntent();
        String myName = intent.getStringExtra(MainActivity.EXTRA_MYNAME);
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(myName);
    }

    public void confirm(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
