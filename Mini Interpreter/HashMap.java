
/**
 * Hashmap Implementation.
 * @author W. Masri
 * @author Qasim Khan
 * @param <K> Generic key.
 * @param <V> Generic value.
 */
public class HashMap<K, V> 
{
	
	// This HashMap implementation uses a LList<T> composed of Node<T>.
	// Since two generic parameters <K, V> are needed instead of one, 
	// the Pair class below is provided to be used as follows: Node<Pair> and LList<Pair>
	/**
	 * The pair class is provided to be used with the Node and LList Class. Gives us ability to store an extra key and value.
	 * @author W. Mari
	 * @param <K> Generic Key.
	 * @param <V> Generic Value.
	 */
	class Pair<K,V> {
		/**
		 * Generic key for Pair class.
		 */
		private K key;
		/**
		 * Generic value for Pair class.
		 */
		private V value;
		/**
		 * Constructor for Pair Class.
		 * @param key for pair class.
		 * @param value for pair class.
		 */
		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
		/**
		 * Getter for key.
		 * @return key.
		 */
		public K getKey(){ return key; }
		/**
		 * Getter for value.
		 * @return value.
		 */
		public V getValue(){ return value; }
		/**
		 * Setter for key.
		 * @param key to be set.
		 */
		public void setKey(K key){ this.key = key; }
		/**
		 * Setter for value.
		 * @param value to be set.
		 */
		public void setValue(V value){ this.value = value; }
		/**
		 * Getter for Hashcode of key.
		 * @return hashcode of the key.
		 */
		@Override public int hashCode() {  
			return key.hashCode(); 
		}
		/**
		 * This method checks if two pairs are equal.
		 * @return boolean true if equal, false otherwise.
		 */
		@Override public boolean equals(Object obj) {  
			if (obj == null) return false;
			if (!(obj instanceof Pair)) return false;
			Pair pair = (Pair)obj;
			return pair.key.equals(key); 
		}
		
		/**
		 * String representation of pair.
		 * @return String
		 */
		public String toString() 
		{
			return "" + key + ", " + value;
		}
	}

    /**
     * Array of LLists where each list will be composed of Node Pair.
     */
    private LList<Pair>[] buckets;

    /**
     * Default capacity of buckets array.
     */
    final static private int DEFAULT_CAPACITY = 20;

    /**
     * Tracks how many elements are in the HashMap.
     */
    private int size = 0;
	
    /**
     * Constructor for the HashMap.
     */
    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor for HashMap that initializes buckets array to a specific capacity.
     * @param capacity for the buckets array.
     */
    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
    	buckets = (LList<Pair>[])new LList[capacity];
    }

    /**
     * Getter for size.
     * @return int size.
     */
    public int size() {
        return size;
    }

    /**
     * Getter for capacity.
     * @return int capacity.
     */
    private int getCapacity() {
        return buckets.length;
    }

    /**
     * Getter for HashCode of a key.
     * @param key to get hash from.
     * @return int HashCode.
     */
    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    /**
     * String representation of the HashMap.
     * @return String
     */
    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (LList<Pair> list : buckets) {	
			sb.append("[");	
			if (list != null) {
				sb.append(list.listToString());
			}
			sb.append(", ");	  
			sb.append("]");
		}
		return "{" + sb.toString() + "}";
	}

	
    /**
     * This method inserts a key value pair into the HashMap.
     * Cost: O(1) on average, and O(n) worst case
     * @param key to put in HashMap.
     * @param value to put in HashMap.
     */
    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
    	
    	int hti = key.hashCode() % getCapacity(); //hti stands for hash table index
    	
    	if(buckets[hti]==null) 
    	{
    		buckets[hti] = new LList<>();
    		buckets[hti].insertFirst(new Pair<>(key,value));
 
    	}
    	else 
    	{
    		Node<Pair> current = buckets[hti].getFirst();
    		
    		while(current != null) 
    		{
    			if(current.getValue().getKey().equals(key)) 
    			{
    				current.getValue().setValue(value);
    				size--;
    				break;
    			}
    			current = current.getNext();
    		}
    		
    	}
    	buckets[hti].insertFirst(new Pair<>(key,value));
		size++;
 
    }


	/**
	 * This method returns the value for a specific key.
	 * Cost: O(1) on average, and O(n) worst case
     * @param key to put in HashMap.
     * @return value to returned from HashMap.
	 */
	@SuppressWarnings("unchecked")
	public V get(K key) {
		
		int hti = key.hashCode() % getCapacity();
		
		if(buckets[hti] == null) 
		{
			return null;
		}
		else 
		{
			
			Node<Pair> current = buckets[hti].getFirst();
			
    		while(current != null) 
    		{
    			Pair<K,V> p = current.getValue();
    			
    			if(p.getKey().equals(key)) 
    			{
    				
    				return p.getValue();
    			
    			}
    			current = current.getNext();
    		}
		}
		return null;

	}
	

	/**
	 * Main method used for testing.
	 * @param args Command line arguments.
	 */
	public static void main(String args[]) {
		HashMap<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10000; i++) {
			map.put(i, "Val" + i);

			
		}

		if (map.size() == 10000) {
			System.out.println("Yay1");
		}
		
		if (map.get(5).equals("Val5") && map.get(500).equals("Val500") &&
			map.get(5000).equals("Val5000") && map.get(9999).equals("Val9999")) {
			System.out.println("Yay2");
		}
		
		map.put(0, "Val" + 0);
		if (map.size() == 10000) {
			System.out.println("Yay3");
		}

	}

}