package haile.arg.project.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import haile.arg.project.model.House;
import haile.arg.project.service.Sort;

/**
 * This JUnit test class tests the Sorting functionality of the Sort class which
 * provides the bubble sort and merge sort algorithms.
 * 
 * @author Haile Arg
 * @version 30/04/2023
 *
 */
public class TestingSortClass {

  private static List<House> testData = Arrays.asList(
      new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 6, 6, 3923, 714464.63),
      new House("77 Straubel Park", "Avenue", "Tuscaloosa", "Alabama", "35487", 1, 2, 3921, 411408.12),
      new House("5287 Drewry Point", "Trail", "Clearwater", "Florida", "33763", 2, 6, 1828, 786302.14),
      new House("86 Marquette Way", "Plaza", "Ocala", "Florida", "34479", 7, 4, 3174, 637070.79),
      new House("1816 Mcbride Alley", "Crossing", "Miami", "Florida", "33185", 1, 1, 3940, 172128.85)

  );

  @Test
  public void testSearchWithBubbleSortReturnsData() {
    List<House> sortedList = Sort.bubbleSortArrayList2(testData);
    assertNotNull(sortedList);
    assertTrue(sortedList.size() > 0);
  }

  @Test
  public void testBubbleSortWithEmptyList() {
    List<House> emptyList = Collections.emptyList();
    List<House> sortedList = Sort.bubbleSortArrayList2(emptyList);
    assertTrue(sortedList.isEmpty());
  }

  @Test
  public void testBubbleSort() {
    List<House> sortedList = Sort.bubbleSortArrayList2(testData);
    assertEquals(172128.85, sortedList.get(0).getPrice());
    assertEquals(411408.12, sortedList.get(1).getPrice());
    assertEquals(637070.79, sortedList.get(2).getPrice());
    assertEquals(714464.63, sortedList.get(3).getPrice());
    assertEquals(786302.14, sortedList.get(4).getPrice());
  }

  @Test
  public void testBubbleSortByPrice() {
    List<House> sortedList = Sort.bubbleSortArrayList2(testData);
    Assertions.assertEquals(sortedList.get(0).getPrice(), 172128.85);
    Assertions.assertEquals(sortedList.get(1).getPrice(), 411408.12);
    Assertions.assertEquals(sortedList.get(2).getPrice(), 637070.79);
    Assertions.assertEquals(sortedList.get(3).getPrice(), 714464.63);
    Assertions.assertEquals(sortedList.get(4).getPrice(), 786302.14);
  }

  @Test
  public void testSearchWithMergeSortReturnsData() {
    List<House> sortedList = Sort.mergeSortByPrice(testData);
    assertNotNull(sortedList);
    assertTrue(sortedList.size() > 0);
  }

  @Test
  public void testMergeSortWithNull() {
    List<House> emptyList = Collections.emptyList();
    List<House> sortedList = Sort.mergeSortByPrice(emptyList);
    assertTrue(sortedList.isEmpty());
  }

  @Test
  public void testMergeSort2() {
    List<House> sortedList = Sort.mergeSortByPrice(testData);
    assertEquals(172128.85, sortedList.get(0).getPrice());
    assertEquals(411408.12, sortedList.get(1).getPrice());
    assertEquals(637070.79, sortedList.get(2).getPrice());
    assertEquals(714464.63, sortedList.get(3).getPrice());
    assertEquals(786302.14, sortedList.get(4).getPrice());
  }

  @Test
  public void testMergeSortByPrice() {
    List<House> sortedList = Sort.mergeSortByPrice(testData);
    Assertions.assertEquals(sortedList.get(0).getPrice(), 172128.85);
    Assertions.assertEquals(sortedList.get(1).getPrice(), 411408.12);
    Assertions.assertEquals(sortedList.get(2).getPrice(), 637070.79);
    Assertions.assertEquals(sortedList.get(3).getPrice(), 714464.63);
    Assertions.assertEquals(sortedList.get(4).getPrice(), 786302.14);
  }
}
