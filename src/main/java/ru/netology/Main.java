package ru.netology;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "new_data.json";
        String json = readString(fileName);

        List<Employee> list = jsonToList(json);
        System.out.println(list.toString());
    }

    private static List<Employee> jsonToList(String json) {
        List<Employee> employeeList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(json);
            JSONArray jsonArray = (JSONArray) obj;

            GsonBuilder builder = new GsonBuilder();
 //           builder.setPrettyPrinting();
            Gson gson = builder.create();

            Type listType = new TypeToken<List<Employee>>() {
            }.getType();


            for (int i = 0; i < jsonArray.size(); i++) {

                Employee employee = gson.fromJson((String) jsonArray.get(i), listType);
                employeeList.add(employee);
            }

            return employeeList;
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static String readString(String s) {
        try (BufferedReader br = new BufferedReader(new FileReader(s))) {

//            Object o = new JSONParser().parse(br);
//            JSONObject jsonString = (JSONObject) o;
//            System.out.println(jsonString);

            String temp;
            String jsonString = "";
            while ((temp = br.readLine()) != null) {
                jsonString = jsonString + temp;
            }
            return jsonString;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }
}

