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

public class SuggestActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button btn;
    SQLiteDatabase db;
    SuggestDB obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suggestlayout);
        et1=(EditText)findViewById(R.id.editText7);
        et2=(EditText)findViewById(R.id.editText8);
        et3=(EditText)findViewById(R.id.editText11);
        btn=(Button)findViewById(R.id.button10);
        obj=new SuggestDB(this);
        db=obj.getWritableDatabase();
    }
    public void submit(View v){
        String dist=et1.getText().toString();
        String area=et2.getText().toString();
        String sug=et3.getText().toString();
        ContentValues cv=new ContentValues();
        cv.put("district",dist);
        cv.put("area",area);
        cv.put("sugg",sug);
        long l=db.insert("complaint",null,cv);
        Toast.makeText(getApplicationContext(),"Thank you for the Suggestion",Toast.LENGTH_LONG).show();
        Intent i=new Intent(SuggestActivity.this,LoginActivity.class);
        startActivity(i);
    }

}
