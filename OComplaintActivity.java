package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OComplaintActivity extends AppCompatActivity {
    ComplaintDB db;
    String d;
    Button nextbtn, prevbtn ;
    EditText rcno, phno,area,comp;
    SQLiteDatabase SQLITEDATABASE ;

    String GetSQliteQuery;

    Cursor cursor ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ocomplaintlayout);
        Intent i=getIntent();
        d=i.getStringExtra("district");
        rcno=(EditText)findViewById(R.id.editText);
        phno=(EditText)findViewById(R.id.editText12);
        area=(EditText)findViewById(R.id.editText14);
        comp=(EditText)findViewById(R.id.editText15);
        nextbtn=(Button)findViewById(R.id.button11);
        prevbtn=(Button)findViewById(R.id.button12);
        GetSQliteQuery = "SELECT * FROM complaint";

        SQLITEDATABASE = openOrCreateDatabase("complain", Context.MODE_PRIVATE, null);

        cursor = SQLITEDATABASE.rawQuery(GetSQliteQuery, null);

        cursor.moveToFirst();

        GetSQLiteDatabaseRecords();


        nextbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!cursor.isLast()){

                    cursor.moveToNext();
                }

                GetSQLiteDatabaseRecords();

            }
        });

        prevbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!cursor.isFirst()){

                    cursor.moveToPrevious();
                }
                GetSQLiteDatabaseRecords();

            }
        });
    }

    public void GetSQLiteDatabaseRecords(){
        if((cursor.getString(2).toString()).equals(d)) {

            rcno.setText(cursor.getString(0).toString());

            phno.setText(cursor.getString(1).toString());

            area.setText(cursor.getString(3).toString());

            comp.setText(cursor.getString(4).toString());
        }
    }
    public void suggest(View v){
        if((cursor.getString(2).toString()).equals(d)) {
        }
    }

}
