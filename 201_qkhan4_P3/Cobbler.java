
public class Cobbler extends Pastry{

	/**
	 * This method calculates the price of all the ingredients it takes to make a cobbler
	 * @return double the total cost of all the ingredients of cobbler
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
	 * This method creates an array with all the ingredients needed to make cobbler
	 * @return Ingredient[] an array of ingredients 
	 */
	@Override
	public Ingredient[] ingredientsNeeded() 
	{
		Ingredient[] ingredientsList = {Ingredient.Fruit, Ingredient.Sugar, Ingredient.Salt, Ingredient.Butter, Ingredient.Flour, Ingredient.BakingPowder, Ingredient.Milk, Ingredient.Cinnamon};
		return ingredientsList;
	}
	/**
	 * This method returns the name of the dessert
	 * @return String name of dessert
	 */
	@Override
	public String description() 
	{
		return "Cobbler";
	}
}
