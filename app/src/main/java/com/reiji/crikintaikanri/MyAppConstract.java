package com.reiji.crikintaikanri;

import android.provider.BaseColumns;

public class MyAppConstract {

    public MyAppConstract() {}

    public static abstract class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String USER_EMAIL = "userEmail";
        public static final String USER_ID = "userId";
        public static final String USER_PASS = "userPass";
        public static final String USER_NAME = "userName";

    }
}
