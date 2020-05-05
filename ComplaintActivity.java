package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComplaintActivity extends AppCompatActivity {
    EditText et1,et2;
    Button btn;
    ComplaintDB obj;
    SQLiteDatabase db;
    String rc,ph,dist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaintlayout);
        Intent i=getIntent();
        rc=i.getStringExtra("rcno");
        ph=i.getStringExtra("phno");
        dist=i.getStringExtra("district");
        et1=(EditText)findViewById(R.id.editText9);
        et2=(EditText)findViewById(R.id.editText10);
        btn=(Button)findViewById(R.id.button9);
        obj=new ComplaintDB(this);
        db=obj.getWritableDatabase();
    }
    public void submit(View v){

        String loc=et1.getText().toString();
        String comp=et2.getText().toString();
        ContentValues cv=new ContentValues();
        cv.put("rcno",rc);
        cv.put("phno",ph);
        cv.put("district",dist);
        cv.put("area",loc);
        cv.put("comp",comp);
        cv.put("status","UnResolved");
        long l=db.insert("complaint",null,cv);
        Toast.makeText(getApplicationContext(),"Complaint succesfully received",Toast.LENGTH_LONG).show();

        Intent i=new Intent(ComplaintActivity.this,LoginActivity.class);
        startActivity(i);

    }
}
