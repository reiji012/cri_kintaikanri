package com.reiji.crikintaikanri;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

            //時刻の値を取得
            TextView clock =

                    (TextView) findViewById(R.id.clock);
            String time = clock.getText().toString().trim();
            // 次の画面へ移行
            Intent intent = new Intent(this, MyResult.class);
            startActivity(intent);
    }



    public void out(View view) {

            TextView clock =

                    (TextView) findViewById(R.id.clock);
            String time = clock.getText().toString().trim();
            // 次の画面へ移行
            Intent intent = new Intent(this, OutResult.class);
            startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //キーボードを閉じたいEditTextオブジェクト
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
    //toolbarにメニューボタンを表示
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    // オプションメニューのアイテムが選択されたときに呼び出されるメソッド
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent history = new Intent(this, calendarActivity.class);
                startActivity(history);
                return true;

        }
        return super.onOptionsItemSelected(item);
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