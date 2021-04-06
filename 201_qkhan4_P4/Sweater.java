
/**
 * @author qasimkhan
 * Sweater class extends Tops
 *
 */
public class Sweater extends Tops{
	
	/**
	 * Private SWEATERTYPE sweaterType is defined
	 */
	private SWEATERTYPE sweaterType;

	/**
	 * @param sweaterType
	 * @param size
	 * @param color
	 * Constructor for Sweater
	 */
	public Sweater(SWEATERTYPE sweaterType, int size, String color) 
	{
		super("", size, color);
		this.sweaterType = sweaterType;
	}
	
	/**
	 * @return String type
	 * Getter for type
	 */
	@Override
	public String getType() 
	{
		return "Sweater(" + sweaterType + ")";
	}

}
