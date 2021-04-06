
/**
 * @author qasimkhan
 * Clothing Exception class that extends Exception
 */
public class ClothingException extends Exception{
	
	/**
	 * Constructor that calls Exceptions constructor
	 */
	public ClothingException() 
	{
		super();
	}
	
	/**
	 * @param s
	 * Clothing Exception Constructor with a string argument that calls the same constructor for Exception
	 */
	public ClothingException(String s) 
	{
		super(s);
	}

}
