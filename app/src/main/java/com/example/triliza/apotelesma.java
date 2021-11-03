package com.example.triliza;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class apotelesma extends AppCompatActivity {



    String vathX,vathO,prot;

    int vathXint,vathOint,protInt,apotelesmaInt;




    DBHelper DB;

    String ap,onoma1,onoma2,nof,teliko;

    Button barxiki,bxanapaixe;

    TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apotelesma);


        DB = new DBHelper(this);
        barxiki = findViewById(R.id.barxiki);
        bxanapaixe = findViewById(R.id.bpaixe);
        textView = findViewById(R.id.textView3);







        ap = getIntent().getStringExtra("Apotelesmata");//timi 1,2 h 0 ΔΕΝ ΑΛΛΑΖΕΙ1!!
        onoma1 = getIntent().getStringExtra("Onoma1");//onoma paikti X ΔΕΝ ΑΛΛΑΖΕΙ!!!
        onoma2 = getIntent().getStringExtra("Onoma2");//Onoma paikti O ΔΕΝ ΑΛΛΑΖΕΙ!!!!
        nof = getIntent().getStringExtra("Nof");//Name of game
        teliko = getIntent().getStringExtra("Neoxrwma");//to xrwma poy exei ston epomeno gyro proteraiotita




        if(ap.equals("1"))
        {
            textView.setText("Το X κερδίζει!");
        }else if(ap.equals("2"))
        {
            textView.setText("Το O κερδίζει!");

        }else
        {
            textView.setText("Το παιχνίδι έληξε ισόπαλο!");

        }




        barxiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = DB.getdata(nof);


                while (res.moveToNext())
                {

                    onoma1  = res.getString(1);
                    onoma2 = res.getString(2);

                    vathX = res.getString(3);
                    vathO = res.getString(4);
                    prot = res.getString(5);


                    apotelesmaInt = Integer.parseInt(ap);//Τις μετατρέπω σε ints
                    vathXint = Integer.parseInt(vathX);
                    vathOint = Integer.parseInt(vathO);






                    if(apotelesmaInt == 1)
                    {
                        vathXint+=1;

                    }else if(apotelesmaInt == 2)
                    {
                        vathOint+=1;
                    }


                    vathX = String.valueOf(vathXint); //ΣΤΟ 3
                    vathO = String.valueOf(vathOint); //ΣΤΟ 4


                }






                Boolean checkupdatedata = DB.updateuserdata(nof,onoma1,onoma2,vathX,vathO,teliko);

                if(!checkupdatedata)
                {
                    Toast.makeText(apotelesma.this, "Κάτι πήγε στραβά, η βάση δεν ανανεώθηκε", Toast.LENGTH_SHORT).show();

                }

                Intent intent = new Intent(apotelesma.this,MainActivity.class);
                startActivity(intent);



            }
        });

        bxanapaixe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = DB.getdata(nof);



                while (res.moveToNext())
                {
                    onoma1  = res.getString(1);
                    onoma2 = res.getString(2);
                    vathX = res.getString(3);
                    vathO = res.getString(4);
                    prot = res.getString(5);//παίρνω τιμες από την βάση(αυτες που θα χρειαστεί να λλάξουν)

                    apotelesmaInt = Integer.parseInt(ap);//Τις μετατρέπω σε ints
                    vathXint = Integer.parseInt(vathX);
                    vathOint = Integer.parseInt(vathO);



                    if(apotelesmaInt == 1)
                    {
                        vathXint+=1;

                    }else if(apotelesmaInt == 2)
                    {
                        vathOint+=1;
                    }


                    vathX = String.valueOf(vathXint); //ΣΤΟ 3
                    vathO = String.valueOf(vathOint); //ΣΤΟ 4


                }






                Boolean checkupdatedata = DB.updateuserdata(nof,onoma1,onoma2,vathX,vathO,teliko);

                if(!checkupdatedata)
                {
                    Toast.makeText(apotelesma.this, "Κάτι πήγε στραβά, η βάση δεν ανανεώθηκε", Toast.LENGTH_SHORT).show();

                }



                String[] ananeomeno = {nof,onoma1,onoma2,vathX,vathO,teliko};



                Intent intent = new Intent(apotelesma.this,Trilizaoficial.class);
                intent.putExtra("stoixeia",ananeomeno);
                startActivity(intent);





            }
        });












    }
}