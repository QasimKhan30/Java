
/**
 * @author qasimkhan
 *
 * @param <Type1>
 * @param <Type2>
 * Generic class Label with two generic parameters
 */
public class Label <Type1,Type2> {

	
	/**
	 * Private Generic fields key and value are defined
	 */
	private Type1 key;
	private Type2 value;
	
	/**
	 * @param key
	 * @param value
	 * Constructor for label
	 */
	public Label(Type1 key, Type2 value) 
	{
		this.key = key;
		this.value = value;
	}

	/**
	 * @return key 
	 * getter for key
	 */
	public Type1 getKey() {
		return key;
	}

	/**
	 * @param key
	 * Setter for key
	 */
	public void setKey(Type1 key) {
		this.key = key;
	}

	/**
	 * @return value
	 * Getter for value
	 */
	public Type2 getValue() {
		return value;
	}

	/**
	 * @param value
	 * Setter for value
	 */
	public void setValue(Type2 value) {
		this.value = value;
	}
	
	
}
