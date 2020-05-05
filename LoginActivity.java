package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
 Button b1;
 Button b2;
 Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
    }
    public void officerLogin(View v){
        Intent i=new Intent(LoginActivity.this,OfficerActivity.class);
        startActivity(i);
    }
    public void  complaint(View v){
        Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);
    }
    public void suggestion(View v){
        Intent i=new Intent(LoginActivity.this,SuggestActivity.class);
        startActivity(i);
    }
}
