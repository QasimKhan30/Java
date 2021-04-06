
public class Pie extends Pastry{
	
	public PieType type;
	
	public Pie() 
	{
		type = PieType.Cream;
	}
	
	public Pie(PieType type) 
	{
		this.type = type;
	}
	
	@Override
	public double baseCost() 
	{
		double total = 0;
		Ingredient[] ingredients = this.ingredientsNeeded();
		
		for (int i = 0 ; i < ingredients.length; i++) 
		{
			total += ingredients[i].getPrice();
		}
		return total;
	}

	@Override
	public Ingredient[] ingredientsNeeded() 
	{
		return type.getIngredients();
	}
	
	public void setPieType(PieType type) 
	{
		this.type = type;
	}
	
	public PieType getPieType() 
	{
		return type;
	}
	
	public String description() 
	{
		String output = "";
		output += type.name() + " Pie";
		return output;
	}

	
}
