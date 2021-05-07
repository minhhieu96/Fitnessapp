package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DataList extends AppCompatActivity {

    Button deletebutton, sort;
    ListView exerciseList;
    TextView back;
    ArrayAdapter fitnessArrayAdapter;
    DataBaseHelper dataBaseHelper;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        back = (TextView) findViewById(R.id.back);
        exerciseList = (ListView) findViewById(R.id.exerciseList);
        deletebutton = (Button) findViewById(R.id.deletebutton);
        sort = (Button) findViewById(R.id.sort);

        //Database init
        dataBaseHelper = new DataBaseHelper(DataList.this);
        fitnessArrayAdapter = new ArrayAdapter<ExerciseData>(DataList.this, R.layout.list_white_text, dataBaseHelper.getData());
        exerciseList.setAdapter(fitnessArrayAdapter);

        //button Listener
        sort.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(counter){
                    case 0:
                    fitnessArrayAdapter = new ArrayAdapter<ExerciseData>(DataList.this, R.layout.list_white_text, dataBaseHelper.sort());
                    exerciseList.setAdapter(fitnessArrayAdapter);
                    counter++;
                        Toast.makeText(DataList.this,"Sorted by Exercise Name", Toast.LENGTH_SHORT).show();
                    break;
                    case 1:
                        fitnessArrayAdapter = new ArrayAdapter<ExerciseData>(DataList.this, R.layout.list_white_text, dataBaseHelper.sort1());
                        exerciseList.setAdapter(fitnessArrayAdapter);
                        counter++;
                        Toast.makeText(DataList.this,"Sorted by Sets", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        fitnessArrayAdapter = new ArrayAdapter<ExerciseData>(DataList.this, R.layout.list_white_text, dataBaseHelper.sort2());
                        exerciseList.setAdapter(fitnessArrayAdapter);
                        counter++;
                        Toast.makeText(DataList.this,"Sorted by Repetitions", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        fitnessArrayAdapter = new ArrayAdapter<ExerciseData>(DataList.this, R.layout.list_white_text, dataBaseHelper.sort3());
                        exerciseList.setAdapter(fitnessArrayAdapter);
                        counter=0;
                        Toast.makeText(DataList.this,"Sorted by Duration", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               exerciseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       ExerciseData clickedExerciseData = (ExerciseData) parent.getItemAtPosition(position);
                       dataBaseHelper.deleteOne(clickedExerciseData);
                       fitnessArrayAdapter = new ArrayAdapter<ExerciseData>(DataList.this, R.layout.list_white_text, dataBaseHelper.getData());
                       exerciseList.setAdapter(fitnessArrayAdapter);
                       Toast.makeText(DataList.this,"Data sucessfully deleted", Toast.LENGTH_SHORT).show();
                   }
               });
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DataList.this, MainActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}