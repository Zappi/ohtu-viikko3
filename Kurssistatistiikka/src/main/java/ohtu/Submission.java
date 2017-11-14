package ohtu;

import java.util.Arrays;
import java.util.stream.*;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private int max;

    public void setWeek(int week, int hours, int[] exercises) {
        this.week = week;
        this.hours = hours;
        this.exercises = exercises;
    }
    
    public void setMax(int max) {
        this.max = max;
    }
    
    public int getMax() {
        return this.max;
    }
    
    public int getHours() {
        return this.hours;
    }
    
    public int countExercises() {
        return exercises.length;
    }
    
    public StringBuilder getExercises() {
        StringBuilder sb = new StringBuilder();
        IntStream stream = Arrays.stream(exercises);
        stream.forEach(x -> sb.append(x + " "));
        return sb;
    }

    public int getWeek() {
        return week;
    }
    
    

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + countExercises() + 
                " (maksimi " + getMax() +"), aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + getExercises();        
    }    
}