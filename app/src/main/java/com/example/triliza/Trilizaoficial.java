package com.example.triliza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Trilizaoficial extends AppCompatActivity implements View.OnClickListener {

    Button but1,but2,but3,but4,but5,but6,but7,but8,but9,button,buttonpast,buttB;
    Button seira;

    TextView textView;

//ΌΛΑ αυτά μεταφέρονται
    String teliko_xrwma = " ";
    String nameofgame = "";
    String OnomaX = "";
    String OnomaY= "";
    String play ="";





    int temp_id = 0;
    int times_general = 1;
    int times = 1 ;
    int id=0;



    boolean koumpi = false;
    boolean niki = false;



    String xrwma;

    HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trilizaoficial);



        textView = findViewById(R.id.seiraexei);

        String[] synex_stoixeia = getIntent().getStringArrayExtra("stoixeia");



        if(synex_stoixeia[5].equals("X")||synex_stoixeia[5].equals("15000"))
        {
            textView.setText("X");
            play = "X";

        }else if(synex_stoixeia[5].equals("O"))
        {
            textView.setText("O");
            play = "O";


        }



        nameofgame = synex_stoixeia[0];
        OnomaX = synex_stoixeia[1];
        OnomaY = synex_stoixeia[2];







        but1 = findViewById(R.id.b1);
        but2 = findViewById(R.id.b2);
        but3 = findViewById(R.id.b3);
        but4 = findViewById(R.id.b4);
        but5 = findViewById(R.id.b5);
        but6 = findViewById(R.id.b6);
        but7 = findViewById(R.id.b7);
        but8 = findViewById(R.id.b8);
        but9 = findViewById(R.id.b9);





        String[] timesstring = new String[9];


        seira = findViewById(R.id.btelos2);
        teliko_xrwma = textView.getText().toString();



        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
        but5.setOnClickListener(this);
        but6.setOnClickListener(this);
        but7.setOnClickListener(this);
        but8.setOnClickListener(this);
        but9.setOnClickListener(this);


        seira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              if (!koumpi) {

                    Toast.makeText(Trilizaoficial.this, "Πρέπει να επιλέξετε κελί!", Toast.LENGTH_SHORT).show();

                } else {

                    methodos(id);
                    metrisi(timesstring);


                    if (button.getText().equals("X")) {


                        textView.setText("O");
                        //button.setText("X");
                        times += 1;


                    } else if(button.getText().equals("O")) {


                        textView.setText("X");
                        //button.setText("O");

                        times += 1;


                    }
                    button.setClickable(false);
                }


                koumpi = false;

                if (times == 10)//Μεταφορα σε περιπτωση ισοπαλίας
                {
                    Intent intent = new Intent(Trilizaoficial.this, apotelesma.class);
                    intent.putExtra("Nof",nameofgame);
                    intent.putExtra("Onoma1",OnomaX);
                    intent.putExtra("Onoma2",OnomaY);
                    intent.putExtra("Neoxrwma",teliko_xrwma);
                    intent.putExtra("Apotelesmata","0");



                    try {
                        Thread.sleep(500);
                        startActivity(intent);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //edw tha mpei o kwdikas pou afora SQL πρέπει να συμπαιραίνει και αν


                } else if (niki)//μεταφορα σε περιπτωση νικης
                {
                    Intent intent = new Intent(Trilizaoficial.this, apotelesma.class);

                    if (xrwma.equals("X")) {
                        intent.putExtra("Apotelesmata", "1");

                    } else if (xrwma.equals("O")) {
                        intent.putExtra("Apotelesmata", "2"); //ΠΕΡΝΑ ΤΙΣ ΤΙΜΕΣ ΣΤΟ ΑΛΛΟ ΑΚΤΙΒΙΤΙ

                    }


                    if(teliko_xrwma.equals("X"))
                    {
                        teliko_xrwma = "O";
                    }else if(teliko_xrwma.equals("O"))
                    {
                        teliko_xrwma = "X";
                    }


                    intent.putExtra("Nof",nameofgame);
                    intent.putExtra("Onoma1",OnomaX);
                    intent.putExtra("Onoma2",OnomaY);
                    intent.putExtra("Neoxrwma",teliko_xrwma);



                    try {
                        Thread.sleep(500);
                        startActivity(intent);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }




                }






//edw


            }
        });





    }

    private void metrisi(String[] timesstring) {




        timesstring[0] = but1.getText().toString();
        timesstring[1] = but2.getText().toString();
        timesstring[2] = but3.getText().toString();
        timesstring[3] = but4.getText().toString();
        timesstring[4] = but5.getText().toString();
        timesstring[5] = but6.getText().toString();
        timesstring[6] = but7.getText().toString();
        timesstring[7] = but8.getText().toString();
        timesstring[8] = but9.getText().toString();


        nikitis(timesstring);








    }

    private void nikitis(String[] timesstring) {

        if(timesstring[0].equals(timesstring[1])&&timesstring[1].equals(timesstring[2])&&!timesstring[0].equals(""))
        {
            niki = true;
            xrwma = timesstring[0];




            but1.setBackgroundColor(Color.GREEN);
            but2.setBackgroundColor(Color.GREEN);
            but3.setBackgroundColor(Color.GREEN);

        }else if(timesstring[3].equals(timesstring[4])&&timesstring[4].equals(timesstring[5])&&!timesstring[3].equals(""))
        {
            niki = true;
            xrwma = timesstring[3];
            but4.setBackgroundColor(Color.GREEN);
            but5.setBackgroundColor(Color.GREEN);
            but6.setBackgroundColor(Color.GREEN);


        }else if(timesstring[6].equals(timesstring[7])&&timesstring[7].equals(timesstring[8])&&!timesstring[6].equals(""))
        {
            niki = true;
            xrwma = timesstring[6];
            but7.setBackgroundColor(Color.GREEN);
            but8.setBackgroundColor(Color.GREEN);
            but9.setBackgroundColor(Color.GREEN);

        }else if(timesstring[0].equals(timesstring[3])&&timesstring[3].equals(timesstring[6])&&!timesstring[0].equals(""))
        {
            niki = true;
            xrwma = timesstring[0];
            but1.setBackgroundColor(Color.GREEN);
            but4.setBackgroundColor(Color.GREEN);
            but7.setBackgroundColor(Color.GREEN);


        }else if(timesstring[1].equals(timesstring[4])&&timesstring[4].equals(timesstring[7])&&!timesstring[1].equals(""))
        {
            niki = true;
            xrwma = timesstring[1];
            but2.setBackgroundColor(Color.GREEN);
            but5.setBackgroundColor(Color.GREEN);
            but8.setBackgroundColor(Color.GREEN);

        }else if(timesstring[2].equals(timesstring[5])&&timesstring[5].equals(timesstring[8])&&!timesstring[2].equals(""))
        {
            niki = true;
            xrwma = timesstring[2];
            but3.setBackgroundColor(Color.GREEN);
            but6.setBackgroundColor(Color.GREEN);
            but9.setBackgroundColor(Color.GREEN);


        }else if(timesstring[0].equals(timesstring[4])&&timesstring[4].equals(timesstring[8])&&!timesstring[0].equals(""))
        {
            niki = true;
            xrwma = timesstring[0];
            but1.setBackgroundColor(Color.GREEN);
            but5.setBackgroundColor(Color.GREEN);
            but9.setBackgroundColor(Color.GREEN);


        }else if(timesstring[2].equals(timesstring[4])&&timesstring[4].equals(timesstring[6])&&!timesstring[2].equals(""))
        {
            niki = true;
            xrwma = timesstring[2];
            but5.setBackgroundColor(Color.GREEN);
            but7.setBackgroundColor(Color.GREEN);
            but3.setBackgroundColor(Color.GREEN);


        }




    }

    private void methodos(int id) {

        nums.put(id,id);


    }


    @Override
    public void onClick(View v) {


        button = findViewById(v.getId());
        id = v.getId();

        if(times_general==1)
        {
            temp_id=id;
            times_general=1000;
        }

        if(!nums.containsKey(v.getId()))
        {


            if(!nums.containsKey(temp_id))
            {
                buttonpast = findViewById(temp_id);
                buttonpast.setText("");
            }


            if(play.equals("X"))
            {
                if(times%2==1)
                {
                    button.setText(textView.getText().toString());

                    //x

                }else if(times%2==0)
                {
                    button.setText(textView.getText().toString());

                }
            }else if(play.equals("O"))
            {
                if(times%2==1)
                {
                    button.setText(textView.getText().toString());




                }else if(times%2==0)
                {
                    button.setText(textView.getText().toString());


                }
            }






            buttB = findViewById(id);

            play = buttB.getText().toString();

            if(play.equals("X"))
            {
                play="O";

            }else if(play.equals("O"))
            {
                play="X";

            }

            temp_id=id;
            koumpi=true;

        }







    }

    }


