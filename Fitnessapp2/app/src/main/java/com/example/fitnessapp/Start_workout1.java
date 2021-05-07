package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class Start_workout1 extends AppCompatActivity {

    TextView intropage, title, back, firstex, secondex, thirdex, forthex, fifthex, sixthex, seventhex;
    LinearLayout fitone;
    View startButton, divpage, divpagetwo;

    /*Spinner spinner = findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.exerciseone, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setApdapter(adapter);
    spinner.setOnItemSelectedListener(this);
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout1);

        intropage = (TextView) findViewById(R.id.intropage);
        title = (TextView) findViewById(R.id.title);
        firstex = (TextView) findViewById(R.id.firstex);
        secondex = (TextView) findViewById(R.id.secondex);
        thirdex = (TextView) findViewById(R.id.thirdex);
        forthex = (TextView) findViewById(R.id.forthex);
        fifthex = (TextView) findViewById(R.id.fifthex);
        sixthex = (TextView) findViewById(R.id.sixthex);
        seventhex = (TextView) findViewById(R.id.seventhex);
        back = (TextView) findViewById(R.id.back);

        fitone = (LinearLayout) findViewById(R.id.fitone);

        //Auf die nächste Seite weiterleiten
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Start_workout1.this, WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        firstex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        secondex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        thirdex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        forthex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        fifthex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        sixthex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

        seventhex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    public void openActivity(){
        /*TextView textView1 = (TextView) findViewById(R.id.firstex);
        String text = textView1.getText().toString();
        */
        Intent intent = new Intent(this, Trainingdata.class);
        startActivity(intent);
    }
}