package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ULoginActivity extends AppCompatActivity {
    EditText mobno, pass;
    Button btn;
      SQLiteDatabase db;
      UserDB obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uloginlayout);
        mobno = (EditText) findViewById(R.id.editText4);
        pass = (EditText) findViewById(R.id.editText5);
        btn = (Button) findViewById(R.id.button5);

    }

    public void login(View v) {
        String mb = mobno.getText().toString();
        String pwd = pass.getText().toString();
        Cursor c = db.query("user1", null, null, null, null, null, null);
        while (c.moveToNext()) {
            String m = c.getString(1);
            String p = c.getString(3);
            if (mb.equals(m) && pwd.equals(p)) {
                Intent i = new Intent(ULoginActivity.this, ComplaintActivity.class);
                String r = c.getString(0);
                String d = c.getString(2);
                i.putExtra("rcno", r);
                i.putExtra("phno", p);
                i.putExtra("district", d);
                startActivity(i);

            }
        }

        Toast.makeText(getApplicationContext(), "please register", Toast.LENGTH_LONG).show();
        Intent i = new Intent(ULoginActivity.this, RegisterActivity.class);
        startActivity(i);

    }
}