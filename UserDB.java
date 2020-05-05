package com.example.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="user";
    public static final String DATABASE_TABLE="user1";
    public static final String KEY_RCNO="RCNO";
    public static final String KEY_PHNO="phno";
    public static final String KEY_DIST="district";

    private final static String qry="create table "+DATABASE_TABLE+"("+KEY_RCNO+" varchar2(20),"+KEY_PHNO+" varchar2(10),"+KEY_DIST+" varchar2(10));";
    public UserDB(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(qry);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        String q="Drop table if exists "+DATABASE_TABLE+";";
        db.execSQL(q);
        onCreate(db);
    }

}
