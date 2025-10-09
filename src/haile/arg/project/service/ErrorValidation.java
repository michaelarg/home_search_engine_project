package haile.arg.project.service;

/**
 * This class contains static methods for validating various inputs.
 * 
 * @author Haile Arg
 * @version 30/04/2023
 */
public class ErrorValidation {

  /**
   * This method checks if the input string is a valid numeric value.
   * 
   * @param num the input string to be checked if it is numeric
   * @return true if the input string is numeric, false otherwise
   */
  public static boolean isNumeric(String num) {
    Double numValue;
    if (num == null || num.equals("")) {
      return false;
    }
    try {
      numValue = Double.parseDouble(num);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }

  }

  /**
   * Validates a street address string by checking if it is null or empty.
   * 
   * @param street_address the street address to be validated
   * @return a message prompting the user to specify the street address if it is
   *         null or empty, otherwise an empty string
   */
  public static String valiadateStreeAdress(String street_address) {
    if (street_address == null || street_address.equals("")) {
      return "Please specify Stree Address";
    }
    return "";
  }

  /**
   * This method validates if a street suffix is specified or not.
   * 
   * @param street_suffix The street suffix to validate
   * @return string containing an error message if the street suffix is invalid,
   *         or an empty string otherwise
   */
  public static String valiadateStreeSuffix(String street_suffix) {
    if (street_suffix == null || street_suffix.equals("")) {
      return "Please specify Stree Suffix";
    }
    return "";
  }

  /**
   * This method validates if the city is specified or not.
   * 
   * @param city a string representing the city name to be validated.
   * @return an error message asking to specify the city if it is null or empty,
   *         otherwise an empty string indicating that the city is valid.
   */
  public static String valiadateCity(String city) {
    if (city == null || city.equals("")) {
      return "Please specify Stree Suffix";
    }
    return "";
  }

  /**
   * This method Validates if the input state value is null or empty string.
   * 
   * @param state state the state value to be validated
   * @return an empty string if the state value is not null or empty
   */
  public static String valiadateState(String state) {
    if (state == null || state.equals("")) {
      return "Please specify state";
    }
    return "";
  }

  /**
   * This method validates the zip code entered by the user.
   * 
   * @param zip the zip code to be validated.
   * @return empty string if the zip code is valid, otherwise returns an error
   *         message.
   */
  public static String valiadateZip(String zip) {
    if (zip == null || zip.equals("")) {
      return "Please specify Zip Code";
    }
    if (zip.length() != 5) {
      return "The zip code should have exactly 5 digits";
    }
    return "";
  }

  /**
   * This method Validates the price value by checking if it is a numeric value
   * and not empty.
   * 
   * @param price the price value to validate.
   * @return an empty string if the price value is valid, otherwise an error
   *         message is returned.
   */
  public static String validatePrice(String price) {
    try {
      String error;

      if (price.length() < 1 || price == null) {
        error = "Please Insert  price";
        return error;
      }

      if (!isNumeric(price)) {
        error = "Please insert numeric value for price";
        return error;
      }

      return "";
    } catch (NumberFormatException e) {
      return "Please insert valide value";
    }
  }

  /**
   * This method validates the minimum and maximum price values provided by the
   * user.
   * 
   * @param min_Price The minimum price value to be validated.
   * @param max_Price The maximum price value to be validated.
   * @return An empty string if both minimum and maximum price values are valid.
   *         Otherwise, returns an error message indicating the type of validation
   *         error encountered.
   */
  public static String validatePrice(String min_Price, String max_Price) {
    try {
      String error;
      Double minPrice, maxPrice;
      if (min_Price.length() < 1 || min_Price == null) {
        error = "Please Insert minmum price";
        return error;
      }
      if (max_Price.length() < 1 || max_Price == null) {
        error = "Please Insert maximum price";
        return error;
      }
      if (!isNumeric(min_Price)) {
        error = "Please insert numeric value for minmum price";
        return error;
      }

      if (!isNumeric(max_Price)) {
        error = "Please insert numeric value for maximum price";
        return error;
      }
      minPrice = Double.parseDouble(min_Price);
      maxPrice = Double.parseDouble(max_Price);
      if (minPrice > maxPrice) {
        error = "Minmum Price can not be greather than maximum price";
        return error;
      }
      return "";
    } catch (NumberFormatException e) {
      return "Please insert valide value";
    }
  }

  /**
   * This method validates the input for bedroom and bathroom fields.
   * 
   * @param bedRoom  String representation of bedroom count.
   * @param bathRoom String representation of bathroom count.
   * @return an error message if input is invalid, otherwise returns an empty
   *         string.
   */
  public static String validateBedroomBathrooms(String bedRoom, String bathRoom) {
    try {
      String error;
      if ((bedRoom.length() < 1 || bedRoom == null) && (bathRoom.length() < 1 || bathRoom == null)) {
        error = "Please Insert Bedroom or BathRoom";
        return error;
      }
      if (bedRoom.length() > 0) {
        if (!isNumeric(bedRoom) && !isNumeric(bathRoom)) {
          error = "Please insert numeric value for Bedroom";
          return error;
        }
      }

      if (bathRoom.length() > 0) {
        if (!isNumeric(bathRoom)) {
          error = "Please insert numeric value for Bathrooms";
          return error;
        }
      }

      return "";
    } catch (NumberFormatException e) {
      return "Please insert valide value for Bedroom or Bathrooms";
    }
  }

  /**
   * This method validates the input parameter "bedRoom" as a valid number.
   * 
   * @param bedRoom The input value to be validated as the number of bedrooms in a
   *                property.
   * @return An error message if the input is not valid or an empty string if the
   *         input is valid.
   */
  public static String validateBedroom(String bedRoom) {
    try {
      String error;
      if (bedRoom.length() < 1 || bedRoom == null) {
        error = "Please Insert Bedroom";
        return error;
      }

      if (!isNumeric(bedRoom)) {
        error = "Please insert numeric value for Bedroom ";
        return error;
      }
      return "";
    } catch (NumberFormatException e) {
      return "Please insert valide value for Bedroom";
    }
  }

  /**
   * This method validates the number of bathrooms provided.
   * 
   * @param bathRoom he number of bathrooms to be validated.
   * @return An empty string if the number of bathrooms is valid, otherwise an
   *         error message.
   */
  public static String validateBathroom(String bathRoom) {
    try {
      String error;
      if (bathRoom.length() < 1 || bathRoom == null) {
        error = "Please Insert Bathrooms";
        return error;
      }

      if (!isNumeric(bathRoom)) {
        error = "Please insert numeric value for Bathrooms";
        return error;
      }
      return "";
    } catch (NumberFormatException e) {
      return "Please insert valide value for Bathrooms";
    }
  }

  /**
   * This method validates the square footage value entered by the user.
   * 
   * @param sqFt the square footage value entered by the user
   * @return an error message if the entered value is invalid, an empty string if
   *         the entered value is valid
   */
  public static String validateSqFt(String sqFt) {
    try {
      String error;
      if (sqFt.length() < 1 || sqFt == null) {
        error = "Please Insert SqFt";
        return error;
      }

      if (!isNumeric(sqFt)) {
        error = "Please insert numeric value for SqFt";
        return error;
      }
      return "";
    } catch (NumberFormatException e) {
      return "Please insert valide value for SqFt";
    }
  }
}
