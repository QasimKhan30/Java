import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * GameWorld Class
 * @author qasimkhan
 *
 */
public class GameWorld {

	/**
	 * Private GameLocation object locations and 2d arraylist of Locations called paths
	 */
	private GameLocations locations;
	private ArrayList<ArrayList<Location>> paths;
	private ArrayList<Location> temp = new ArrayList<Location>();



	/**
	 * Constructor for GameWorld
	 * @param locations
	 */
	public GameWorld(GameLocations locations) 
	{
		this.locations = locations;
		paths = new ArrayList<ArrayList<Location>>();
	}

	/**
	 * This method calls findAllPaths to populate the paths 2d ArrayList and prints all the paths with distance between two locations
	 * @param current
	 * @param destination
	 */
	public void printPaths(Location current, Location destination) //calls find all paths
	{
		int count = 1;
		ArrayList<Location> arr = new ArrayList<Location>();

		findAllPaths(current,destination,arr);
		for (ArrayList<Location> path : paths) 
		{

			System.out.print("Path " + count + ": ");

			for (int i = 0 ; i < path.size(); i++) 
			{


				System.out.print(path.get(i));
				if (i != path.size()-1) 
				{
					System.out.print("--" + locations.distanceIs(path.get(i), path.get(i+1)) + "->");
				}
			}
			count++;
			System.out.println();

		}
	}

	/**
	 * Finds all the possible paths between two locations and adds them to the 2d array list paths
	 * @param locOne
	 * @param locTwo
	 * @param path
	 */
	public void findAllPaths(Location locOne, Location locTwo, ArrayList<Location> path) 
	{
		path.add(locOne);

		if (locOne.equals(locTwo)) 
		{
			ArrayList<Location> tempPath = new ArrayList<Location>();

			for (Location ll : path) 
			{
				tempPath.add(ll);
			}

			paths.add(tempPath);
			
			path = new ArrayList<Location>();
		}
		else 
		{
			for(Location location : locations.directDestinations(locOne)) 
			{
				if (!(locations.haveVisited(location))) 
				{
					locations.markAsVisited(locOne, true);

					findAllPaths(location,locTwo,path);			//RECURSIVE CALL	

					temp.add(location);

					for(Location l : temp) 
					{
						locations.markAsVisited(l, false);
						path.remove(l);
					}
					temp.clear();
				}
			}
		}
	}
}

