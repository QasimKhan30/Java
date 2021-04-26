import java.util.LinkedList;
import java.util.Queue;

/**
 * Game Locations class
 * @author qasimkhan
 *
 */
public class GameLocations {
	
	/**
	 * Private variables arrays and Linked list.
	 *
	 */
	private int total;
	private int [][] distance;
	private LinkedList<Location> locations;
	private boolean[] visited;
	
	/**
	 * Constructor for Game Locations
	 * @param total
	 * arrays are set to size total and Linked List is initialized
	 */
	public GameLocations(int total) 
	{
		this.total = total;
		this.distance = new int[total][total];
		this.visited = new boolean[total];
		this.locations = new LinkedList<Location>();
		
	}
	
	/**
	 * Adds location to location linked list and initializes 2d distance array with -1's
	 * @param location
	 */
	public void addLocation(Location location) 
	{
		locations.add(location);
		int indexLocation = locations.indexOf(location) ;
		
		for (int i = 0 ; i <= distance.length -1 ; i ++ ) 
		{
			distance[i][indexLocation] = -1;
		}
		for (int i = 0 ; i <= distance.length -1 ; i ++ ) 
		{
			distance[indexLocation][i] = -1;
		}

		
	}
	
	/**
	 * Adds distance value to specific spot in distance array
	 * @param from Location
	 * @param to Location
	 * @param dist int distance
	 */
	public void addDistance(Location from, Location to, int dist) 
	{
		int row = locations.indexOf(from);
		int col = locations.indexOf(to);
		distance[row][col] = dist;
		
	}
	
	/**
	 * Finds the distance between two locations
	 * @param from Location first location
	 * @param to Location second location
	 * @return int distance between two locations
	 */
	public int distanceIs(Location from, Location to) 
	{
		int row = locations.indexOf(from);
		int col = locations.indexOf(to);
		return distance[row][col];
	}
	
	/**
	 * Marks a location as visited in the visited array of booleans
	 * @param location Location visited
	 * @param bool true or false
	 */
	public void markAsVisited(Location location, boolean bool) 
	{
		int index = locations.indexOf(location);
		visited[index] = bool;
	}
	
	/**
	 * Checks whether a location has been visited or not
	 * @param location
	 * @return boolean true if visited false otherwise
	 */
	public boolean haveVisited(Location location) 
	{

		return visited[locations.indexOf(location)];
	}
	
	/**
	 * Fills a queue with locations that can be visited by a certain location
	 * @param location
	 * @return
	 */
	public Queue<Location> directDestinations(Location location)
	{
		Queue<Location> locQueue = new LinkedList<Location>();
		int row = locations.indexOf(location);
		for (int i = 0 ; i < distance[row].length ; i ++) 
		{
			if(distance[row][i]!= -1) 
			{
				locQueue.add(locations.get(i));
			}
		}	
		return locQueue;
	}

}
