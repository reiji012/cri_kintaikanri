package com.reiji.crikintaikanri;

import android.provider.BaseColumns;

public class MyAppConstract {

    public MyAppConstract() {
    }

    public static abstract class Users implements BaseColumns {
        //データベース内容
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "_id";
        public static final String USER_EMAIL = "userEmail";
        public static final String USER_ID = "userId";
        public static final String USER_PASS = "userPass";
        public static final String USER_NAME = "userName";

        /**
         * テーブルを作成する
         * execSQLメソッドにCREATET TABLE命令を文字列として渡すことで実行される
         * 引数で指定されているものの意味は以下の通り
         * 引数1 ・・・ id：列名 , INTEGER：数値型 , PRIMATY KEY：テーブル内の行で重複無し , AUTOINCREMENT：1から順番に振っていく
         * 引数2 ・・・ name：列名 , TEXT：文字列型
         * 引数3 ・・・ price：列名 , INTEGER：数値型
         */
        public static final String CREATE_TABELE =
                "create table" + TABLE_NAME + "(" +
                COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "+
                USER_EMAIL + "TEXT, "+
                USER_ID + "TEXT, "+
                USER_PASS + "TEXT, "+
                USER_NAME + "TEXT)";
        public static final String INIT_TABLE =
                "insert into users (userEmail, userID, userPass, userName) value " +
                "(test@email.com, tester, 1111, saito)";

        public static final String DROP_TABLE =
                "drop table if exists " + TABLE_NAME;
    }
}

