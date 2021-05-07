package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Trainingdata extends AppCompatActivity {

    Button addbutton, viewall;
    EditText exercisename, exercisesets, exercisereps, duration;
    Switch exhausted;
    ListView exerciseList;
    TextView back;
    ArrayAdapter fitnessArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainingdata);
        back = (TextView) findViewById(R.id.back);
        exercisename = (EditText) findViewById(R.id.exercisename);
        exercisesets = (EditText) findViewById(R.id.exercisesets);
        exercisereps = (EditText) findViewById(R.id.exercisereps);
        duration = (EditText) findViewById(R.id.duration);
        exhausted = (Switch) findViewById(R.id.exhausted);
        exerciseList = (ListView) findViewById(R.id.exerciseList);
        addbutton = (Button) findViewById(R.id.addbutton);
        viewall = (Button) findViewById(R.id.viewall);

        //button Listener
        addbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ExerciseData exerciseData;
                try {
                    exerciseData = new ExerciseData(-1,exercisename.getText().toString(),  Integer.parseInt(exercisesets.getText().toString()), Integer.parseInt(exercisereps.getText().toString()), duration.getText().toString(),exhausted.isChecked());
                    Toast.makeText(Trainingdata.this, exerciseData.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e) {
                    Toast.makeText(Trainingdata.this,"Error invalid inputs", Toast.LENGTH_SHORT).show();
                    exerciseData = new ExerciseData(-1, "Error", 0, 0, "Error", false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(Trainingdata.this);
                boolean success = dataBaseHelper.addOne(exerciseData);

                Toast.makeText(Trainingdata.this,"Success=" + success, Toast.LENGTH_SHORT).show();
            }
        });
        viewall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(Trainingdata.this);
                List<ExerciseData> fitnessdata = dataBaseHelper.getData();
                //Toast.makeText(Trainingdata.this, fitnessdata.toString(), Toast.LENGTH_SHORT).show();

                fitnessArrayAdapter = new ArrayAdapter<ExerciseData>(Trainingdata.this, R.layout.list_white_text, fitnessdata);
                exerciseList.setAdapter(fitnessArrayAdapter);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Trainingdata.this, StartWorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}