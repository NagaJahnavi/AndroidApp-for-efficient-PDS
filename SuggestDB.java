package com.example.myapplication1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SuggestDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="suggest";
    public static final String DATABASE_TABLE="suggestions";
    public static final String KEY_DIST="district";
    public static final String KEY_AREA="area";
    public static final String KEY_SUGGEST="sugg";
    private final static String qry="create table "+DATABASE_TABLE+"("+KEY_DIST+" varchar2(10),"+KEY_AREA+" varchar2(20),"+KEY_SUGGEST+" varchar2(50));";
    public SuggestDB(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(qry);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
        String q = "Drop table if exists " + DATABASE_TABLE + ";";
        db.execSQL(q);
        onCreate(db);
    }
}
