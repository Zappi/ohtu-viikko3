package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.Iterator;
import org.apache.http.client.fluent.Request;

public class Main {

    private static int allExercises = 0;
    private static int totalHours = 0;

    public static void main(String[] args) throws IOException {

        String studentNr = "011120775";

        if (args.length > 0) {
            studentNr = args[0];
        }
        
        System.out.println(getClassInfo());
        int week = 0;
        
        System.out.println("Opiskelijanumero: " + studentNr+"\n");
        
        for (Submission submission : getStudentInfo(studentNr)) {
            submission.setMax(getClassInfo().getMaxExercises(week));
            System.out.println(submission);
            week++;
        }
        
        System.out.println(getFullInfo());
        

    }

    public static Submission[] getStudentInfo(String studentNr) throws IOException {

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
 
       return subs;

    }

    public static CourseInfo getClassInfo() throws IOException {

        String url = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        Gson mapper = new Gson();
        CourseInfo courseInfo = mapper.fromJson(bodyText, CourseInfo.class);
        return courseInfo;
    }

    public static String getFullInfo() throws IOException {
        
        String url = "https://studies.cs.helsinki.fi/ohtustats/stats";
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        JsonParser parser = new JsonParser();
        JsonObject parsedData = parser.parse(bodyText).getAsJsonObject();
     
        int students = 0;
        int exerciseTotal = 0;
        
        for (int i = 1; i <= parsedData.size()-1; i++) {
            String a = i+"";
            System.out.println(a);
            students+= parsedData.get(a).getAsJsonObject().get("students").getAsInt();
            exerciseTotal+=parsedData.get(a).getAsJsonObject().get("exercise_total").getAsInt();
        }

        
        return "Kurssilla yhteensä " + students + " palautusta, palautettuja tehtäviä " + exerciseTotal;
        
    }
}
