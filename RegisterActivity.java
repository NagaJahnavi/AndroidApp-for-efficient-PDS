package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText rcno,mobno,dist;
    Button btn;

    SQLiteDatabase db;
    UserDB obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerlayout);

        rcno=(EditText)findViewById(R.id.editText2);
        mobno=(EditText)findViewById(R.id.editText3);
        dist=(EditText)findViewById(R.id.editText4);

        obj=new UserDB(this);
        db=obj.getWritableDatabase();
    }
    public void register(View v){
        String rc=rcno.getText().toString();
        String mb=mobno.getText().toString();
        String dis=dist.getText().toString();

        ContentValues cv=new ContentValues();
        cv.put("rcno",rc);
        cv.put("phno",mb);
        cv.put("district",dis);


        long l=db.insert("complaint",null,cv);
        Intent i=new Intent(RegisterActivity.this,ComplaintActivity.class);
        i.putExtra("rcno",rc);
        i.putExtra("phno",mb);
        i.putExtra("district",dis);
        startActivity(i);
    }

}
