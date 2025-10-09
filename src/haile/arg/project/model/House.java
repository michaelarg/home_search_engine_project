package haile.arg.project.model;

/**
 * This Java class represents a House. The House constructor is used to create
 * each House object and to populate its properties with the values from the
 * JSON file. It contains data fields for House informations. It also contains
 * methods for getting the values of the fields.
 *
 * 
 * @author Haile Arg
 * @version 30/04/2023
 *
 */
public class House {

  /**
   * Fields for storing the information of Houses
   */
  private String street_address;
  private String street_suffix;
  private String city;
  private String state;
  private String zip;
  private int bedrooms;
  private int bathrooms;
  private double sqft;
  private double price;

  /**
   * This constructor defines the details of the House
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
   * 
   * @param street_suffix the suffix of the street address
   * @param city          the city where the house is located
   * @param state         the state where the house is located
   * @param zip           the zip code of the area where the house is located
   * @param bedrooms      the number of bedrooms in the house
   * @param bathrooms     the number of bathrooms in the house
   * @param sqft          the size of the house in square foot
   * @param price         the price of the house
   */
  public House(String street_address, String street_suffix, String city, String state, String zip, int bedrooms,
      int bathrooms, double sqft, double price) {

    int zipLength = zip.length();

    if ((street_address == null) || (street_address.isEmpty())) {
      throw new IllegalArgumentException("The streetAddress must not be null or empty.");
    }
    if ((street_suffix == null) || (street_suffix.isEmpty()) || street_suffix.contains(" ")) {
      throw new IllegalArgumentException(
          "The streetSuffix must not be null or empty or empty or contain any whitespace characters.");
    }
    if ((city == null) || (city.isEmpty())) {
      throw new IllegalArgumentException("The city must not be null or empty or empty");
    }
    if ((state == null) || (state.isEmpty()) || state.contains(" ")) {
      throw new IllegalArgumentException(
          "The state must not be null or empty or empty or contain any whitespace characters.");
    }
    if (Integer.parseInt(zip) < 0) {
      throw new IllegalArgumentException("The zip code cannot be a negative number");
    }
    if (zipLength != 5) {
      throw new IllegalArgumentException("The zip code should have exactly 5 digits");
    }
    if (bedrooms <= 0) {
      throw new IllegalArgumentException("bedrooms can not be less than zero");
    }

    if (bathrooms <= 0) {
      throw new IllegalArgumentException("bathrooms can not be less than or equals to zero");
    }

    if (sqft <= 0) {
      throw new IllegalArgumentException("sqft can not be less than or equals to zero");
    }

    if (price <= 0) {
      throw new IllegalArgumentException("price can not be less than or equals to zero");
    }

    this.street_address = street_address;
    this.street_suffix = street_suffix;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.bedrooms = bedrooms;
    this.bathrooms = bathrooms;
    this.sqft = sqft;
    this.price = price;
  }

  /**
   * This method overrides the toString method to return a String format of the
   * House information
   */
  @Override
  public String toString() {
    return String.format(
        "StAddr: %s, StSuff: %s, City: %s, State: %s, Zip: %s, Bedr:  %2d, Batroo:  %2d, Sqft: %.2f, Price: %.2f",
        this.street_address, this.street_suffix, this.city, this.state, this.zip, this.bedrooms, this.bathrooms,
        this.sqft, this.price);
  }

  /**
   * Getter for streetAddress
   * 
   * @return the streetAddress of the House
   */
  public String getStreetAddress() {
    return this.street_address;
  }

  /**
   * Getter for streetSuffix
   * 
   * @return the street Suffix of the House
   */
  public String getStreetSuffix() {
    return this.street_suffix;
  }

  /**
   * Getter for the City
   * 
   * @return the name of the city where the House is located
   */
  public String getCity() {
    return this.city;
  }

  /**
   * Getter for State
   * 
   * @return the name of the state where the House is located
   */
  public String getState() {
    return this.state;
  }

  /**
   * Getter for Zip
   * 
   * @return the Zip code of the House
   */
  public String getZip() {
    return this.zip;
  }

  /**
   * Getter for Bedrooms
   * 
   * @return the number of bedrooms in the House
   */
  public int getBedrooms() {
    return this.bedrooms;
  }

  /**
   * Getter for Bathrooms
   * 
   * @return the number of bathrooms in the House
   */
  public int getBathrooms() {
    return this.bathrooms;
  }

  /**
   * Getter for square foot
   * 
   * @return the square foot size of the House
   */
  public double getSqft() {
    return this.sqft;
  }

  /**
   * Getter for Price
   * 
   * @return the price of the House
   */
  public double getPrice() {
    return this.price;
  }

}
