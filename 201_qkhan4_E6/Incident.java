import java.util.Date;

public class Incident {
	
	static int code = 1;
	private String incidentID;
	private Date datetime;
	private Address location;
	private String description;
	private int sector;
	
	public Incident(Address location, String description, int sector) throws PrecinctException 
	{
		incidentID = "REPORT000" + code;
		if ((sector < 0) || (sector > 4)) 
		{
			throw new PrecinctException("invalid sector number for " + incidentID); 
		}
		this.location = location;
		this.description = description;
		this.sector = sector;
		datetime = new Date();
		
		code++;
	}
	
	
	public String getID() {
		return incidentID;
	}


	public void setID(String incidentID) {
		this.incidentID = incidentID;
	}


	public Date getDateTime() {
		return datetime;
	}


	public void setDateTime(Date datetime) {
		this.datetime = datetime;
	}


	public Address getLocation() {
		return location;
	}


	public void setLocation(Address location) {
		this.location = location;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getSector() {
		return sector;
	}


	public void setSector(int sector) {
		this.sector = sector;
	}

	
	@Override
	public String toString() 
	{
		return "Incident: " + incidentID + " Incident Date: " + datetime + " Location: " + location + 
				" Sector: " + sector + " Description: " + description;
	}
}
