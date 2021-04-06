
/**
 * @author qasimkhan
 * Abstract class pants that implements Clothing and Bottoms
 */
public abstract class Pants implements Clothing,Bottoms{

	
	/**
	 * Private fields String type,color, fit and  int size are defined
	 */
	private String type;
	private int size;
	private String color;
	private String fit;
	
	/**
	 * @param type
	 * @param size
	 * @param color
	 * @param fit
	 * Constructor for pants
	 */
	public Pants(String type, int size, String color, String fit) 
	{
		this.type = type;
		this.size = size;
		this.color = color;
		this.fit = fit;
	}

	/**
	 * getter for type of pants
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 * Setter for type of pants
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
	 * setter for size
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
	 * Getter for fit
	 */
	public String getFit() {
		return fit;
	}

	/**
	 * @param fit
	 * Setter for fit
	 */
	public void setFit(String fit) {
		this.fit = fit;
	}
	
	/**
	 * @return String representation of pants
	 */
	@Override
	public String toString() 
	{
		return "Type: " + getType() + " Size: " + getSize() + " Color: " + getColor() + " Fit: " + getFit();
	}
}
