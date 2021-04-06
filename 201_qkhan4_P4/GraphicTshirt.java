
/**
 * @author qasimkhan
 * Graphic T-Shirt class that extends from Tops
 *
 */
public class GraphicTshirt extends Tops{
	
	
	/**
	 * Private fields Graphic information and String type are defined
	 */
	private Graphic info;
	private final String type = "Graphic T-Shirt";
	
	/**
	 * @param info
	 * @param size
	 * @param color
	 * Constructor for Graphic T-Shirt
	 */
	public GraphicTshirt(Graphic info, int size, String color) 
	{
		super("",size,color);
		this.info = info;
	}
	
	/**
	 * getter for Type of Graphic T-Shirt
	 */
	public String getType() 
	{
		return type;
	}

	/**
	 * String Reprensentation of Graphic T-Shirt is returned
	 */
	@Override
	public String toString() 
	{
		String s = super.toString();
		return s + " Graphic Style: " + info.getStyle() + " Graphic Description: " + info.getDescription();
	}
}
