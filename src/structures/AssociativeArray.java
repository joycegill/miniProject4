package structures;

import static java.lang.reflect.Array.newInstance;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * A basic implementation of Associative Arrays with keys of type K and values of type V.
 * Associative Arrays store key/value pairs and permit you to look up values by key.
 *
 * @author Joyce Gill
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of the initial array.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The size of the associative array (the number of key/value pairs).
   */
  int size;

  /**
   * The array of key/value pairs.
   */
  public KVPair<K, V> pairs[];

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty associative array.
   */
  @SuppressWarnings({"unchecked"})
  public AssociativeArray() {
    // Creating new arrays is sometimes a PITN.
    this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(), DEFAULT_CAPACITY);
    this.size = 0;
  } // AssociativeArray()

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  /**
   * Create a copy of this AssociativeArray.
   */
  public AssociativeArray<K, V> clone() {
    AssociativeArray<K, V> clonedArr = new AssociativeArray<>();
    for (int i = 0; i < this.size; i++) {
      clonedArr.set(pairs[i].key, pairs[i].value);
    }
    return clonedArr;
  } // clone()

  /**
   * Convert the array to a string.
   */
  public String toString() {
    String temp = "";
    for (int i = 0; i < this.size; i++) {
      temp += pairs[i].key + ": " + pairs[i].value + ", ";
    }
    return "{" + temp + "}";
  } // toString()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * Set the value associated with key to value. Future calls to get(key) will return value.
   */
  public void set(K key, V value) {
    try{
      // Update value if key is found
      for (int i = 0; i < size; i++) {
        if (pairs[i].key.equals(key)) {
          pairs[i].value = value;
          return;
        }
      }
      // Full array
      if (size == pairs.length) {
        expand();
      }
      KVPair<K, V> newPair = new KVPair<K, V>(key, value);
      pairs[size++] = newPair;
    } catch (Exception e) {
      fail("Error: key does not exist");
    } // try/catch
  
  }
  // set(K,V)

  /**
   * Get the value associated with key.
   *
   * @throws KeyNotFoundException when the key does not appear in the associative array.
   */
  public V get(K key) throws KeyNotFoundException {
    return this.pairs[find(key)].value;
  } // get(K)

  /**
   * Determine if key appears in the associative array.
   */
  public boolean hasKey(K key) {
    for (int i = 0; i < size; i++) {
      if (pairs[i].key == key) {
        return true;
      }
    }
    return false;
  } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls to get(key) will throw an
   * exception. If the key does not appear in the associative array, does nothing.
   */
  public void remove(K key) {
    int j = 0;
    try{
      for (int i = 0; i < size; i++) {
        if (pairs[i].key == key) {
          for (j = i; j + 1 < size; j++) {
            pairs[j] = pairs[j + 1];
          }
          pairs[j + 1] = null;
          size--;
        }
      } // remove(K)
    } catch (Exception e) {
      fail("Error: key does not exist");
    } // try/catch
  }

  /**
   * Determine how many values are in the associative array.
   */
  public int size() {
    return this.size;
  } // size()


  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
  public void expand() {
    this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
  } // expand()

  /**
   * Find the index of the first entry in `pairs` that contains key. If no such entry is found,
   * throws an exception.
   */
  public int find(K key) throws KeyNotFoundException {
    for (int i = 0; i < size; i++) {
      if (pairs[i].key.equals(key)) {
        return i;
      }
    }
    throw new KeyNotFoundException();
    // find(K)

  }
} // class AssociativeArray
