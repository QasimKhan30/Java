
/**
 * This class is used to implement a stack data structure.
 * Last in First out.
 * First in Last out.
 * @author Qasim Khan
 * @param <T> Generic Data type for the stack.
 */
public class Stack<T> {  
	/**
	 * Linked list data structure containing data type T.
	 */
	private LList<T> elements;
	
	/**
	 * keeps track of the number of elements on the stack.
	 */
	private int size = 0;
	
	/**
	 * initialize the stack to being an empty stack (or list).
	 */
	public Stack() {
		
		elements = new LList<>();
	}


	/**
	 * Pushes a value into the stack.
	 * @param e value to be pushed to the beginning of the stack O(1).
	 */
	public void push(T e) {
		elements.insertFirst(e);
		size++;
	}

	/**
	 * Remove element at the beginning of the list and return it O(1).
	 * @return T value of node in the linked list.
	 */
	public T pop() {

		Node<T> poppedNode = elements.removeFirst();
		size--;
		return poppedNode.getValue();

	}

	/**
	 * Returns the element at the beginning of the list without removing it.
	 * O(1).
	 * @return T value to be looked at.
	 */
	public T peek() {
		return elements.getFirst().getValue();
	}


	/**
	 * Checks if the stack is empty.
	 * O(1).
	 * @return boolean true if the stack is empty.
	 */
	public boolean isEmpty() {
		return elements.getFirst() == null;
	}


	/**
	 * Returns the number of nodes in the stack.
	 * O(1).
	 * @return int size of Stack.
	 */
	public int getSize() {	
		return size;
	}


	/**
	 * Returns strings representing the values in the stack from top to bottom.
	 * O(n).
	 * @return String representation of stack.
	 */
	public String toString() { 
		
		return elements.listToString();
	}

	/**
	 * Main method used for testing.
	 * @param args command line arguments.
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
		
		Stack<SomeType> s = new Stack<>();
		s.push(item1);
		s.push(item2);

		if (s.getSize() == 2) {
			System.out.println("Yay1");
		}
		//System.out.println(s.getSize());

		if (s.peek().toString().equals("200")) {
			System.out.println("Yay2");
			
		}
		
		if (s.pop().toString().equals("200")) {
			System.out.println("Yay3");
		}
		
	
		s.push(item3);
		s.push(item4);
		

		
		if (s.toString().equals("400 300 100")) {
			System.out.println("Yay4");
		}
		
		s.pop();
		s.pop();
		if (s.toString().equals("100")) {
			System.out.println("Yay5");
		}

		s.pop();
		if (s.isEmpty()) {
			System.out.println("Yay6");
		}

	}
}