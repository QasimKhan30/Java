
public class PrecinctRecords extends NineNineExceptions{
	
	static int minSecReports = 3;
	
	public static void precinct99(Officer[] officerList)
	{
		try 
		{
			System.out.println("All Incidents for Precinct 99");
			for (Officer off : officerList)
			{
				System.out.println(off.getRank() + " " + off.getName());
				for (Incident inc : off.getIncidents()) 
				{
					System.out.println(inc);
				}
				if (off.metQuotaCount()) 
				{
					System.out.println(off.getName() + " has met their quota per sector");
				}
			}
		}

		
		catch (OfficerException e) 
		{
			System.err.println(e);
		}
		catch (PrecinctException e) 
		{
			
			System.err.println(e);
		}

	}
}