import java.io.Serializable;


/**
 * Binary tree implementation using linked list.
 * @author Qasim Khan
 * @author Yutao Zhong
 */
public class BinaryTree implements Serializable {

	//-------------------------------------------------------------
	// DO NOT EDIT ANYTHING FOR THIS SECTION EXCEPT TO ADD JAVADOCS
	//-------------------------------------------------------------


	/**
	 * Root of tree.
	 */
	public TreeNode root;

	/**
	 * Setter for root of tree.
	 * @param node to be set as root.
	 */
	public void setRoot(TreeNode node){
		this.root = node;
	}
	//-------------------------------------------------------------
	// END OF PROVIDED "DO NOT EDIT" SECTION 
	//-------------------------------------------------------------

	/**
	 * String used for toString methods.
	 */
	private String treeRep = "";

	/**
	 * Queue used for level order.
	 */
	private transient Queue queue = new Queue();




	/**
	 * This is a recursive method used to find the height of the tree.
	 * @param root Starting point of tree to find height of.
	 * @return int height of tree.
	 */
	private int findHeight(TreeNode root) 
	{

		if(root == null) {
			return -1;
		}
		else {
			int leftHeight = findHeight(root.left);
			int rightHeight = findHeight(root.right);
			int max = leftHeight > rightHeight ? leftHeight : rightHeight;
			return 1 + max;
		}
	}
	/**
	 * This recursive method is used to find the number of leaves in a binary tree.
	 * @param root starting point of tree we want to find the leaves of.
	 * @return int number of leaves.
	 */
	private int findLeaves(TreeNode root) 
	{
		if(root == null) 
		{
			return 0;
		}
		if(root.left == null && root.right == null) 
		{
			return 1;
		}
		else 
		{
			return findLeaves(root.left) + findLeaves(root.right);
		}

	}


	/**
	 * This method returns the height of the tree using recursion.
	 * O(H): H as the tree height.
	 * @return int height of tree, -1 if tree is null
	 */
	public int height(){

		return findHeight(root);
	}

	/**
	 * This function returns the number of leaves a binary tree has.
	 * O(N): N is the tree size.
	 * @return number of leaves, zero if null tree.
	 */
	public int numLeaves(){

		return findLeaves(root);
	}

	/**
	 * Helper function that recursively creates a string representation
	 * using pre order traversal.
	 * @param root starting point of tree we want to create the string for.
	 * @return string representation of tree.
	 */
	private String preOrderRep(TreeNode root) 
	{

		treeRep += root;

		if(root.left != null) 
		{
			preOrderRep(root.left);
		}
		if(root.right != null) 
		{
			preOrderRep(root.right);
		}
		return treeRep;
	}

	/**
	 * Helper function that recursively creates a string representation
	 * using in order traversal.
	 * @param root starting point of tree we want to create the string for.
	 * @return string representation of tree.
	 */
	private String inOrderRep(TreeNode root) 
	{
		if ( root.left != null) 
		{
			inOrderRep(root.left);
		}
		treeRep += root;
		if(root.right != null) 
		{
			inOrderRep(root.right);
		}	
		return treeRep;		
	}

	/**
	 * Follows PRE-ORDER traversal to include all nodes.
	 * Root --> left --> right.
	 * @return string representation of the tree.
	 */
	public String toStringPreOrder(){
		treeRep = "";
		return preOrderRep(root); //default return: change or remove as needed
	}

	/**
	 * Follows IN-ORDER traversal to include all nodes.
	 * Left --> root --> right.
	 * @return string representation of the tree.
	 */
	public String toStringInOrder(){
		treeRep = "";
		return inOrderRep(root);
	}


	//======================================INNER CLASSES============================================================================//
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
	/**
	 * First in First out Queue used to help with level order traversal.
	 * @author Qasim Khan
	 */
	class Queue
	{

