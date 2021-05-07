package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String FITNESS_TABLE = "FITNESS_TABLE";
    public static final String COLUMN_EXERCISE_NAME = "EXERCISE_NAME";
    public static final String COLUMN_EXERCISE_SETS = "EXERCISE_SETS";
    public static final String COLUMN_EXERCISE_REPETITIONS = "EXERCISE_REPETITIONS";
    public static final String COLUMN_EXERCISE_DURATION = "EXERCISE_DURATION";
    public static final String COLUMN_EXHAUSTING = "EXHAUSTING";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "fitness.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + FITNESS_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EXERCISE_NAME + " TEXT, " + COLUMN_EXERCISE_SETS + " INT, " + COLUMN_EXERCISE_REPETITIONS + " INT, " + COLUMN_EXERCISE_DURATION + " TEXT, " + COLUMN_EXHAUSTING + " BOOL)";
        db.execSQL(createTableStatement);
    }

    public boolean addOne(ExerciseData exerciseData){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EXERCISE_NAME, exerciseData.getName());
        cv.put(COLUMN_EXERCISE_SETS, exerciseData.getSets());
        cv.put(COLUMN_EXERCISE_REPETITIONS, exerciseData.getReps());
        cv.put(COLUMN_EXERCISE_DURATION, exerciseData.getDuration());
        cv.put(COLUMN_EXHAUSTING, exerciseData.isExhausted());
        long insert = db.insert(FITNESS_TABLE, COLUMN_EXERCISE_NAME, cv);

       if (insert == -1) {
           return false;
       }
       else return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<ExerciseData> getData(){
        List<ExerciseData> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + FITNESS_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int ExerciseId = cursor.getInt(0);
                String ExerciseName = cursor.getString(1);
                int ExerciseSets = cursor.getInt(2);
                int ExerciseReps = cursor.getInt(3);
                String ExerciseDuration = cursor.getString(4);
                boolean exhausting = cursor.getInt(5) == 1 ? true: false;

                ExerciseData newExerciseData = new ExerciseData(ExerciseId, ExerciseName, ExerciseSets,ExerciseReps,ExerciseDuration,exhausting);
                returnList.add(newExerciseData);
            }
            while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }

    // Durch den queryString wird ein SQL Statement aufgerufen, welches den Eintrag aus der Tabelle löscht, der die selbe ID besitzt wie das gegebene Objekt
    public boolean deleteOne(ExerciseData exerciseData){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString ="DELETE FROM " + FITNESS_TABLE + " WHERE " + COLUMN_ID + " = " + exerciseData.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            return true;
        }
        else return false;
    }

    // Sortiert die Tabelle mithilfe des SQL Statements und gibt die sortierte Liste zurück, dabei wird jedes einzelne Element erstellt und dann der Liste hinzugefügt
    public List<ExerciseData> sort(){
        List<ExerciseData> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + FITNESS_TABLE + " ORDER BY " + COLUMN_EXERCISE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int ExerciseId = cursor.getInt(0);
                String ExerciseName = cursor.getString(1);
                int ExerciseSets = cursor.getInt(2);
                int ExerciseReps = cursor.getInt(3);
                String ExerciseDuration = cursor.getString(4);
                boolean exhausting = cursor.getInt(5) == 1 ? true: false;

                ExerciseData newExerciseData = new ExerciseData(ExerciseId, ExerciseName, ExerciseSets,ExerciseReps,ExerciseDuration,exhausting);
                returnList.add(newExerciseData);
            }
            while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }

    public List<ExerciseData> sort1(){
        List<ExerciseData> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + FITNESS_TABLE + " ORDER BY " + COLUMN_EXERCISE_SETS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int ExerciseId = cursor.getInt(0);
                String ExerciseName = cursor.getString(1);
                int ExerciseSets = cursor.getInt(2);
                int ExerciseReps = cursor.getInt(3);
                String ExerciseDuration = cursor.getString(4);
                boolean exhausting = cursor.getInt(5) == 1 ? true: false;

                ExerciseData newExerciseData = new ExerciseData(ExerciseId, ExerciseName, ExerciseSets,ExerciseReps,ExerciseDuration,exhausting);
                returnList.add(newExerciseData);
            }
            while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }

    public List<ExerciseData> sort2(){
        List<ExerciseData> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + FITNESS_TABLE + " ORDER BY " + COLUMN_EXERCISE_REPETITIONS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int ExerciseId = cursor.getInt(0);
                String ExerciseName = cursor.getString(1);
                int ExerciseSets = cursor.getInt(2);
                int ExerciseReps = cursor.getInt(3);
                String ExerciseDuration = cursor.getString(4);
                boolean exhausting = cursor.getInt(5) == 1 ? true: false;

                ExerciseData newExerciseData = new ExerciseData(ExerciseId, ExerciseName, ExerciseSets,ExerciseReps,ExerciseDuration,exhausting);
                returnList.add(newExerciseData);
            }
            while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }

    public List<ExerciseData> sort3(){
        List<ExerciseData> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + FITNESS_TABLE + " ORDER BY " + COLUMN_EXERCISE_DURATION;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()) {
            do {
                int ExerciseId = cursor.getInt(0);
                String ExerciseName = cursor.getString(1);
                int ExerciseSets = cursor.getInt(2);
                int ExerciseReps = cursor.getInt(3);
                String ExerciseDuration = cursor.getString(4);
                boolean exhausting = cursor.getInt(5) == 1 ? true: false;

                ExerciseData newExerciseData = new ExerciseData(ExerciseId, ExerciseName, ExerciseSets,ExerciseReps,ExerciseDuration,exhausting);
                returnList.add(newExerciseData);
            }
            while (cursor.moveToNext());
        }
        else {

        }

        cursor.close();
        db.close();
        return returnList;
    }
}


