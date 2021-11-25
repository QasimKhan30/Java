import java.util.NoSuchElementException;
import java.util.Iterator;
import java.io.Serializable;
/**
 * Hashtable implementation that uses linear probing in case of collisions.
 * 
 * @author Qasim Khan
 * @author Yutao Zhong
 * @param <K> Generic data type for key.
 * @param <V> Generic data type for value.
 */
public class HashTable<K, V> implements Serializable {

	// -------------------------------------------------------------
	// DO NOT EDIT ANYTHING FOR THIS SECTION EXCEPT TO ADD JAVADOCS
	// -------------------------------------------------------------

	/**
	 * Inner class used to hold entries of hash table.
	 * @author Yutao Zhong
	 * @param <K> Generic data type for key.
	 * @param <V> Generic data type for value.
	 */
	private class TableEntry<K, V> implements Serializable {
		/**
		 * Key of table entry.
		 */
		private K key;
		/**
		 * Value of table entry.
		 */
		private V value;

		/**
		 * Constructor for table entry.
		 * @param key   to be set as key.
		 * @param value to be set as value.
		 */
		public TableEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Getter for key.
		 * @return key.
		 */
		public K getKey() {
			return key;
		}

		/**
		 * Getter for value.
		 * @return value.
		 */
		public V getValue() {
			return value;
		}

		/**
		 * String representation of table entry.
		 * @return String representation.
		 */
		public String toString() {
			return key.toString() + ":" + value.toString();
		}
	}

	/**
	 * Used to store key value pairs in array.
	 */
	private TableEntry<K, V>[] storage;

	// -------------------------------------------------------------
	// END OF PROVIDED "DO NOT EDIT" SECTION
	// -------------------------------------------------------------

	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED!

	/**
	 * Tracks how many elements are in the HashTable.
	 */
	private int size = 0;

	/**
	 * Capacity of the hash table.
	 */
	private int capacity;

	/**
	 * Max load of hash table.
	 */
	private int maxLoad = 80;
	
	/**
	 * TombStone used for removing items from HashTable.
	 */
	private TableEntry<K,V> tombStone= new TableEntry<K,V>(null, null);

	/**
	 * Constructor for the hash table with specific capacity. size will be >= 2.
	 * 
	 * @param size to set for capacity.
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int size) {

		capacity = size;

		storage = (TableEntry<K, V>[]) new TableEntry[size];

	}

	/**
	 * This method returns how big the storage is. O(1).
	 * 
	 * @return int capacity of storage
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * This method returns the size of the hash table. O(1).
	 * @return int size of table.
	 */
	public int size() {
		return size;
	}

	/**
	 * Private helper method that produces a hashtable index for a key.
	 * @param key we want to create hashtable index for.
	 * @return int hash table index for key.
	 */
	private int getHTI(K key) {
		return Math.abs(key.hashCode() % capacity);
	}

	/**
	 * This method places a value at the location of key. Uses linear probing if
	 * location is in use. If the table is >= 80% full, table is rehashed to ensure
	 * the table is expanded to twice the size. Worst case: O(n), Average case:
	 * O(1).
	 * @param key of hash table.
	 * @param val value of hash table.
	 * @return boolean false if either key or value is null, otherwise true.
	 */
	public boolean put(K key, V val) {

		if (key == null || val == null) {
			return false;
		}

		int hti = getHTI(key); // hash table index

		TableEntry<K, V> entry = new TableEntry<K, V>(key, val);

		boolean bool = true;
		int probe = 0,probedIndex;


		while (bool) {
			
			if (hti + probe >= capacity) {
				hti = 0;
				probe = 0;
			}
			
			probedIndex = hti + probe;

			if (storage[probedIndex] == null || isTombstone(probedIndex) || storage[probedIndex].getKey().equals(key) ) {
				
				if(storage[probedIndex] != null && storage[probedIndex].getKey().equals(key)) 
				{
					size--;
				}
				storage[probedIndex] = entry;
				
				
				size++;

				double loadFactor = (double) this.size / capacity;
				double load = loadFactor * 100;

				if (load >= maxLoad) {
					rehash(2 * capacity);
				}

				return true;
				
			} else if (storage[probedIndex].getKey().equals(key)) {
				storage[probedIndex] = entry;
				return true;
			} else {
				probe++;
			}
		}

		return false; // default return: change or remove as needed

	}

	/**
	 * Given a key, returns the value from the table. Worst case: O(n), Average
	 * case: O(1).
	 * @param key location from which we want to return value.
	 * @return value at location of key.
	 */
	public V get(K key) {

		int probedIndex, probe = 1;
		if (storage[getHTI(key)] == null || isTombstone(getHTI(key))) {
			return null;
		}

		if (storage[getHTI(key)].key.equals(key)) {
			return storage[getHTI(key)].value;
		} else {
			while (true) {
				probedIndex = (getHTI(key) + probe) % capacity;
				if(probedIndex == getHTI(key))
				{
					return null;
				}
				if (storage[probedIndex] == null || isTombstone(probedIndex)) {
					return null;
				}

				else if (storage[probedIndex].getKey().equals(key)) {
					return storage[probedIndex].getValue();
				}
				else
				{
					probe++;
				}
			}
		}

	}

	/**
	 * This method checks if an item is storage is a tombstone. O(1).
	 * @param loc location to be checked.
	 * @return boolean true if location is tombstone, false otherwise.
	 */
	public boolean isTombstone(int loc) {

		if (loc > capacity || storage[loc] == null) {
			return false;
		}
		if (storage[loc].equals(tombStone)) {
			return true;
		}
		return false;
	}

