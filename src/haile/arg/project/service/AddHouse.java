package haile.arg.project.service;

import java.io.FileWriter;
import java.util.List;

import haile.arg.project.model.House;

/**
 * * The AddNewHouse method takes in parameters that are used to create a new
 * House object, and adds it to the houseData list. It performs various
 * validations to ensure that the input data is valid before adding the new
 * House object to the list. If any validation fails, an appropriate error
 * message is returned. The houseData list is then converted to a JSON string
 * and written to the home_data.json file.
 * 
 * @author Haile Arg
 * @version 30/04/2023
 *
 */
public class AddHouse {

  /**
   * This constructor defines the details of the House to be added by the user
   * 
   * @precondition street_address!=null && !street_address.isEmpty() &&
   *               street_suffix!=null && !street_suffix.isEmpty() && !
   *               street_suffix.contains(" ") && city!=null && !city.isEmpty() &&
   *               zip >=0 && zipLength = 5 && bedrooms>=0 && bathrooms >=0 &&
   *               sqft>=0 && price>=0
   * 
   * @postcondition getStreetAddress()==street_address &&
   *                getStreetSuffix()==street_suffix;e && getCity()==city; &&
   *                getZip()==zip; && getBedrooms()==bedrooms &&
   *                getBathrooms()==bathrooms && getSqft()==sqft &&
   *                getPrice()==price
   * @param houseData     the list of existing House objects
   * @param street_suffix the suffix of the street address
   * @param city          the city where the house is located
   * @param state         the state where the house is located
   * @param zip           the zip code of the area where the house is located
   * @param bedrooms      the number of bedrooms in the house
   * @param bathrooms     the number of bathrooms in the house
   * @param sqft          the size of the house in square foot
   * @param price         the price of the house
   * @return a message indicating whether the operation was successful or not
   */
  public static String AddNewHouse(List<House> houseData, String street_address, String street_suffix, String city,
      String state, String zip, int bedrooms, int bathrooms, double sqft, double price) {
    String message = "True";
    if ((street_address == null) || (street_address.isEmpty())) {
      return "The streetAddress must not be null or empty.";

    }
    if ((street_suffix == null) || (street_suffix.isEmpty()) || street_suffix.contains(" ")) {
      return "The streetSuffix must not be null or empty or empty or contain any whitespace characters.";
    }
    if ((city == null) || (city.isEmpty())) {
      return "The city must not be null or empty or empty";
    }
    if ((state == null) || (state.isEmpty()) || state.contains(" ")) {
      return "The state must not be null or empty or empty or contain any whitespace characters.";
    }
    if (Integer.parseInt(zip) < 0) {
      return "The zip code cannot be a negative number";
    }
    if (zip.length() != 5) {
      return "The zip code should have exactly 5 digits";
    }
    if (bedrooms <= 0) {
      return "bedrooms can not be less than zero";
    }

    if (bathrooms <= 0) {
      return "bathrooms can not be less than or equals to zero";
    }

    if (sqft <= 0) {
      return "sqft can not be less than or equals to zero";
    }

    if (price <= 0) {
      return "price can not be less than or equals to zero";
    }

    // List<House> houseData = DataService.readHomedataJSON();
    House newHouse = new House(street_address, street_suffix, city, state, zip, bedrooms, bathrooms, sqft, price);
    houseData.add(newHouse);

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");

    for (House element : houseData) {

      stringBuilder.append("{").append('"').append("street_address").append('"').append(':').append('"')
          .append(element.getStreetAddress()).append('"').append(",").append('"').append("street_suffix").append('"')
          .append(':').append('"').append(element.getStreetSuffix()).append('"').append(",").append('"').append("city")
          .append('"').append(':').append('"').append(element.getCity()).append('"').append(",").append('"')
          .append("state").append('"').append(':').append('"').append(element.getState()).append('"').append(",")
          .append('"').append("zip").append('"').append(':').append('"').append(element.getZip()).append('"')
          .append(",").append('"').append("bedrooms").append('"').append(':').append(element.getBedrooms()).append(",")
          .append('"').append("bathrooms").append('"').append(':').append(element.getBathrooms()).append(",")
          .append('"').append("sqft").append('"').append(':').append(element.getSqft()).append(",").append('"')
          .append("price").append('"').append(':').append(element.getPrice()).append("}").append(",").append("\n");

    }

    stringBuilder.append("]");

    try (FileWriter fileWriter = new FileWriter("home_data.json")) {
      fileWriter.write(stringBuilder.toString());

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return message;

  }
}
