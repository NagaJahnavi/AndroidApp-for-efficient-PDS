package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionlayout);
    }
    public void login(View view){
        Intent i=new Intent(OptionActivity.this,ULoginActivity.class);
        startActivity(i);
    }
    public void register(View view){
        Intent i=new Intent(OptionActivity.this,RegisterActivity.class);
        startActivity(i);
    }
}