	/**
	 * Increases or decreases the size of storage. Rehashes all values.
	 * @param size to rehash table to.
	 * @return boolean false if we do not rehash, true if we are able to.
	 */
	@SuppressWarnings("unchecked")
	public boolean rehash(int size) {

		if (size < this.size) {
			return false;
		}

		capacity = size;
		this.size = 0;

		TableEntry<K, V>[] newarr = storage;
		storage = (TableEntry<K, V>[]) new TableEntry[capacity];
		for (TableEntry<K, V> entry : newarr) {
			if (entry == null) {
				continue;
			}
			this.put(entry.getKey(), entry.getValue());
			size++;
		}
		return true;

	}

	/**
	 * Remove the given key and associated value from the table. Worst case: O(n),
	 * Average case: O(1).
	 * @param key of table entry we want to remove.
	 * @return value that is removed, null if key is not in table
	 */
	public V remove(K key) {

		int hti = getHTI(key);

		TableEntry<K, V> temp;

		if (storage[hti] != null) {
			temp = storage[hti];
			storage[hti] = tombStone;
			size--;
			return temp.getValue();
		}

		return null; 
	}

	// -------------------------------------------------------------
	// PROVIDED METHODS BELOW
	// DO NOT EDIT ANYTHING FOR THIS SECTION EXCEPT TO ADD JAVADOCS
	// -------------------------------------------------------------

	/**
	 * This method provides a string representation of HashTable.
	 * @return String representation.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null && !isTombstone(i)) {
				s.append(storage[i] + "\n");
			}
		}
		return s.toString().trim();
	}

	/**
	 * This method provides a high information string representation of HashTable
	 * used for debugging..
	 * @return String representation.
	 */
	public String toStringDebug() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < storage.length; i++) {
			if (!isTombstone(i)) {
				s.append("[" + i + "]: " + storage[i] + "\n");
			} else {
				s.append("[" + i + "]: tombstone\n");
			}

		}
		return s.toString().trim();
	}

	// -------------------------------------------------------------
	// END OF PROVIDED METHODS SECTION
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// TESTING CODE
	// -------------------------------------------------------------

	/**
	 * Main method used for testing.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		// main method for testing, edit as much as you want
		HashTable<String, Integer> ht1 = new HashTable<>(10);
		HashTable<Integer, Character> ht2 = new HashTable<>(5);

		// initialize
		if (ht1.getCapacity() == 10 && ht2.getCapacity() == 5 && ht1.size() == 0 && ht2.size() == 0) {
			System.out.println("Yay 1");
		}

		// put
		ht1.put("a", 1); // "a".hashCode = 97
		ht1.put("b", 1); // "b".hashCode = 98
		ht1.put("b", 2); // update
		ht1.put("b", 3);

		// System.out.println(ht1);
		// System.out.println(ht1.toStringDebug());

		if (ht1.toString().equals("a:1\nb:3") && ht1.toStringDebug().equals(
				"[0]: null\n[1]: null\n[2]: null\n[3]: null\n[4]: null\n[5]: null\n[6]: null\n[7]: a:1\n[8]: b:3\n[9]: null")) {
			System.out.println("Yay 2");
		}
		
		if (!ht1.put(null, 0) && ht1.getCapacity() == 10 && ht1.size() == 2 && ht1.get("a") == 1 && ht1.get("b") == 3) {
			System.out.println("Yay 3");
		}

		// put with collision
		ht2.put(12, 'A');
		ht2.put(22, 'B');
		ht2.put(37, 'C');

		ht2.put(47, 'D');

		if (ht2.getCapacity() == 10 && ht2.size() == 4 && ht2.get(1) == null && ht2.get(12) == 'A' && ht2.get(22) == 'B'
				&& ht2.get(37) == 'C' && ht2.get(47) == 'D') {
			System.out.println("Yay 4");
		}

		if (ht2.toString().equals("12:A\n22:B\n47:D\n37:C") && ht2.toStringDebug().equals(
				"[0]: null\n[1]: null\n[2]: 12:A\n[3]: 22:B\n[4]: null\n[5]: null\n[6]: null\n[7]: 47:D\n[8]: 37:C\n[9]: null")) {
			System.out.println("Yay 5");
		}

		// remove
		HashTable<String, Integer> ht3 = new HashTable<>(2);
		ht3.put("apple", 1); // hashCode: 93029210

		if (ht3.remove("apple") == 1 && ht3.remove("banana") == null && ht3.toString().equals("")
				&& ht3.toStringDebug().equals("[0]: tombstone\n[1]: null")) {
			ht3.put("B", 1);
			if (ht3.toString().equals("B:1") && ht3.toStringDebug().equals("[0]: B:1\n[1]: null")) {
				System.out.println("Yay 6");
			}
		}

		// rehash
		if (!ht2.rehash(2) && ht2.size() == 4 && ht2.getCapacity() == 10) {
			System.out.println("Yay 7");
		}

		if (ht2.rehash(7) && ht2.size() == 4 && ht2.getCapacity() == 7) {
			System.out.println("Yay 8");
		}
		// System.out.println(ht2);
		// System.out.println(ht2.toStringDebug());

		if (ht2.toString().equals("22:B\n37:C\n12:A\n47:D") && ht2.toStringDebug()
				.equals("[0]: null\n[1]: 22:B\n[2]: 37:C\n[3]: null\n[4]: null\n[5]: 12:A\n[6]: 47:D")) {
			System.out.println("Yay 9");
		}
		

	}

}