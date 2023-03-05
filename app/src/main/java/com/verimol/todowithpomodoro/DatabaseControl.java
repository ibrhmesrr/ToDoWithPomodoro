package com.verimol.todowithpomodoro;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class DatabaseControl {

    int length;

    int[] id;
    int[] pomodoro;
    int[] date;
    int[] status;

    String[] text;
    String[] topic;


    public DatabaseControl(Cursor cursor){

        this.length = cursor.getCount();
        this.id = new int[length];
        this.pomodoro =new int[length];
        this.date= new int[length];
        this.status= new int[length];

        this.text= new String[length];
        this.topic= new String[length];


        if (cursor.moveToFirst()) {
            for (int i = 0; i < length; i++) {


                id[i] = cursor.getInt(cursor.getColumnIndex("id"));
                pomodoro[i] = cursor.getInt(cursor.getColumnIndex("pomodoro"));
                date[i] = cursor.getInt(cursor.getColumnIndex("date"));
                status[i] = cursor.getInt(cursor.getColumnIndex("status"));
                text[i] = cursor.getString(cursor.getColumnIndex("text"));
                topic[i] = cursor.getString(cursor.getColumnIndex("topic"));

                cursor.moveToNext();

            }
        }

    }

}
