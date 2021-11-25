// TO DO: JavaDocs

/**
 * A generic class representing a node in the linked list implementation LList of type T.
 * @author W. Masri
 * @param <T> Generic Data type for the stack.
 */
public class Node<T> {
	/**
	 * The node's value.
	 */
	private T value;

	/**
	 * The node's link to the next element in the linked list.
	 */
	private Node<T> next;		


	/**
	 * Constructors.
	 * @param value to be initialized.
	 * @param next to be initialized.
	 */
	public Node(T value, Node<T> next) { 
		this.value = value; 
		this.next = next; 
	}
	/**
	 * Initializer with value.
	 * @param value to be initialized.
	 */
	public Node(T value) { 
		this.value = value; 
		this.next = null; 
	}


	/**
	 * Getter for value.
	 * @return value to be returned.
	 */
	public T getValue() {	
		return value;	
	}

	/**
	 * Setter for value.
	 * @param value to be returned.
	 */
	public void setValue(T value) {	
		this.value = value;	
	}

	/**
	 * Getter for the next node.
	 * @return Node next in line.
	 */
	public Node<T> getNext() {	
		return this.next;	
	}

	/**
	 * Setter for next.
	 * @param next to be set.
	 */
	public void setNext(Node<T> next) {	
		this.next = next;	
	}


	/**
	 * Returns a string description of the node's value attribute.
	 * @return String representation.
	 */
	@Override
	public String toString() { 
		return value.toString(); 
	}
}

