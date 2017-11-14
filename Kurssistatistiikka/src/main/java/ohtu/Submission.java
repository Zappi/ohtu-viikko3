package ohtu;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;

    public void setWeek(int week, int hours, int[] exercises) {
        this.week = week;
        this.hours = hours;
        this.exercises = exercises;
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
                ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + getExercises() 
                ;
    }
    
}