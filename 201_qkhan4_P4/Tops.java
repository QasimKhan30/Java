
/**
 * @author qasimkhan
 * Abstract class tops that implemnts Clothing
 *
 */
public abstract class Tops implements Clothing{
	
	/**
	 * Private fields String type,color and int size are defined
	 */
	private String type;
	private int size;
	private String color;
	
	/**
	 * @param type
	 * @param size
	 * @param color
	 * Constructor for Tops
	 */
	public Tops(String type, int size, String color) 
	{
		this.type = type;
		this.size = size;
		this.color = color;
	}

	/**
	 * Getter for type
	 */
	public String getType() {
		return type;
	}
	
	
	/**
	 * @param type
	 * Setter for type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter for size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 * Setter for size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Getter for color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 * Setter for color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 *@return String representation of Tops
	 */
	@Override
	public String toString() 
	{
		return "Type: " + getType() + " Size: " + getSize() + " Color: " + getColor();
	}

}
