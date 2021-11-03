package com.example.triliza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class trial extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);




        textView = findViewById(R.id.textView6);




        String[] ok = getIntent().getStringArrayExtra("kati");//swsto



        String hallo = getIntent().getStringExtra("hallo");







    }
}