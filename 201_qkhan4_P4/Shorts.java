
/**
 * @author qasimkhan
 * Shorts class extended from Pants
 *
 */
public class Shorts extends Pants{
	
	/**
	 * Private String type is set equal to Shorts
	 */
	private final String type = "Shorts";
	
	/**
	 * @param size
	 * @param color
	 * @param fit
	 * Constructor for shorts
	 */
	public Shorts( int size, String color, String fit) 
	{
		super("", size, color, fit);
	}
	
	/**
	 * Getter for type
	 */
	@Override
	public String getType() 
	{
		return type;
	}

}
