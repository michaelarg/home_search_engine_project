package haile.arg.project.service;

import java.util.ArrayList;
import java.util.List;

import haile.arg.project.model.House;

/**
 * This class is used for searching houses based on various criteria such as
 * city/state/zip, number of bedrooms and bathrooms, price range, and square
 * footage.
 * 
 * @author Haile Arg
 * @version 30/04/2023
 */
public class Search {

  /**
   * 
   * This method takes in various search criteria and returns a list of houses
   * that match the search parameters.
   * 
   * @param SearchMethod A String representing the search method.
   * @param ctyStateZip  A String representing the city, state, or zip code for
   *                     the search.
   * @param bedRoom      An int representing the number of bedrooms for the
   *                     search.
   * @param bathRoom     An int representing the number of bathrooms for the
   *                     search.
   * @param minPrice     A double representing the minimum price for the search.
   * @param maxPrice     A double representing the maximum price for the search.
   * @param SqFt         A double representing the square footage for the search.
   * @return A List of House objects that match the search criteria.
   */
  public static List<House> searchHouse(String SearchMethod, String ctyStateZip, int bedRoom, int bathRoom,
      double minPrice, double maxPrice, double SqFt) {

    List<House> houseData = DataService.readHomedataJSON();
    List<House> SearchResultArrayList = new ArrayList<>();
    for (House house : houseData) {
      if (SearchMethod.equals("City/State/Zip")) {
        if (house.getCity().equalsIgnoreCase(ctyStateZip) || house.getState().equalsIgnoreCase(ctyStateZip)
            || house.getZip().equalsIgnoreCase(ctyStateZip)) {
          SearchResultArrayList
              .add(new House(house.getStreetAddress(), house.getStreetSuffix(), house.getCity(), house.getState(),
                  house.getZip(), house.getBedrooms(), house.getBathrooms(), house.getSqft(), house.getPrice()));
        }
      } else if (SearchMethod.equals("Bedrooms and Bathrooms")) {
        if (house.getBedrooms() == bedRoom || house.getBathrooms() == bathRoom) {
          SearchResultArrayList
              .add(new House(house.getStreetAddress(), house.getStreetSuffix(), house.getCity(), house.getState(),
                  house.getZip(), house.getBedrooms(), house.getBathrooms(), house.getSqft(), house.getPrice()));
        }
      } else if (SearchMethod.equals("Min/Max Price")) {
        if (house.getPrice() >= minPrice && house.getPrice() <= maxPrice) {
          SearchResultArrayList
              .add(new House(house.getStreetAddress(), house.getStreetSuffix(), house.getCity(), house.getState(),
                  house.getZip(), house.getBedrooms(), house.getBathrooms(), house.getSqft(), house.getPrice()));
        }
      } else if (SearchMethod.equals("SqFt")) {
        if (house.getSqft() == SqFt) {
          SearchResultArrayList
              .add(new House(house.getStreetAddress(), house.getStreetSuffix(), house.getCity(), house.getState(),
                  house.getZip(), house.getBedrooms(), house.getBathrooms(), house.getSqft(), house.getPrice()));
        }
      }

    }

    return SearchResultArrayList;

  }

}
