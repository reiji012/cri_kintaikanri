package com.reiji.crikintaikanri;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MYNAME = "com.reiji.kintaikanri.MYNAME";

    private Handler mHandler;
    private Timer mTimer;
    // 時刻表示のフォーマット
    private static SimpleDateFormat mSimpleDataFormat = new SimpleDateFormat("yyyy年　MM月dd日　HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler(getMainLooper());
        mTimer = new Timer();

        // 一秒ごとに定期的に実行します。
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    public void run() {
                        Calendar calendar = Calendar.getInstance();
                        String nowDate = mSimpleDataFormat.format(calendar.getTime());
                        // 時刻表示をするTextView
                        TextView clock =(TextView)findViewById(R.id.clock);
                        clock.setText(nowDate);
                    }
                });}
        },0,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 定期実行をcancelする
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }

    //名前の値を取得をする
    public void start(View view) {
        //EditTextの取得
        EditText name = (EditText) findViewById(R.id.name);
        //中身の取得
        String myName = name.getText().toString().trim();
        //中身の条件分岐
        if (myName.equals("")){
            name.setError("名前を入れてください");
        }else{
            //時刻の値を取得
            TextView clock =

                    (TextView) findViewById(R.id.clock);
            String time = clock.getText().toString().trim();
            // 次の画面へ移行
            Intent intent = new Intent(this, MyResult.class);
            intent.putExtra(EXTRA_MYNAME, myName);
            startActivity(intent);
        }
    }


    public void out(View view) {
        //EditTextの取得
        EditText name = (EditText) findViewById(R.id.name);
        //中身の取得
        String myName = name.getText().toString().trim();
        //中身の条件分岐
        if (myName.equals("")){
            name.setError("名前を入れてください");
        }else{
            //時刻の値を取得
            TextView clock =

                    (TextView) findViewById(R.id.clock);
            String time = clock.getText().toString().trim();
            // 次の画面へ移行
            Intent intent = new Intent(this, OutResult.class);
            intent.putExtra(EXTRA_MYNAME, myName);
            startActivity(intent);
        }

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //キーボードを閉じたいEditTextオブジェクト
        EditText name = (EditText) findViewById(R.id.name);
        //画面全体のレイアウト
        android.support.constraint.ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.mainLayout);
        //キーボード表示を制御するためのオブジェクト
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //キーボードを隠す
        inputMethodManager.hideSoftInputFromWindow(mainLayout.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        //背景にフォーカスを移す
        mainLayout.requestFocus();

        return false;
    }
}