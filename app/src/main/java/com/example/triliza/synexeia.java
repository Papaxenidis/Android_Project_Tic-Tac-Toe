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

public class synexeia extends AppCompatActivity {


    Button b,b1;

    EditText gamename;
    TextView textView;

    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synexeia);



        textView = findViewById(R.id.textView5);
        DB = new DBHelper(this);
        b = findViewById(R.id.telosid);
        gamename = findViewById(R.id.edtextname);




        String[] arraystoixeia = new String[6];





        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = DB.getdata2();
                if(res.getCount() == 0)
                {
                    Toast.makeText(synexeia.this, "Δεν υπάρχουν δεδομένα.", Toast.LENGTH_SHORT).show();
                    return;


                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("ΕΠΙΚΕΦΑΛΙΔΑ :" + res.getString(0)+"\n");

                    buffer.append("ΠΑΙΚΤΗΣ Χ : " + res.getString(1)+"\n");
                    buffer.append("ΠΑΙΚΤΗΣ Ο : " + res.getString(2)+"\n");
                    buffer.append("ΝΊΚΕΣ Χ : " + res.getString(3)+"\n");
                    buffer.append("ΝΙΚΕΣ Ο : " + res.getString(4)+"\n");

                    buffer.append("Σειρά : " + res.getString(5)+"\n\n");




                }

                AlertDialog.Builder builder = new AlertDialog.Builder(synexeia.this);
                builder.setCancelable(true);
                builder.setTitle("ΠΙΝΑΚΑΣ ΑΠΟΤΕΛΕΣΜΑΤΩΝ");
                builder.setMessage(buffer.toString());
                builder.show();






            }
        });





        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name = gamename.getText().toString();
                Cursor res = DB.getdata(name);


                if(name.isEmpty())
                {
                    gamename.setError("Υποχρεωτικό πεδίο");
                    gamename.requestFocus();
                }else if(res.getCount() == 0)
                {
                    gamename.setError("Δεν υπάρχουν εγγραφές με το δεδομένο όνομα");
                    gamename.requestFocus();


                }
                else {

                    while (res.moveToNext())
                    {
                        arraystoixeia[0] = res.getString(0);
                        arraystoixeia[1] = res.getString(1);
                        arraystoixeia[2] = res.getString(2);
                        arraystoixeia[3] = res.getString(3);
                        arraystoixeia[4] = res.getString(4);
                        arraystoixeia[5] = res.getString(5);

                    }


                    Intent intent = new Intent(synexeia.this,Trilizaoficial.class);


                    intent.putExtra("timi",1);

                    intent.putExtra("stoixeia",arraystoixeia);
                    startActivity(intent);



                }








            }
        });







    }
}