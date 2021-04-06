
/**
 * @author qasimkhan
 * Jeans class that extends from Pants
 */
public class Jeans extends Pants{

	/**
	 * Private field Jeanfit called jeanfit
	 */
	private JEANFIT jeanfit;
	
	/**
	 * @param size
	 * @param color
	 * @param jeanfit
	 * Constructor for jeans
	 */
	public Jeans(int size, String color, JEANFIT jeanfit) 
	{
		super("Jeans", size, color,"");
		this.jeanfit = jeanfit;
		
	}
	
	/**
	 * @return String type of Jeans
	 */
	@Override
	public String getType() 
	{
		return "Jeans";
	}
	
	
	/**
	 * @return String fit of jeans
	 */
	@Override
	public String getFit() 
	{
		return jeanfit.toString();
	}
}
