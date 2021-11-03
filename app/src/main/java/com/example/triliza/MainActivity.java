package com.example.triliza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button neo,synexeia,exit;

    DBHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        neo = findViewById(R.id.bneo);
        synexeia = findViewById(R.id.bsyn);
        exit = findViewById(R.id.bexodos);

        DB = new DBHelper(this);

        synexeia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(MainActivity.this,synexeia.class);
                startActivity(intent);


            }
        });

        neo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,New_game.class);
                startActivity(intent);




            }
        });







        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        });





    }
}