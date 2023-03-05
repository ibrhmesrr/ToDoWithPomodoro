package com.verimol.todowithpomodoro;

import android.database.Cursor;

import java.util.ArrayList;

public class GroupListDecoder {

    int length;
    String[] array;

    public GroupListDecoder(Cursor cursor){
        this.length = cursor.getCount();
        this.array = new String[length];


        if (cursor.moveToFirst()) {
            for (int i = 0; i < length; i++) {

                array[i] = cursor.getString(cursor.getColumnIndex("topic"));

           cursor.moveToNext();
            }
        }

    }



}
