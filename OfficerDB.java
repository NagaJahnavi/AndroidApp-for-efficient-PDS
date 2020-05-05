package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OfficerDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "officer1";
    public static final String DATABASE_TABLE = "officer";
    public static final String KEY_USERID = "usr";
    public static final String KEY_PWD = "pass";
    public static final String KEY_DIST = "district";
    private final static String qry = "create table " + DATABASE_TABLE + "(" + KEY_USERID + " varchar2(20)," + KEY_PWD + " varchar2(10)," + KEY_DIST + " varchar2(10));";

    public OfficerDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(qry);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q = "Drop table if exists " + DATABASE_TABLE + ";";
        db.execSQL(q);
        onCreate(db);
    }
}

