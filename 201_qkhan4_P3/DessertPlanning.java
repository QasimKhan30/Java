import java.util.ArrayList;

/**
 * @author qasimkhan
 *
 */
public class DessertPlanning {
	
	private Dessert dessert;
	private ArrayList<String> newIngredients;
	private ArrayList<Double> newPrices;

	
	/**
	 * This constructor creates instances of the variables defined above
	 * @param dessert
	 */
	public DessertPlanning(Dessert dessert) 
	{
		this.dessert = dessert;
		newIngredients = new ArrayList<String>();
		newPrices = new ArrayList<Double>();
	}
	
	/**
	 * This method is used to print all of the base ingredients needed to make a desert
	 */
	public void printBaseIngredients() 
	{
		System.out.println(dessert.description() + " Base Ingredients: ");

		for (int i = 0 ; i < dessert.ingredientsNeeded().length ; i++) 
		{
			String formattedNum = String.format("%.02f",dessert.ingredientsNeeded()[i].getPrice());
			System.out.println("" + dessert.ingredientsNeeded()[i] + " $" + formattedNum );
		}
	}
	
	/**
	 * This method prints the base cost of all the ingredients needed to make a dessert
	 */
	public void printBasePrice() 
	{
		double total = 0;
		for (int i = 0 ; i < dessert.ingredientsNeeded().length ; i++) 
		{
			total += dessert.ingredientsNeeded()[i].getPrice();
		}
		String formattedTotal = String.format("%.02f", total);
		System.out.println("Base Cost: $" + formattedTotal);
	}
	
	/**
	 * This method adds an ingredient and its price to our array lists
	 * @param ingredient which will be added to an Array list of new ingredients
	 * @param price the price of the ingredient that we are adding to the Ingredient Array. is stored in a seperate array for prices
	 */
	public void addNewIngredient(String ingredient, Double price) 
	{
		newIngredients.add(ingredient);
		newPrices.add(price);
	}
	
	/**
	 * @param ingredient which will be removed from our arrays
	 * @return boolean true if ingredient is removed and false if ingredient is not removed
	 */
	public boolean removeNewIngredient(String ingredient) 
	{
		int index = -1;
		for (int i = 0 ; i < newIngredients.size(); i++) 
		{
			if (newIngredients.get(i).equals(ingredient)) 
			{
				index = i;
				break;
			}
		}
		if (index == -1) 
		{
			return false;
		}
		newIngredients.remove(index);
		newPrices.remove(index);
		return true;
	}
	
	/**
	 * This method prints all ingredients. Base and new
	 */
	public void printAllIngredients()  // FIXME
	{
		printBaseIngredients();
		System.out.println("New Ingredients: ");
		
		for (int i = 0 ; i < newIngredients.size() ; i++) 
		{
			System.out.println(newIngredients.get(i) + " $" + newPrices.get(i));
		}
	}
	
	/**
	 * This method prints the total price of all ingredients. Base and new
	 */
	public void printTotalPrice()  //FIXME
	{
		double total = 0;
		
		for (int i = 0 ; i < dessert.ingredientsNeeded().length ; i++) 
		{
			total += dessert.ingredientsNeeded()[i].getPrice();
		}
		
		for (int i = 0 ; i < newPrices.size(); i++) 
		{
			total += newPrices.get(i);
		}
		String formattedTotal = String.format("%.02f", total);
		System.out.println("Total Cost: $" + formattedTotal);
	}
}
