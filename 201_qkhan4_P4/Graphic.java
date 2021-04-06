
/**
 * @author qasimkhan
 * Graphic Class
 */
public class Graphic {
	
	
	/**
	 * Private field Strings for style and description
	 */
	private String style;
	private String description;
	
	/**
	 * @param style
	 * @param description
	 * Constructor for Graphic class
	 */
	public Graphic(String style, String description) 
	{
		this.style = style;
		this.description = description;
	}

	/**
	 * @return String style of Graphic
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style
	 * Sets the style of the graphic
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return String Description of graphic
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 * Sets the description of graphic
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

}
