package bsu.comp442;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

public class Controller {
    private String Title;
    private String Description;
    private String Contact;
    private int JobNo;


    public sJob getRandomObject(sJob[] arrayOfJobs)
    {
        Random rand = new Random();
        sJob next = arrayOfJobs[rand.nextInt(arrayOfJobs.length)];
        return next;
    }

    public void runClass()
    {
        var gson = new Gson();
        try(Reader reader = new FileReader("StudentJobs.json")){
            sJob[] data = gson.fromJson(reader, sJob[].class);
            var randomJob = getRandomObject(data);
            System.out.println(randomJob.getTitle()+"\n"+randomJob.getDescription());
            /*for(sJob jobs: data)
            {
                System.out.println(jobs.toString());
            }*/
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }



}
