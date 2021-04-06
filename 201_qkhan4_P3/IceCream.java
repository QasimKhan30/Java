
public class IceCream extends FrozenDessert{

	/**
	 * This method calculates the price of all the ingredients it takes to make an ice cream
	 * @return double the total cost of all the ingredients of ice cream
	 */
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
	
	/**
	 * This method creates an array with all the ingredients needed to make ice cream
	 * @return Ingredient[] an array of ingredients 
	 */
	@Override
	public Ingredient[] ingredientsNeeded() 
	{
		Ingredient[] ingredientsList = {Ingredient.Milk, Ingredient.Sugar, Ingredient.Gelatin, Ingredient.Eggs, Ingredient.Flavoring};
		return ingredientsList;
	}
	
	/**
	 * This method returns the name of the dessert
	 * @return String name of dessert
	 */
	@Override
	public String description() 
	{
		return "Ice Cream";
	}
}
