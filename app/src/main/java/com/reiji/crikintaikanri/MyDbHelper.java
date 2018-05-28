package com.reiji.crikintaikanri;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

public class MyDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 1;
    MyAppConstract myAppConstract = new MyAppConstract();


    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyAppConstract.WorkTimes.CREATE_TABLE);
        db.execSQL(MyAppConstract.WorkTimes.INIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyAppConstract.WorkTimes.DROP_TABLE);
        onCreate(db);
    }
}
