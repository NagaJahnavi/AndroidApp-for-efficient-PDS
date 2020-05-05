package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homelayout);
        next=(Button)findViewById(R.id.button);
    }
    public void click(View v){
        Intent i=new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(i);
    }
}