		/**
		 * Head of queue.
		 */
		private Node<TreeNode> head;
		/**
		 * Tail of queue.
		 */
		private Node<TreeNode> tail;
		/**
		 * Current Node of queue.
		 * Used for iteration.
		 */
		private Node<TreeNode> current;
		/**
		 * Size of queue.
		 */
		private int size = 0;	
		/**
		 * Constructor for queue.
		 * Sets head equal to tail.
		 */
		public Queue() 
		{
			head = tail;
		}	
		/**
		 * Adds Node of type TreeNode to end of linked list.
		 * @param node to be added.
		 */
		public void add(Node<TreeNode> node) 
		{
			if(head == null) 
			{
				head = node;
				tail = head.getNext();
				size++;
				return;
			}
			if(tail == null) 
			{
				tail = node;
				head.setNext(tail);
				size++;
				return;
			}
			tail.setNext(node);
			tail = node;
			size++;
		}
		/**
		 * Removes the head of the linked list.
		 * @return TreeNode value of node.
		 */
		public TreeNode remove() 
		{
			if(head == null) 
			{
				return null;
			}
			TreeNode temp = head.getValue();
			head = head.next;
			size--;
			return temp;
		}
		/**
		 * This method checks if the linked list is empty.
		 * @return boolean true if empty, false otherwise.
		 */
		public boolean isEmpty() 
		{
			return (size == 0);
		}	
		/**
		 * This method is used for the string representation of the queue.
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
	}
	//======================================INNER CLASSES============================================================================//


	/**
	 * Follows LEVEL-ORDER traversal to include all nodes.
	 * Uses a queue to help with level order traversal.
	 * Process all sibling nodes and then goes down a generation.
	 * @return String representation of binary tree.
	 */
	public String toStringLevelOrder(){
		treeRep = "";
		if(root == null) 
		{
			return "";
		}
		Node<TreeNode> rootNode = new Node<TreeNode>(root);
		queue.add(rootNode);

		while(!(queue.isEmpty())) 
		{
			TreeNode temp = queue.remove();
			treeRep += temp;
			if(temp.left != null) 
			{
				queue.add(new Node<TreeNode>(temp.left));
			}
			if(temp.right != null)
			{
				queue.add(new Node<TreeNode>(temp.right));
			}
		}

		return treeRep; //default return: change or remove as needed

	}



	//-------------------------------------------------------------
	// Main Method For Your Testing -- Edit all you want
	//-------------------------------------------------------------

	/**
	 * Main method used for testing.
	 * @param args command line arguments.
	 */
	public static void main(String[] args){

		BinaryTree tree = new BinaryTree();

		//a single-node tree
		tree.setRoot(new TreeNode(1, 'r'));
		if (tree.height() == 0 && tree.numLeaves() == 1 
				&& tree.toStringPreOrder().equals("<r,1>")){
			System.out.println("Yay1");
		}

		//set up a tree
		//        r,1
		//       /   \
		//     a,2    e,10
		//   /     \
		// b,3     c,4
		//           \
		//           d,5
		// Note: this tree is a general binary tree but not a Huffman tree.
		TreeNode node1 = new TreeNode(2, 'a');
		TreeNode node2 = new TreeNode(3, 'b');		
		TreeNode node3 = new TreeNode(4, 'c');
		TreeNode node4 = new TreeNode(5, 'd');
		TreeNode node5 = new TreeNode(10, 'e');
		tree.root.setLeft(node1);
		tree.root.setRight(node5);
		node1.setLeft(node2);
		node1.setRight(node3);
		node3.setRight(node4);

		//tree basic features
		if (tree.root.left.right.count == 4 && tree.height() == 3 && tree.numLeaves() == 3){
			System.out.println("Yay2");
		}

		//tree traversals
		if (tree.toStringPreOrder().equals("<r,1><a,2><b,3><c,4><d,5><e,10>")){
			System.out.println("Yay3");
		}

		if (tree.toStringInOrder().equals("<b,3><a,2><c,4><d,5><r,1><e,10>")){
			System.out.println("Yay4");
		}

		if (tree.toStringLevelOrder().equals("<r,1><a,2><e,10><b,3><c,4><d,5>")){
			System.out.println("Yay5");
		}
	}	
}
