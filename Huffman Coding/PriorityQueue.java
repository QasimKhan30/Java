import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Priority Queue Implementation.
 * 
 * @author Qasim Khan
 * @author Yutao Zhong
 * @param <T> Generic data type for priority queue.
 */
public class PriorityQueue<T extends Comparable<T>> implements Iterable<T> {

	// -------------------------------------------------------------
	// DO NOT EDIT ANYTHING FOR THIS SECTION EXCEPT TO ADD JAVADOCS
	// -------------------------------------------------------------

	/**
	 * Node that represents the head of the linked list.
	 */
	private Node<T> head = null;

	/**
	 * Provided linked list node class.
	 * @author Yutao Zhong
	 * @param <T> Generic data type of node.
	 */
	private static class Node<T> {
		/**
		 * Value of node.
		 */
		private T value;

		/**
		 * Next node in linked list.
		 */
		private Node<T> next;

		/**
		 * Constructor for node.
		 * 
		 * @param value to be set as value.
		 */
		public Node(T value) {
			this.value = value;
		}

	}

	/**
	 * Provided toString() method using the iterator.
	 * @return String representation of iterator.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		for (T value : this) {
			builder.append(value);
			builder.append(" ");
		}
		return builder.toString().trim();
	}

	/**
	 * Provided iterator.
	 * @return Iterator of type T to be returned.
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> current = head;

			/**
			 * Returns the current nodes value. Sets current to the next node.
			 * 
			 * @return T value of current node.
			 */
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				T val = current.value;
				current = current.next;
				return val;
			}

			/**
			 * Checks if a node has a next node.
			 * @return boolean true if linked list has next node.
			 */
			public boolean hasNext() {
				return (current != null);
			}
		};
	}

	// -------------------------------------------------------------
	// END OF PROVIDED "DO NOT EDIT" SECTION
	// -------------------------------------------------------------



	/**
	 * variable used to keep track of the number of items in the linked list.
	 */
	private int size = 0;


	/**
	 * Default constructor for Priority Queue.
	 */
	public PriorityQueue() {
		//head = tail;

	}

	/**
	 * This method is used to return the number of elements in the priority queue.
	 * O(1).
	 * @return int size of priority queue.
	 */
	public int size() {

		return size;
	}

	/**
	 * This function adds a value into the priority queue. The value is used as its
	 * priority. O(n) where n is the number of items in queue.
	 * @param value of node to be added into queue.
	 */
	public void add(T value) {
		// The priority queue must be organized as a sorted singly
		// linked list. No dummy nodes.

		// Hint: you will need to decide a way to store/sort the values
		// so that the remove/element methods can also meet the required
		// behavior and big-O in time. Do check the requirements of
		// remove()/element() below before you code this method.

		Node<T> insertNode = new Node<T>(value);

		if (head == null || value.compareTo(head.value) < 0) {
			insertNode.next = head;
			head = insertNode;
			size++;
			return;
		}

		Node<T> current = head;
		while ((current.next != null) && (value.compareTo(current.next.value) > 0)) // if the next node is not null
		{ // and the next next nodes value
			current = current.next; // is less than our value
		}

		insertNode.next = current.next;
		current.next = insertNode;
		size++;
	}

	/**
	 * This method removes and returns the value with the minimal priority value. If
	 * two or more items are of the same priority, FIFO is maintained. O(1).
	 * @return T value of the removed node.
	 */
	public T remove() {

		if (head == null) {
			throw new NoSuchElementException("Priority queue empty!");
		}
		T temp = head.value;

		head = head.next;
		size--;

		return temp;

	}

	/**
	 * This method peeks at the head of the queue.
	 * @return value to be removed next.
	 */
	public T element() {

		return head.value;

	}

	/**
	 * This method checks if a value is present in the priority queue. O(n) where n
	 * is the number of items in queue.
	 * @param value to be checked.
	 * @return true if value is present in queue, false otherwise.
	 */
	public boolean contains(T value) {

		Iterator<T> iter = iterator();
		while (iter.hasNext()) {
			if ((iter.next().equals(value))) {
				return true;
			}
		}
		return false;

	}

	// -------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	// -------------------------------------------------------------

	/**
	 * Main method used for testing.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		PriorityQueue<Character> letters = new PriorityQueue<>();

		// add/size/element/contains
		String chars = "MASON";
		for (int i = 0; i < 5; i++) {
			letters.add(chars.charAt(i));
		}

		if (letters.size() == 5 && letters.element() == 'A' && letters.contains('O') && !letters.contains('B')) {
			System.out.println("Yay 1");
		}

		// remove
		if (letters.remove() == 'A' && letters.size() == 4 && letters.element() == 'M') {
			System.out.println("Yay 2");
		}

		// sequence of add/remove
		PriorityQueue<Integer> nums = new PriorityQueue<>();
		for (int i = 0; i < 10; i++) {
			int val = (i * i) % 17;
			nums.add(val);
		}
		boolean ok = nums.toString().trim().equals("0 1 2 4 8 9 13 13 15 16");
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int val = nums.remove();
			output.append(val);
			output.append(" ");
		}
		if (ok && output.toString().trim().equals("0 1 2 4 8 9 13 13 15 16")) {
			System.out.println("Yay 3");
		}

		// values added with the same priority are kept in FIFO order
		PriorityQueue<String> msgs = new PriorityQueue<>();
		String msg1 = new String("Hello");
		String msg2 = new String("Hello");
		msgs.add(msg1);
		msgs.add(chars);
		msgs.add(msg2);
		if (msgs.toString().trim().equals("Hello Hello MASON") && msgs.contains(msg1) && msgs.contains(msg2)
				&& msgs.element() == msg1 && msgs.remove() != msg2) { // use of "==" is intentional here
			System.out.println("Yay 4");
		}

	}

}