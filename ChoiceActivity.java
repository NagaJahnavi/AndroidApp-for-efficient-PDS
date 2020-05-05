package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choicelayout);
        btn1=(Button)findViewById(R.id.button7);
        btn2=(Button)findViewById(R.id.button8);
    }
    public void complaint(View v){
        Intent i=new Intent(ChoiceActivity.this,ComplaintActivity.class);
        startActivity(i);
    }
    /*public void suggest(View v){
        Intent i=new Intent(ChoiceActivity.this,SuggestionsActivity.class);
        startActivity(i);
    }*/
}
