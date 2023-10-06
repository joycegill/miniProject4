package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests of the AssociativeArray class.
 *
 * @author CSC-207 2023Fa
 */
public class AssociativeArrayTests {

  // +---------------------+-----------------------------------------
  // | Tests by Sam Bigham |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Micah Cantor |
  // +-----------------------+

  // +------------------------+--------------------------------------
  // | Tests by Reed Colloton |
  // +------------------------+

  // +------------------+--------------------------------------------
  // | Tests by Pom Dao |
  // +------------------+

  // +--------------------------+------------------------------------
  // | Tests by Joshua Delarosa |
  // +--------------------------+

  // +-------------------+-------------------------------------------
  // | Tests by Jinny Eo |
  // +-------------------+

  // +---------------------------+-----------------------------------
  // | Tests by Kevin Fitzgerald |
  // +---------------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Joyce Gill |
  // +---------------------+

  // +--------------------+------------------------------------------
  // | Tests by Che Glenn |
  // +--------------------+

  // +-------------------------+-------------------------------------
  // | Tests by Kevin Johanson |
  // +-------------------------+

  // +----------------------+----------------------------------------
  // | Tests by Chloe Kelly |
  // +----------------------+

  // +--------------------+------------------------------------------
  // | Tests by Hyeon Kim |
  // +--------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Julian Kim |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Jason Kunkel |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Wenfei Lin |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Noah Mendola |
  // +-----------------------+

  // +----------------------+----------------------------------------
  // | Tests by John Miller |
  // +----------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Albert Okine |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Alma Ordaz |
  // +---------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Samuel A. Rebelsky |
  // +-----------------------------+

  /**
   * A test of cloning.
   */
  @Test
  public void samuelRebelskyTest01() {
    // Build an array
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (Exception e) {
      fail("Original array does not contain expected value");
    }
    // Make a copy
    AssociativeArray<String, String> arr2 = arr.clone();
    // Make sure it contains the appropriate value
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Clone does not contain original value");
    } // try/catch
    // Change the original array
    arr.set("A", "aardvark");
    // Make sure we haven't changed the clone.
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Change to original changes clone.");
    }
    // Change the clone
    arr2.set("A", "Ant");
    // And look for values
    try {
      assertEquals("Ant", arr2.get("A"));
    } catch (Exception e) {
      fail("Cannot change clone");
    }
    try {
      assertEquals("aardvark", arr.get("A"));
    } catch (Exception e) {
      fail("Change to clone changes original");
    }
  } // samuelRebelskyTest01()

  /**
   * Can we successfully add a bunch of values? (Checks array expansion.)
   */
  @Test
  public void samuelRebelskyTest02() {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // Add a bunch of values
    for (int i = 10; i < 50; i++) {
      arr.set(i, i * i);
    } // for
    try {
      for (int i = 49; i >= 10; i--) {
        assertEquals(i * i, arr.get(i));
      }
    } catch (Exception e) {
      fail("Exception in call to get");
    }
  } // samuelRebelskyTest02()

  /**
   * Do we get exceptions when grabbing a deleted value from the array?
   */
  @Test
  public void samuelRebelskyTest03() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // Add an element to the array
    arr.set("A", "Apple");
    // Make sure that it's there.
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (KeyNotFoundException e) {
      fail("Could not set A to Apple");
    }
    // Remove it.
    arr.remove("A");
    // Make sure it's no longer there.
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyTest03

  /**
   * Do we get exceptions when grabbing a value from the empty array.
   */
  @Test
  public void samuelRebelskyEdge01() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyEdge01


  // +--------------------------+------------------------------------
  // | Tests by Maria Rodriguez |
  // +--------------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Gabriela Roznawska |
  // +-----------------------------+

  @Test
  public void gabrielaRoznawskaTest01() {
    // create an initialize an array to an Apple
    AssociativeArray<String, String> ar1 = new AssociativeArray<String, String>();
    ar1.set("Apple", "Apple-Cinnamon milk rice");

    // if the set to an Apple was not succesful then return an exception
    try {
      assertEquals("Apple-Cinnamon milk rice", ar1.get("Apple"));
    } catch (KeyNotFoundException exception) {
      fail("Could not set Apple to Apple-Cinnamon milk rice");
    }
  } // gabrielaRoznawskaTest01

  @Test
  public void gabrielaRoznawskaTest02() {
    // declare and initialize the keys in the array
    AssociativeArray<String, String> ar1 = new AssociativeArray<String, String>();
    ar1.set("Apple", "Apple-Cinnamon milk rice");
    ar1.set("Beans", "Tomato sauce Beans");
    // if the set was unsuccesful then return exception
    try {
      assertEquals("Tomato sauce Beans", ar1.get("Beans"));
    } catch (KeyNotFoundException exception) {
      fail("Could not set Tomato sauce Beans");
    }

    // removing the Apple key from the array
    ar1.remove("Apple");

    // If the removing did not work then throw an exception
    try {
      ar1.get("Apple");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
    }

    // if the remaining key: beans is still in the array then do not throw an exception
    try {
      assertEquals("Tomato sauce Beans", ar1.get("Beans"));
    } catch (KeyNotFoundException exception) {
      fail("Removing of the Apple disrupted the Beans");
    }
  } // gabrielaRoznawska02

  @Test
  public void gabrielaRoznawska03() throws KeyNotFoundException {
    // declaration of the arrays and initialization of the first one
    AssociativeArray<String, String> ar1 = new AssociativeArray<String, String>();
    AssociativeArray<String, String> ar2 = new AssociativeArray<String, String>();
    ar1.set("Apple", "Apple-Cinnamon milk rice");

    // clone the array 1 contents onto the array 2 and throw exception if it was not succesful
    try {
      ar2 = ar1.clone();
      assertEquals("Apple-Cinnamon milk rice", ar2.get("Apple"));
    } catch (KeyNotFoundException exception) {
      fail("Cloning not succesful");
    }
    // overwrite the "apple" with a different value
    ar2.set("Apple", "Apples with carmel glaze");

    // if the overwriting was unsuccesful then throw exception
    try {
      assertEquals("Apples with carmel glaze", ar2.get("Apple"));
    } catch (KeyNotFoundException exception) {
      fail("Overwriting the Apple key was unsuccesful");
    }

  } // gabrielaRoznawska03 test
  // +-----------------------+---------------------------------------
  // | Tests by Shuta Shibue |
  // +-----------------------+

  // +----------------------+----------------------------------------
  // | Tests by Madel Sibal |
  // +----------------------+

  // +------------------------------+--------------------------------
  // | Tests by Livia Stein Freitas |
  // +------------------------------+

  // +------------------------+--------------------------------------
  // | Tests by Tyrell Taylor |
  // +------------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Audrey Trinh |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Rene Urias |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Christina Vu |
  // +-----------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Luke Walters |
  // +-----------------------+

  // +------------------------+--------------------------------------
  // | Tests by Jonathan Wang |
  // +------------------------+

  // +-------------------+-------------------------------------------
  // | Tests by Lydia Ye |
  // +-------------------+

} // class AssociativeArrayTests
