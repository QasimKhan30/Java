
/**
 * @author qasimkhan
 * 
 */
public class Location {

	/**
	 * Private String variables for location name and description
	 */
	private String locName;
	private String locDesc;
	
	/**
	 * Constructor for Location
	 * @param locName
	 * @param locDesc
	 */
	public Location(String locName, String locDesc) 
	{
		this.locName = locName;
		this.locDesc = locDesc;
	}

	/**
	 * Getter for location name
	 * @return String location name
	 */
	public String getLocName() {
		return locName;
	}

	/**
	 * Setter for location name
	 * @param locName
	 */
	public void setLocName(String locName) {
		this.locName = locName;
	}

	/**
	 * Getter for location description
	 * @return String location description
	 */
	public String getLocDesc() {
		return locDesc;
	}

	/**
	 * Setter for location description
	 * @param locDesc 
	 */
	public void setLocDesc(String locDesc) {
		this.locDesc = locDesc;
	}
	
	/**
	 * String representation of location object
	 */
	@Override
	public String toString() 
	{
		return locName + "(" + locDesc + ")";
	}

}
