
public enum Ingredient {
	
	Eggs(3.48),
	Sugar(2.89), 
	Butter(3.99), 
	Flour(3.24), 
	BakingPowder(1.99), 
	BakingSoda(.85), 
	Flavoring(2.99),
	Fruit(5.50), 
	Salt(.99), 
	Milk(2.72), 
	Cinnamon(2.99), 
	Cream(3.12), 
	YogurtCulture(4.95), 
	Gelatin(3.99)
	;
	
	private double price;
	
	Ingredient(double newCost) 
	{
		price = newCost;
	}
	
	public double getPrice() 
	{
		return price;
	}

	
}



