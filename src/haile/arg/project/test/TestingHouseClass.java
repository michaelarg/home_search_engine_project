package haile.arg.project.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import haile.arg.project.model.House;

/**
 * This class is used to demonstrate how to validate a the House Class.
 * 
 * @author Haile Arg
 * @version 30/04/2023
 *
 */
public class TestingHouseClass {

  private House HouseTestObject;

  @BeforeEach
  void setUp() {
    this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 6, 6, 3923,
        714464.63);
  }

  @AfterEach
  void tearDown() {
    this.HouseTestObject = null;
  }

  @Test
  void testConstructorNullStreetAddress() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House(null, "Road", "Saint Augustine", "Florida", "32092", 6, 6, 3923, 714464.63);
    });
  }

  @Test
  void testConstructorStreetAddress() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("", "Road", "Saint Augustine", "Florida", "32092", 6, 6, 3923, 714464.63);
    });
  }

  @Test
  void testConstructorNullStreetSuffix() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", null, "Saint Augustine", "Florida", "32092", 6, 6, 3923,
          714464.63);
    });
  }

  @Test
  void testConstructorEmptyStreetSuffix() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "", "Saint Augustine", "Florida", "32092", 6, 6, 3923,
          714464.63);
    });
  }

  @Test
  void testConstructorStreetSuffixWithWhiteSpace() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Ro ad", "Saint Augustine", "Florida", "32092", 6, 6, 3923,
          714464.63);

    });
  }

  @Test
  void testConstructorNullCity() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", null, "Saint Augustine", "Florida", "32092", 6, 6, 3923,
          714464.63);
    });
  }

  @Test
  void testConstructorEmptyCity() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "", "Saint Augustine", "Florida", "32092", 6, 6, 3923,
          714464.63);
    });
  }

  @Test
  void testConstructorNullState() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", null, "32092", 6, 6, 3923,
          714464.63);
    });
  }

  @Test
  void testConstructorEmptyState() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "", "32092", 6, 6, 3923,
          714464.63);
    });
  }

  @Test
  void testConstructorStateWithWhiteSpace() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Flor ida", "32092", 6, 6, 3923,
          714464.63);
    });
  }

  @Test
  void testConstructorNegativeZipCode() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "-32092", 6, 6, 3923,
          714464.63);

    });
  }

  @Test
  void testConstructorZipCodeBelowRange() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "3209", 6, 6, 3923,
          714464.63);

    });
  }

  @Test
  void testConstructorZipCodeAboveRange() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "320924", 6, 6, 3923,
          714464.63);

    });
  }

  @Test
  public void testConstructorNegativeBedrooms() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", -6, 6, 3923,
          714464.63);
    });
  }

  @Test
  public void testConstructorZeroBedrooms() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 0, 6, 3923,
          714464.63);
    });
  }

  @Test
  public void testConstructorNegativeBathroom() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 6, -6, 3923,
          714464.63);
    });
  }

  @Test
  public void testConstructorZeroBathroom() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 6, 0, 3923,
          714464.63);
    });
  }

  @Test
  public void testConstructorNegativeSqft() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 6, 6, -3923,
          714464.63);
    });
  }

  @Test
  public void testConstructorNegativePrice() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 6, 6, 3923,
          -714464.63);
    });
  }

  @Test
  public void testConstructorZeroPrice() {
    assertThrows(IllegalArgumentException.class, () -> {
      this.HouseTestObject = new House("80734 Nobel Pass", "Road", "Saint Augustine", "Florida", "32092", 6, 6, 3923,
          0);
    });
  }
}
