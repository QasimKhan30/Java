
public class MoldedCookies extends Cookies{

	/**
	 * This method calculates the price of all the ingredients it takes to make molded cookies
	 * @return double the total cost of all the ingredients of molded cookies
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
	 * This method creates an array with all the ingredients needed to make molded cookies
	 * @return Ingredient[] an array of ingredients 
	 */
	@Override
	public Ingredient[] ingredientsNeeded() 
	{
		Ingredient[] ingredientsList = {Ingredient.Flour, Ingredient.Sugar, Ingredient.BakingSoda, Ingredient.BakingPowder, Ingredient.Milk, Ingredient.Cream, Ingredient.Butter};
		return ingredientsList;
	}
	
	/**
	 * This method returns the name of the dessert
	 * @return String name of dessert
	 */
	@Override
	public String description() 
	{
		return "Molded Cookies";
	}
}
