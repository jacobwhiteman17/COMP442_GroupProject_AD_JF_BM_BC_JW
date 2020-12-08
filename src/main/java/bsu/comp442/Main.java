package bsu.comp442;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class Main {//I am running all this through main just to test things atm. Once I get things working, I will make a controller


    public static void main(String[] args)
    {
        Controller c = new Controller();
        c.runClass();
    }

    public JSONObject getRandomObject(JSONArray jsonArray)
    {
        Random random = new Random();
        return jsonArray.getJSONObject(random.nextInt(jsonArray.length()));
    }

}
