import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author qasimkhan
 * Inside Closet class
 */
public class InsideCloset {
	
	/**
	 * Private Field an Array List consisting of labels which consist of a String Type and Clothing article
	 */
	private ArrayList< Label<String,Clothing> > myCloset = new ArrayList< Label<String,Clothing> >();
	
	/**
	 * Constructor that reads Clothing objects off of a file and then stores them as Labels into an array list
	 * @param filename
	 */
	public InsideCloset(String filename) 
	{
		
		try 
		{
			Scanner input = new Scanner(new File(filename));
			
			while(input.hasNextLine()) 
			{
				String color = "";
				String [] line = input.nextLine().split(",", 0);
				
				if(line[0].equals("Graphic T-Shirt"))
				{
					Graphic info = new Graphic(line[1],line[2]);
					
					for (int i = 3 ; i < line.length -1 ; i++) 
					{
						color += line[i];
						
						if (i != line.length-2) 
						{
							color += " ";
						}
					}
					
					GraphicTshirt gtshirt = new GraphicTshirt(info,Integer.parseInt(line[line.length-1]),color);
					
					Label<String,Clothing> label = new Label<String,Clothing>("Graphic T-Shirt", gtshirt); //SHOULD LABEL BE TYPE STRING GRAPHIC TSHIRT OR TYPE STRING AND CLOTHING
					
					myCloset.add(label);
					

				}
				else if(line[0].equals("Tank Top"))
				{
					String strap = line[1];
					for (int i = 2 ; i < line.length -1 ; i++) 
					{
						color += line[i];
						
						if (i != line.length-2) 
						{
							color += " ";
						}
					}
					int size = Integer.parseInt(line[line.length-1]);
					
					TankTop tankTop = new TankTop(strap,size,color);
					
					Label<String,Clothing> label = new Label<String,Clothing>("Tank Top",tankTop);
					myCloset.add(label);
					

				}
				else if(line[0].equals("Jeans"))
				{
					String jeanType = line[1];
				
					if (jeanType.equals("straight")) 
					{
						jeanType = "Straight";
					}
					if (jeanType.equals("skinny")) 
					{
						jeanType = "Skinny";
					}
					if (jeanType.equals("bootcut")) 
					{
						jeanType = "Bootcut";
					}
					
					JEANFIT jean = JEANFIT.valueOf(jeanType);
					
					for (int i = 2 ; i < line.length -1 ; i++) 
					{
						color += line[i];
						
						if (i != line.length-2) 
						{
							color += " ";
						}
					}
					int size = Integer.parseInt(line[line.length-1]);
					
					Jeans jeans = new Jeans(size,color,jean);
					
					Label<String,Clothing> label = new Label<String,Clothing>("Jeans",jeans);
					myCloset.add(label);
					

				}
				else if(line[0].equals("Legging"))
				{
					String fit = line[1];
					for (int i = 2 ; i < line.length -1 ; i++) 
					{
						color += line[i];
						
						if (i != line.length-2) 
						{
							color += " ";
						}
					}
					int size = Integer.parseInt(line[line.length-1]);
					
					Legging legging = new Legging(size,color,fit);
					Label<String,Clothing> label = new Label<String,Clothing>("Legging",legging);
					myCloset.add(label);
					

				}
				else if(line[0].equals("Shorts"))
				{
					String fit = line[1];
					for (int i = 2 ; i < line.length -1 ; i++) 
					{
						color += line[i];
						
						if (i != line.length-2) 
						{
							color += " ";
						}
					}
					int size = Integer.parseInt(line[line.length-1]);
					
					Shorts shorts = new Shorts(size,color,fit);
					Label<String,Clothing> label = new Label<String,Clothing>("Shorts",shorts);
					myCloset.add(label);
					

				}
				else if(line[0].equals("Sweater"))
				{
					String sweaterStyle = line[1];
					
					if (sweaterStyle.equals("cardigan")) 
					{
						sweaterStyle = "Cardigan";
					}
					if (sweaterStyle.equals("pullover")) 
					{
						sweaterStyle = "Pullover";
					}
					if (sweaterStyle.equals("shrug")) 
					{
						sweaterStyle = "Shrug";
					}
					
					SWEATERTYPE sweaterType = SWEATERTYPE.valueOf(sweaterStyle);
					
					for (int i = 2 ; i < line.length -1 ; i++) 
					{
						color += line[i];
						
						if (i != line.length-2) 
						{
							color += " ";
						}
					}
					int size = Integer.parseInt(line[line.length-1]);
					Sweater sweater = new Sweater(sweaterType, size, color);
					Label<String,Clothing> label = new Label<String,Clothing>("Sweater",sweater);
					myCloset.add(label);
					

					
				}
				else 
				{
					throw new ClothingException("invalid item");
				}
			}
			input.close();
			
		}
		catch(FileNotFoundException e) 
		{
			
		}
		catch(ClothingException e) //DO I NEED THIS IF I HAVE THE LAST ELSE BLOCK
		{
	
		}
	}
	
