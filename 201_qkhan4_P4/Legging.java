
/**
 * @author qasimkhan
 * Legging class extends from pants
 */
public class Legging extends Pants{
	
	
	/**
	 * Private field String type
	 */
	private final String type = "Legging";
	
	/**
	 * Constructor for legging
	 * @param size of legging
	 * @param color of legging
	 * @param fit of legging
	 * 
	 */
	public Legging( int size, String color, String fit) 
	{
		super("", size, color, fit);
	}
	/**
	 *@return String type of legging
	 */
	@Override
	public String getType() 
	{
		return type;
	}

}
