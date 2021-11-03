package com.example.triliza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{



    public DBHelper(Context context) {
        super(context,"TRILIZA_DATABASE.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        DB.execSQL("create Table PL2(gnm TEXT primary key,on1 TEXT, on2 TEXT, sc1 TEXT,sc2 TEXT,prot TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {

        DB.execSQL("DROP TABLE IF EXISTS PL2");

    }


    //INSERT ννννΛΕΙΤΟΥΡΓΕΙ νννν
    public Boolean insertuserdata(String gamename,String name1, String name2, String score1,String score2,String gires) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("gnm",gamename);
        contentValues.put("on1", name1);
        contentValues.put("on2", name2);
        contentValues.put("sc1", score1);
        contentValues.put("sc2", score2);
        contentValues.put("prot", gires);



        long result = DB.insert("PL2", null, contentValues);//EDW

        if (result == -1) {
            return false;
        } else {
            return true;
        }




    }


    //UPDATE
    public Boolean updateuserdata(String gamename,String name1, String name2,String score1,String score2,String gires) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("gnm",gamename);
        contentValues.put("on1", name1);
        contentValues.put("on2", name2);
        contentValues.put("sc1", score1);
        contentValues.put("sc2", score2);
        contentValues.put("prot", gires);





        Cursor cursor = DB.rawQuery("SELECT * FROM PL2 WHERE gnm = ?", new String[]{gamename});//κριτηριο το όνομα
        if (cursor.getCount() > 0) {

            long result = DB.update("PL2", contentValues, "gnm=?", new String[]{gamename});


            DB.close();

            if (result == -1) {
                return false;

            }else {
                return true;
            }


        }else {


            return false;
        }




    }





    //DISPLAY
    public Cursor getdata(String gamename) {


        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.rawQuery("SELECT * FROM PL2 WHERE gnm= ?", new String[]{gamename});

        return cursor;



    }


    public Cursor getdata2() {


        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.rawQuery("select * from PL2 ", null);


        return cursor;



    }



}

