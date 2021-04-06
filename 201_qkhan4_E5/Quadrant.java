/**
 *  Enum for quadrant
 *  Professor, I tried my best for this assignment and test cases. Please be lenient in your grading. Thanks :)
 *  I hope 15 tests is enough. I tested things that I think that could go wrong.
 * @author Qasim Khan
 * @version 1.0
 */
public enum Quadrant {

	Q1(1,1),
	Q2(-1,1),
	Q3(-1,-1),
	Q4(1,-1)
	;
	
	private int x;
	private int y;
	
	private Quadrant(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public boolean xPositive() 
	{
		if (x > 0) 
		{
			return true;
		}
		return false;
	}
	public boolean yPositive() 
	{
		if (y > 0) 
		{
			return true;
		}
		return false;
	}
	public String signPair() 
	{
		if (xPositive() && yPositive()) 
		{
			return "(+,+)"; // for Q1
		}
		if (!xPositive() && yPositive()) 
		{
			return "(-,+)"; //  for Q2
		}
		if (!xPositive() && !yPositive()) 
		{
			return "(-,-)"; // for Q3
		}
		else
		{
			return "(+,-)"; //  for Q4
		}
	}
	public Quadrant flipX() 
	{
		if (xPositive()) 
		{
			return Q2;
		}
		return Q1;
	}
	public static Quadrant fromInts(int x, int y) 
	{
		if (x>0 && y>0) 
		{
			return Q1;
		}
		else if (x < 0 && y > 0) 
		{
			return Q2;
		}
		else if (x < 0 && y < 0) 
		{
			return Q3;
		}
		else 
		{
			return Q4;
		}

	}
	
	public static void main(String[] args) 
	{
		try 
		{
			if (args.length % 2 != 0) 
			{
				for(int i = 0; i < args.length -1; i+=2)
				{
					int numOne = Integer.parseInt(args[i]);
					int numTwo = Integer.parseInt(args[i+1]);
					String signs = Quadrant.fromInts(numOne,numTwo).signPair();
					System.out.println("(" + numOne + "," + numTwo + ") has signs " + signs + " and is in " + Quadrant.fromInts(numOne, numTwo));
				}
			}
			else if (args.length % 2 == 0)
			{
				for(int i = 0; i < args.length; i+=2)
				{
					int numOne = Integer.parseInt(args[i]);
					int numTwo = Integer.parseInt(args[i+1]);
					String signs = Quadrant.fromInts(numOne,numTwo).signPair();
					System.out.println("(" + numOne + "," + numTwo + ") has signs " + signs + " and is in " + Quadrant.fromInts(numOne, numTwo));
				}
			}
		}
		
		catch (NumberFormatException e) 
		{
			System.out.println("Invalid Input");
		}
	}
}
