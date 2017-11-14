package ohtu;

public class CourseInfo {
    
    private String name;
    private String term;
    private int[] exercises;
    
    public CourseInfo(String name, String term, int[] exercises) {
        this.name = name;
        this.term = term;
        this.exercises = exercises;
    }
    
    public int countExercises() {
        return exercises.length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
    
    public int getMaxExercises(int week) {
        return exercises[week];
    }
    
    @Override
    public String toString() {
        return "Kurssi: " + name + ", " + term;
    }
    
}
