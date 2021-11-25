

/**
 * Dynamic Array Implementation.
 * @author Qasim Khan.
 * @param <T> Generic data type which will occupy the Column.
 */
public class Column<T> {

	/**
	 * default initial capacity / minimum capacity.
	 */
	private static final int DEFAULT_CAPACITY = 2;

	/**
	 * underlying array for storage.
	 */
	private T[] data;

	/**
	 * used to track the amount of items in array.
	 */
	private int size = 0;

	/**
	 * Default Constructor for the column.
	 */
	@SuppressWarnings("unchecked")
	public Column() {
		// Constructor

		// Initial capacity of the storage should be DEFAULT_CAPACITY
		// Hint: Can't remember how to make an array of generic Ts? It's in the textbook...
		data = (T[])new Object[DEFAULT_CAPACITY];

	}

	/**
	 * Constructor that initializes a column with a specified capacity.
	 * @param initialCapacity to set column to.
	 */
	@SuppressWarnings("unchecked")
	public Column(int initialCapacity) {
		// Constructor

		// Initial capacity of the storage should be initialCapacity

		// Throw IllegalArgumentException if initialCapacity is smaller than 1
		// Use this _exact_ error message for the exception
		// (quotes are not part of the message):
		//    "Capacity must be positive."

		data = (T[])new Object[initialCapacity];

		if(initialCapacity < 1) 
		{
			throw new IllegalArgumentException("Capacity must be positive.");
		}

	}


	/**
	 * This method returns the number of items in an array.
	 * @return size of column.
	 */
	public int size() {	
		// O(1)

		return size; 
	}  

	/**
	 * This method returns the total capacity of an array.
	 * @return max number of elements before expansion.
	 */
	public int capacity() { 
		// O(1)

		return data.length; //default return, make sure to remove/change
	}


	/**
	 * This method changes the item at the given index to be the given value.
	 * @param index where the item is to be placed.
	 * @param value to be placed at specified index.
	 * @return value that was replaced.
	 */
	public T set(int index, T value) {
		// O(1)

		if(index > data.length || index < 0) 
		{
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds!");

		}
		T temp = data[index];
		data[index] = value;
		return temp; //default return, make sure to remove/change

	}

	/**
	 * This method returns the item at the given index.
	 * @param index of item we want.
	 * @return item at specified index.
	 */
	public T get(int index) {
		// O(1)
		if(index > data.length||index < 0)
		{
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds!");
		}
		if(index > size && index < this.capacity()) 
		{
			return null;
		}

		return data[index]; 

	}

	/**
	 * This method appends an element to the end of storage.
	 * Doubles the capacity if there is no space available.
	 * @param value to be added into column.
	 */
	@SuppressWarnings("unchecked")
	public void add(T value) {
		// Amortized O(1)
		if(size == this.capacity()) 
		{
			T[] temp = (T[])new Object[size*2];

			for(int i = 0 ; i < data.length ; i ++) 
			{
				temp[i] = data[i];
			}
			data = temp;
		}

		data[size++] = value;




	} 

	/**
	 * This method inserts the given value at the given index.
	 * @param index where we want to add out value.
	 * @param value to be added at specified index.
	 */
	@SuppressWarnings("unchecked")
	public void add(int index, T value) {
		// O(N) where N is the number of elements in the storage

		if(index < 0 || index > size) 
		{
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds!");
		}

		//if the data array does not have enough capacity to add

		if(size == data.length) 
		{

			T[] temp = (T[])new Object[size*2];


			for(int i = 0 ; i < index ; i++) 
			{
				temp[i] = data[i];
			}

			temp[index] = value;



			for (int i = index ; i < size; i++) 
			{
				temp[i +1] = data[i];
			}
			data = temp;

		}

		//if the data spot is NOT null

		else if(data[index] != null) 
		{

			for(int i = size; i > index ; i--) 
			{
				data[i]= data[i-1];
			}
			data[index] = value;
		}
		else 
		{
			data[index] = value;
		}

		size++;

	} 


	/**
	 * This method deletes an item at a certain index and returns it.
	 * @param index the index at which the item should be deleted.
	 * @return T item which was deleted.
	 */
	@SuppressWarnings("unchecked")
	public T delete(int index) {


		if(index < 0 || index > size) 
		{
			throw new IndexOutOfBoundsException("Index: " + index + " out of bounds!");
		}
		T removedValue = data[index];


		if(size() -1 <= (data.length-1)/3 && ((data.length-1)/3) >= DEFAULT_CAPACITY)
		{


			T[] temp = (T[])new Object[data.length/2];

			for(int i = 0 ; i < size() ; i ++) 
			{
				if(i == index) 
				{

					i++;
					size--;
					continue;
				}
				temp[i] = data[i];
			}

			data = temp;
		}
		else {
			data[index] = null;
			for (int i = index ; i < size - 1; i++) 
			{
				data[i] = data[i+1];
				data[i+1] = null;

			}
			size--;
		}



		return removedValue; 

	}  





	//******************************************************
	//*******     BELOW THIS LINE IS TESTING CODE    *******
	//*******      Edit it as much as you'd like!    *******
	//*******		Remember to add JavaDoc			 *******
	//******************************************************

	/**
	 * String representation of array.
	 * @return String representation of column object.
	 */
	public String toString() {
		//This method is provided for debugging purposes
		//(use/modify as much as you'd like), it just prints
		//out the column for easy viewing.
		StringBuilder s = new StringBuilder("Column with " + size()
										 + " items and a capacity of " + capacity() + ":");
		for (int i = 0; i < size(); i++) {
			s.append("\n  ["+i+"]: " + get(i));
		}
		return s.toString();

	}

	/**
	 * main method used for testing.
	 * @param args command line arguments.
	 */
	public static void main(String args[]){
		//These are _sample_ tests. If you're seeing all the "yays" that's
		//an excellent first step! But it might not mean your code is 100%
		//working... You may edit this as much as you want, so you can add
		//own tests here, modify these tests, or whatever you need!

		//create a column of integers
		Column<Integer> nums = new Column<>();
		if((nums.size() == 0) && (nums.capacity() == 2)){
			System.out.println("Yay 1");
		}

		//append some numbers 
		for(int i = 0; i < 3; i++) {
			nums.add(i*2);
		}

		if(nums.size() == 3 && nums.get(2) == 4 && nums.capacity() == 4){
			System.out.println("Yay 2");
		}

		//create a column of strings
		Column<String> msg = new Column<>();

		//insert some strings
		msg.add(0,"world");
		msg.add(0,"hello");
		msg.add(1,"new");
		msg.add(3,"!");


		//checking


		if (msg.get(0).equals("hello") && msg.set(1,"beautiful").equals("new") 
				&& msg.size() == 4 && msg.capacity() == 4){
			System.out.println("Yay 3");
		}


		//delete 
		if (msg.delete(1).equals("beautiful") && msg.get(1).equals("world")  
				&& msg.size() == 3 ){
			System.out.println("Yay 4");
		}

		//shrinking
		nums.add(100);
		nums.add(0, -10);


		if (nums.delete(0) == -10 && nums.delete(1) == 2 && nums.delete(2) == 100
				&& nums.size() == 2 && nums.capacity() == 4) {
			System.out.println("Yay 5");
		}
	}

}