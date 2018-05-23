package com.reiji.crikintaikanri;

import android.provider.BaseColumns;

public class MyAppConstract {

    public MyAppConstract() {
    }

    public static abstract class Users implements BaseColumns {
        //データベース内容
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "_id";
        public static final String USER_ID = "userId";
        public static final String USER_PASS = "userPass";
        public static final String USER_NAME = "userName";

        public static final String CREATE_TABELE =
                "create table" + TABLE_NAME + "(" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_ID + "TEXT, " +
                USER_PASS + "TEXT, " +
                USER_NAME + "TEXT)";

        public static final String INIT_TABLE =
                "insert into users (userEmail, userID, userPass, userName) value " +
                "(test@email.com, tester, 1111, saito)";

        public static final String DROP_TABLE =
                "drop table if exists " + TABLE_NAME;
    }
}

