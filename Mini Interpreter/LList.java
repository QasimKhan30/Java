
/**
 * Linked list implementation.
 * Singly linked list with both head and tail.
 * @author Qasim Khan
 * @param <T> Generic Data type for the stack.
 */
public class LList<T> { 
   	/**
   	 * Node that represents the head of the linked list.
   	 */
   	private Node<T> head;
	/**
	 * Node that represents the tail of the linked list.
	 */
	private Node<T> tail;
	
	/**
	 * variable used to keep track of the number of items in the linked list.
	 */
	private int size = 0; 
	/**
	 * Node used to keep track of the current node being looked at.
	 * Used for iteration.
	 */
	private Node<T> current;


	/**
	 * Linked list constructor which initializes the list to being an empty list.
	 */
	public LList(){
		head = tail;


	}
	
	/**
	 * This method returns the first node in the linked list.
	 * O(1).
	 * @return Node of type T is first node in the list.
	 */
	public Node<T> getFirst() {
		return head;
	}


	/**
	 * This method inserts a new node with value T at the beginning of the list.
	 * O(1).
	 * @param value to be inserted.
	 */
	public void insertFirst(T value) {
		
		Node<T> node = new Node<>(value);
		this.insertFirst(node);
		head = node;


	}

	/**
	 * This method inserts a new node with value T at the beginning of the list.
	 * O(1).
	 * @param newNode node to be inserted.
	 */
	public void insertFirst(Node<T> newNode) {
		
		if(head == null) 
		{
			head = newNode;
			tail = newNode;
		}
		else 
		{
			newNode.setNext(head);
			//tail = head;
			head = newNode;
			
			
		}
		size++;
		
	}



	/**
	 * This method inserts a new node with value T at the end of the list.
	 * O(1)
	 * @param newNode to be inserted.
	 */
	public void insertLast(Node<T> newNode) {		
	

		if(size == 0) 
		{
			
			head = newNode;
		}
		else 
		{

			tail.setNext(newNode);
		}
		
		tail = newNode;

		size++;
	}


	/**
	 * This method removes and returns the first node in the list.
	 * O(1).
	 * @return Node of type T is node to be removed.
	 */
	public Node<T> removeFirst()
	{
		Node<T> temp = head;
		head = head.getNext();
		size--;
		return temp;
	}


	// WARNING: concatenating String objects will yield a O(n^2) solution
	/**
	 * This method returns a string representing the values in the list separated by a single space.
	 * O(n).
	 * @return String representation of linked list.
	 */

	public String listToString() {  
		
		StringBuilder sb = new StringBuilder();
		current = head;
		while(current != null) 
		{
			sb.append(current.getValue());
			if(current != tail) 
			{
				sb.append(" ");
			}
			current = current.getNext();
		}
		return sb.toString();
	}



	/**
	 * Main method used for testing.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		/**
		 * Class used to help with testing.
		 * @author W. Masri
		 */
		class SomeType {
			private int value;

			/**
			 * Constructor for class.
			 * @param value to be initialized.
			 */
			public SomeType(int value) { this.value = value; }
			/**
			 * This method returns a string representing the SomeType class.
			 * @return String representation of linked list.
			 */
			public String toString() { return "" + value; }
			/**
			 * Checks if two objects are equal.
			 * @param o object.
			 * @return true if equal, false otherwise.
			 */
			public boolean equals(Object o) {
				if (!(o instanceof SomeType)) return false;
				return ((SomeType)o).value == value;
			}	
		}
		
		
		SomeType item1 = new SomeType(100);
		SomeType item2 = new SomeType(200);
		SomeType item3 = new SomeType(300);
		SomeType item4 = new SomeType(400);
		Node<SomeType> n5 = new Node<>(new SomeType(500));
		
		LList<SomeType> list = new LList<>();
		
		list.insertFirst(item1);
		list.insertFirst(item2);
		list.insertFirst(item3);
		list.insertFirst(item4);
		
		if (list.listToString().equals("400 300 200 100")) {
			System.out.println("Yay1");
		}

		list.insertLast(n5);	
		if (list.listToString().equals("400 300 200 100 500")) {
			System.out.println("Yay2");
		}

		list.removeFirst();	
		if (list.listToString().equals("300 200 100 500")) {
			System.out.println("Yay3");
		}

		if (list.getFirst().getValue().toString().equals("300")) {
			System.out.println("Yay4");
		}
		
		list.insertFirst(new SomeType(600));	
		if (list.listToString().equals("600 300 200 100 500")) {
			System.out.println("Yay5");
		}		



	}
}