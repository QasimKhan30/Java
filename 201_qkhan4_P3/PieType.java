
public enum PieType {
	
	Cream(new Ingredient[] {Ingredient.Milk, Ingredient.Cream, Ingredient.Sugar, Ingredient.Flour, Ingredient.Eggs}),
	
	Fruit(new Ingredient[] {Ingredient.Fruit, Ingredient.Sugar, Ingredient.Salt, Ingredient.Flour, Ingredient.Butter, Ingredient.Eggs}),
	
	Custard(new Ingredient[] {Ingredient.Milk, Ingredient.Cream, Ingredient.Sugar, Ingredient.Eggs})
	;

	
	
	private Ingredient[] ingredients;
	
	PieType(Ingredient[] ingredients)
	{
		this.ingredients = ingredients;
	}

	Ingredient[] getIngredients() 
	{
		return ingredients;
	}

}

/*
Cream Pie: Milk, Cream, Sugar, Flour, Eggs.
Fruit Pie: Fruit, Sugar, Salt, Flour, Butter, Eggs.
Custard Pie: Milk, Cream, Sugar, Eggs.

*/