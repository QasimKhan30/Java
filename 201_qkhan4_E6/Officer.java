import java.util.ArrayList;

public class Officer {
	
	private String name;
	private String rank;
	private ArrayList<Incident> incidents;
	
	public Officer(String name, String rank) 
	{
		if (name.equals("") || name == null) 
		{
			throw new OfficerException("Officer name is invalid");
		}
		if ( !rank.equals("Police Officer") && !rank.equals("Detective") && !rank.equals("Captain") && !rank.equals("Sergeant") && !rank.equals("Lieutenant")) 
		{
			throw new OfficerException(" Officer must be one of: Police Officer|Detective|Captain|Sergeant|Lieutenant");
		}
		
		this.name = name;
		this.rank = rank;
		incidents = new ArrayList<Incident>();

	}
	
	public String getName() 
	{
		return name;
	}
	public String getRank() 
	{
		return rank;
	}
	public ArrayList<Incident> getIncidents()
	{
		if (incidents.size() == 0) 
		{
			throw new OfficerException( name + " hasn't reported any incident");
		}
		
		return incidents;
	}
	public void recordIncident(Incident incident) 
	{
		
		try 
		{
			for (Incident inc : incidents) 
			{
				if (inc.getID() == incident.getID()) 
				{
					throw new OfficerException(name + " has already recorded " + incident.getID());
				}
			}
		}
		catch(NullPointerException e) 
		{
			
		}
		finally 
		{
		incidents.add(incident);
		}
	}
	
	public boolean metQuotaCount() throws PrecinctException 
	{
		int secOneIncidents = 0;
		int secTwoIncidents = 0;
		int secThreeIncidents = 0;
		int secFourIncidents = 0;
		if (incidents.size() == 0) 
		{
			throw new OfficerException( name + " hasn't reported any incident");
		}
		
		for (Incident inc: incidents) 
		{
			if (inc.getSector() == 1) 
			{
				secOneIncidents ++;
			}
			if (inc.getSector() == 2) 
			{
				secTwoIncidents ++;
			}
			if (inc.getSector() == 3) 
			{
				secThreeIncidents ++;
			}
			if (inc.getSector() == 4) 
			{
				secFourIncidents ++;
			}
		}
			
			if (secOneIncidents >= PrecinctRecords.minSecReports && secTwoIncidents >= PrecinctRecords.minSecReports &&
				secThreeIncidents >= PrecinctRecords.minSecReports && secFourIncidents >= PrecinctRecords.minSecReports) 
			{
				return true;
			}
			else 
			{
				String s = name + "'s incident reports are less than the minimum required. Recorded: " + secOneIncidents + " report(s) in Sector 1, " + secTwoIncidents + " report(s) in Sector 2, " + secThreeIncidents + " report(s) in Sector 3, " + secFourIncidents + " report(s) in Sector 4.";
						
				throw new PrecinctException(s);
			}
			
		
	}
	
	

}
