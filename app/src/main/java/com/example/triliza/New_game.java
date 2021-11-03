package com.example.triliza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.sax.TemplatesHandler;

public class New_game extends AppCompatActivity {

    EditText t1,t2,nameofgame;

    DBHelper DB;


    Button okey;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);



        nameofgame = findViewById(R.id.gamen);
        t1 = findViewById(R.id.ed1);
        t2 = findViewById(R.id.ed2);


        DB = new DBHelper(this);
        okey = findViewById(R.id.bokey);


        okey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nofg = nameofgame.getText().toString();
                String prwto = t1.getText().toString();
                String deutero = t2.getText().toString();


                if(nofg.isEmpty())
                {
                    nameofgame.setError("Υποχρεωτικό πεδίο");
                    nameofgame.requestFocus();
                }else if(prwto.isEmpty())
                {
                    t1.setError("Υποχρεωτικό πεδίο");
                    t1.requestFocus();
                }else if(deutero.isEmpty())
                {
                    t2.setError("Υποχρεωτικό πεδίο");
                    t2.requestFocus();
                }




                 String s1 = "0";
                 String s2 = "0";
                 String gir = "15000";



                String[] arxiko = {nofg,prwto,deutero,"0","0","15000"};



                Boolean up = DB.insertuserdata(nofg,prwto,deutero,s1,s2,gir);
                if(up)
                {
                    Toast.makeText(New_game.this, "Επιτυχής εγγραφή", Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(New_game.this, "Η εγγραφή απέτυχε προσπαθήστε ξανά", Toast.LENGTH_SHORT).show();
                }


                Intent intent = new Intent(New_game.this,Trilizaoficial.class);
               /* intent.putExtra("nof",nofg);
                intent.putExtra("Onoma1",prwto);
                intent.putExtra("Onoma2",deutero);
                intent.putExtra("timi",0);*/

                intent.putExtra("stoixeia",arxiko);
                startActivity(intent);














            }
        });









    }
}