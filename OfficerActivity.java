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

public class OfficerActivity extends AppCompatActivity {
    EditText usr,pass,dis;
    Button btn;
    SQLiteDatabase db;
    OfficerDB obj;
    boolean f=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.officerlayout);
        usr=(EditText)findViewById(R.id.et1);
        pass=(EditText)findViewById(R.id.et2);
        dis=(EditText)findViewById(R.id.et3);
        btn=(Button)findViewById(R.id.btn1);
        obj=new OfficerDB(this);
        db=obj.getWritableDatabase();

    }
    public void login(View v){
        String user=usr.getText().toString();
        String pwd=pass.getText().toString();
        String dist=dis.getText().toString();

        Cursor c = db.query("officer",null,null,null,null,null,null);
        if(c.getCount()==0){
            Toast.makeText(getApplicationContext(),"NO DATA",Toast.LENGTH_LONG);
        }
        else {
            while (c.moveToNext()) {
                String u = c.getString(0);
                String p = c.getString(1);
                String d = c.getString(2);
                if (user.equals(u) && pwd.equals(p) && dist.equalsIgnoreCase(d)) {
                    f=true;
                    Intent i = new Intent(OfficerActivity.this, OComplaintActivity.class);
                    i.putExtra("district", d);
                    startActivity(i);

                }
            }
            if(f==false) {
                Toast.makeText(getApplicationContext(), "Not Valid Officer", Toast.LENGTH_LONG).show();
                Intent i = new Intent(OfficerActivity.this, LoginActivity.class);
                startActivity(i);
            }

        }
        /*Intent i = new Intent(OfficerActivity.this, OComplaintActivity.class);
        i.putExtra("district", dist);
        startActivity(i);*/
    }

}
