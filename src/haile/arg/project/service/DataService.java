package haile.arg.project.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import haile.arg.project.model.House;

public class DataService {

  private static final int PERSONPROPLENGTH = 9;

  private static final String HOMEDATAFILE = "home_data.json";

  private static final String ERRORLOGFILE = "error_log";

  public static List<House> readHomedataJSON() {

    List<House> myReturnArrayList = new ArrayList<>();

    try {

      Object obj = new JSONParser().parse(new FileReader(HOMEDATAFILE));

      JSONArray arr = (JSONArray) obj;

      for (Object arrObj : arr) {

        JSONObject jo = (JSONObject) arrObj;

        String street_address = (String) jo.get("street_address");
        String street_suffix = (String) jo.get("street_suffix");
        String city = (String) jo.get("city");
        String state = (String) jo.get("state");
        String zip = (String) jo.get("zip");
        int bedrooms = Integer.parseInt(String.valueOf(jo.get("bedrooms")));
        int bathrooms = Integer.parseInt(String.valueOf(jo.get("bathrooms")));
        double sqft = Double.parseDouble(String.valueOf(jo.get("sqft")));
        double price = Double.parseDouble(String.valueOf(jo.get("price")));

        try {
          myReturnArrayList
              .add(new House(street_address, street_suffix, city, state, zip, bedrooms, bathrooms, sqft, price));
        } catch (Exception e) {
          logExceptions(e.getMessage() + ". This issue was found for " + street_address + ", " + street_suffix);
        }

      }

    } catch (IOException | ParseException e) {
      logExceptions(e.getMessage());

    }

    return myReturnArrayList;
  }

  /**
   * This method logs an exception message to an error log file.
   * 
   * @param error_msg the error message to be logged to the error log file.
   */
  public static void logExceptions(String error_msg) {

    FileWriter fileWriter = null;
    try {
      File errorFile = new File(ERRORLOGFILE);
      errorFile.createNewFile();
      fileWriter = new FileWriter(errorFile, true);
      PrintWriter printWriter = new PrintWriter(fileWriter);

      printWriter.println(error_msg);

      printWriter.close();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