	/**
	 * Every article of clothing in the closet is printed
	 */
	public void printWholeCloset() 
	{
		for (Label label : myCloset) 
		{
			System.out.println(label.getValue());
		}
	}
	/**
	 * @param key article of clothing
	 * @throws ClothingException if key not found
	 * Prints specific brands on clothing based on key given
	 */
	public void printSpecificClothing(String key) throws ClothingException
	{
		
		if (key.equals("Graphic T-Shirt") || key.equals("Jeans") || key.equals("Legging") || key.equals("Shorts") || 
			key.equals("Sweater") || key.equals("Tank Top")) 
			{
				for (Label label : myCloset) 
				{

					if(label.getKey().equals(key)) 
					{
						System.out.println(label.getValue());
					}

				}
			}
		else {throw new ClothingException("invalid item");}
	
	}
	/**
	 * Organizes the closet in the order: Graphic T-Shirt, Jean, legging, shorts, sweater, tank top.
	 * @return ArrayList <Clothing > of organized closet
	 */
	public ArrayList<Clothing> organizedCloset()
	{
		ArrayList<Clothing> clothingArrayList = new ArrayList<Clothing>();
		ArrayList<Clothing> graphicTshirtArrayList = new ArrayList<Clothing>();
		ArrayList<Clothing> jeanArrayList = new ArrayList<Clothing>();
		ArrayList<Clothing> leggingArrayList = new ArrayList<Clothing>();
		ArrayList<Clothing> shortsArrayList = new ArrayList<Clothing>();
		ArrayList<Clothing> sweaterArrayList = new ArrayList<Clothing>();
		ArrayList<Clothing> tankTopArrayList = new ArrayList<Clothing>();
		
		for (Label label : myCloset) 
		{

			if (label.getKey().equals("Graphic T-Shirt")) 
			{
				graphicTshirtArrayList.add((Clothing)label.getValue());

			}
			
			else if (label.getKey().equals("Jeans")) 
			{
				jeanArrayList.add((Clothing)label.getValue());

			}
			
			else if (label.getKey().equals("Legging")) 
			{
				leggingArrayList.add((Clothing)label.getValue());

			}
			
			else if (label.getKey().equals("Shorts")) 
			{
				shortsArrayList.add((Clothing)label.getValue());

			}
			
			else if (label.getKey().equals("Sweater")) 
			{
				sweaterArrayList.add((Clothing)label.getValue());

			}
			
			else if (label.getKey().equals("Tank Top")) 
			{
				tankTopArrayList.add((Clothing)label.getValue());

			}
		}
			
			for (Clothing tShirt : graphicTshirtArrayList) 
			{
				clothingArrayList.add(tShirt);
			}
			
			for (Clothing jeans : jeanArrayList) 
			{
				clothingArrayList.add(jeans);
			}
			
			for (Clothing legging : leggingArrayList) 
			{
				clothingArrayList.add(legging);
			}
			
			for (Clothing shorts : shortsArrayList) 
			{
				clothingArrayList.add(shorts);
			}
			
			for (Clothing sweater : sweaterArrayList) 
			{
				clothingArrayList.add(sweater);
			}
			
			for (Clothing tanktop : tankTopArrayList) 
			{
				clothingArrayList.add(tanktop);
			}
	
		return clothingArrayList;
	}
	
	
	/**
	 * This method checks if the item provided is a top or a bottom. If it is a top it provides all the bottoms that have the color provided and vice versa.
	 * @param item article of clothing
	 * @param color that is desired
	 * @return ArrayList<Clothing> filled with articles of clothing match with the item and have a specific color
	 * @throws ClothingException
	 */
	public ArrayList<Clothing> colorCoordinate(String item, String color) throws ClothingException
	{
		boolean isTop;
		ArrayList<Clothing> returnArray = new ArrayList<Clothing>();
		ArrayList<Clothing> test = new ArrayList<Clothing>();
		

		if (item.equals("Graphic T-Shirt") || item.equals("Sweater") || item.equals("Tank Top")) 
		{
			isTop = true;
		}
		else if (item.equals("Jeans") || item.equals("Legging") || item.equals("Shorts"))
		{
			isTop = false;
		}
		else 
		{
			throw new ClothingException("invalid item");
		}
			
		//for (Label label : myCloset) 
		
		if (isTop) 
		{
			for (int i = 0 ; i < myCloset.size(); i++)
			{
				Label label = myCloset.get(i);
				

				if (label.getValue() instanceof Pants) 
				{
						
					Clothing cloth = (Clothing)label.getValue();
					
					String [] Colors = cloth.getColor().split(" ");
					//for (String col : Colors) 
					
					test.add(cloth);
					
					for (int j = 0 ; j < Colors.length; j++)
					{
						String col = Colors[j];
						if (col.equals(color)) 
						{
							//System.out.println(color + " is equal to " + col + "and the article of clothign is : " + cloth);
							returnArray.add(cloth);
							break;
						}
					}
					
				}
			}
		}
		if (!isTop) 
		{
			for (int i = 0 ; i < myCloset.size(); i++)
			{
				Label label = myCloset.get(i);
				
				if (label.getValue() instanceof Tops) 
				{
					
						Clothing cloth = (Clothing) label.getValue();
						

						
						
						
						
						String [] Colors = cloth.getColor().split(" ");
						
						
						//for (String col : Colors) 
						for (int j = 0 ; j < Colors.length; j++)
						{
							String col = Colors[j];
							if (col.equals(color)) 
							{
								//System.out.println(color + " is equal to " + col + "and the article of clothign is : " + cloth);
								//System.out.println(cloth);
								returnArray.add(cloth);
								break;
							}
						}
					}
				}
			}
				
			
			if (returnArray.size() == 0) 
			{
				throw new ClothingException("nothing of that color in your closet");
			}
			

		

		return returnArray;


	}
	


}
