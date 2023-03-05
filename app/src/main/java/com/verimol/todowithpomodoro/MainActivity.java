package com.verimol.todowithpomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Spinner spinner_groups;
    ListView listview_items;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new Database(getApplicationContext());

        spinner_groups=findViewById(R.id.spinner_groups);
        listview_items=findViewById(R.id.listview_items);


        GroupListDecoder groupListDecoder = new GroupListDecoder(database.getData("SELECT DISTINCT topic FROM dataTable"));
        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,groupListDecoder.array);
        spinner_groups.setAdapter(arrayAdapter);


       spinner_groups.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               getTextList();
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });




    }

    public void getTextList(){

        DatabaseControl databaseControl = new DatabaseControl(database.getData("SELECT * FROM dataTable WHERE topic=\""+spinner_groups.getSelectedItem().toString()+"\""));
        ArrayAdapter arrayAdapter2=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,databaseControl.text);
        listview_items.setAdapter(arrayAdapter2);

    }



}