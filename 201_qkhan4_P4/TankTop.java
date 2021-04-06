
/**
 * @author qasimkhan
 * Tank Top class that extends Tops
 */
public class TankTop extends Tops{
	
	/**
	 * Private field String strapType is defined
	 */
	private String strapType;
	
	/**
	 * @param strapType
	 * @param size
	 * @param color
	 * Constructor for Tank Top
	 */
	public TankTop(String strapType, int size, String color) 
	{
		super("Tank Top",size,color);
		this.strapType = strapType;
	}
	/**
	 * @return String type
	 * Getter for Type
	 */
	public String getType() 
	{
		return "Tank Top";
	}
	/**
	 * @return String
	 * Getter for Strap Type
	 */
	public String getStrapType() 
	{
		return strapType;
	}
	/**
	 * @param strapType
	 * Setter for strap type
	 */
	public void setStrapType(String strapType) 
	{
		this.strapType = strapType;
	}
	/**
	 *@return String representation of Tank Top
	 */
	@Override
	public String toString() 
	{
		String s = super.toString();
		return s + " Strap Type: " + getStrapType();
	}

}
