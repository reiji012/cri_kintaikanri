package com.reiji.crikintaikanri;

import android.provider.BaseColumns;

public class MyAppConstract {

    public MyAppConstract() {
    }

    public static abstract class WorkTimes implements BaseColumns {
        //データベース内容
        public static final String TABLE_NAME = "workTime";
        public static final String COLUMN_ID = "_id";
        public static final String WORK_YEAR = "year";
        public static final String WORK_MONTH = "month";
        public static final String WORK_DATE = "date";
        public static final String START_TIME = "startTime";
        public static final String OVER_TIME = "overTime";


        public static final String CREATE_TABLE =
                "create table" + TABLE_NAME + "(" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WORK_YEAR + "TEXT, " +
                WORK_MONTH + "TEXT, " +
                WORK_DATE + "TEXT, " +
                START_TIME + "TEXT, " +
                OVER_TIME + "TEXT)";

        public static final String INIT_TABLE =
                "insert into users (userEmail, userID, userPass, userName) value " +
                "(test@email.com, tester, 1111, saito)";

        public static final String DROP_TABLE =
                "drop table if exists " + TABLE_NAME;
    }
}

