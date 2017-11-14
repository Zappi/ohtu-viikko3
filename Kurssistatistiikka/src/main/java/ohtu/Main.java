package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;


public class Main {
    
    private static int allExercises = 0;
    private static int totalHours = 0;

    public static void main(String[] args) throws IOException {

        String studentNr = "12345";

        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";
        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        System.out.println("json-muotoinen data");
        System.out.println(bodyText);
        
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        System.out.println("Oliot");
        for (Submission sub : subs) {
            System.out.println(sub);
            allExercises+=sub.countExercises();
            totalHours+=sub.getHours();
        }
        
        System.out.println("\nyhteensä " + allExercises + " tehtävää "+
                totalHours + " tuntia");
        
    }
}
