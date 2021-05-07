package com.example.fitnessapp;

public class ExerciseData {
    private int id;
    private String name;
    private int sets;
    private int reps;
    private String duration;
    private boolean exhausted;

    public ExerciseData(int id, String name, int sets, int reps, String duration, boolean exhausted) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.duration = duration;
        this.exhausted = exhausted;
    }

    public ExerciseData() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean isExhausted() {
        return exhausted;
    }

    public void setExhausted(boolean exhausted) {
        this.exhausted = exhausted;
    }

    @Override
    public String toString() {
        return "Exercise = " + name +
                ", Sets = " + sets +
                ", Reps = " + reps +
                ", " + duration  + " minutes," +
                " exhausting = " + exhausted;
    }
}
