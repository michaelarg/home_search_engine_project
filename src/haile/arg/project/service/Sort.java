package haile.arg.project.service;

import java.util.ArrayList;
import java.util.List;

import haile.arg.project.model.House;

/**
 * This class provides various methods to sort a List of House objects based on
 * their price attribute.
 * 
 * @author Haile Arg
 * @version 30/04/2023
 */
public class Sort {

  /**
   * Sorts a List of House objects using Bubble Sort based on their price
   * attribute.
   * 
   * @param list The List of House objects to be sorted.
   * @return A sorted List of House objects based on their price attribute.
   */
  public static List<House> bubbleSortArrayList2(List<House> list) {
    int n = list.size();
    int i, j;
    House temp;
    boolean swapped;
    for (i = 0; i < n - 1; i++) {
      swapped = false;
      for (j = 0; j < n - i - 1; j++) {
        if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {
          temp = list.get(j);
          list.set(j, list.get(j + 1));
          list.set(j + 1, temp);
          swapped = true;
        }
      }

      if (!swapped)
        break;
    }

    return list;
  }

  /**
   * This method implements the merge sort algorithm to a List of House objects
   * based on their price attribute.
   * 
   * @param houseList he List of House objects to be sorted.
   * @param l         Starting index of the first subarray.
   * @param m         Ending index of the first subarray and Starting index of the
   *                  second subarray.
   * @param r         Ending index of the second subarray.
   */
  public static void mergeByPrice(List<House> houseList, int l, int m, int r) {

    int n1 = m - l + 1;
    int n2 = r - m;

    List<House> L = new ArrayList<>();
    List<House> R = new ArrayList<>();

    for (int i = 0; i < n1; ++i)
      L.add(houseList.get(l + i));

    for (int j = 0; j < n2; ++j)
      R.add(houseList.get(m + 1 + j));

    int i = 0, j = 0;

    int k = l;
    while (i < n1 && j < n2) {
      if (L.get(i).getPrice() <= R.get(j).getPrice()) {
        houseList.set(k, L.get(i));
        i++;
      } else {
        houseList.set(k, R.get(j));
        j++;
      }
      k++;
    }

    while (i < n1) {
      houseList.set(k, L.get(i));
      i++;
      k++;
    }

    while (j < n2) {
      houseList.set(k, R.get(j));
      j++;
      k++;
    }
  }

  /**
   * This recursive method implements the merge sort algorithm to sort a list of
   * House objects based on their price.
   * 
   * @param houseList The List of House objects to be sorted.
   * @param l         the starting index of the sublist to be sorted
   * @param r         the ending index of the sublist to be sorted
   */
  public static void sortByPrice(List<House> houseList, int l, int r) {
    if (l < r) {

      int m = l + (r - l) / 2;

      sortByPrice(houseList, l, m);
      sortByPrice(houseList, m + 1, r);

      mergeByPrice(houseList, l, m, r);
    }
  }

  /**
   * This method uses the merge sort algorithm to sort a list of houses by their
   * price in ascending order.
   * 
   * @param houseList the list of House objects to be sorted by price
   * @return the sorted list of House objects
   */
  public static List<House> mergeSortByPrice(List<House> houseList) {
    sortByPrice(houseList, 0, houseList.size() - 1);
    return houseList;
  }
}
