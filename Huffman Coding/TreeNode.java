//-------------------------------------------------------------
// DO NOT EDIT ANYTHING FOR THIS CLASS EXCEPT TO ADD JAVADOCS
//-------------------------------------------------------------
import java.io.Serializable;

/**
 * Tree node class to be used in a binary Huffman tree.
 * @author Y. Zhong.
 *
 */
public class TreeNode implements Serializable, Comparable<TreeNode> {

	//bad practice to have public inst. variables, 
	//but we want to test this more easily...
	
	/**
	 * Count for the character (leaf node) or total of counts from both children (internal node).
	 */
	public int count;
	
	/**
	 * Character represented by this node.
	 * Internal node: keep character to be null.
	 */
	public Character character = null;
	

	/**
	 * Children links.
	 */
	public TreeNode left, right;
	
	/**
	 * Constructor for Tree Node.
	 * @param count count is initialized to this integer.
	 */
	public TreeNode(int count){
		this.count = count;
	}
	
	/**
	 * Constructor for tree node with two parameters.
	 * @param count count is initialized to this integer.
	 * @param character character is initialized to this character.
	 */
	public TreeNode(int count, Character character){
		this.count = count;
		this.character = character;
	}

	/**
	 * Setter for left child of tree node.
	 * @param left tree node to be set.
	 */
	public void setLeft(TreeNode left){ this.left = left;}
	/**
	 * Setter for right child of tree node.
	 * @param right tree node to be set.
	 */
	public void setRight(TreeNode right){ this.right = right;}
	
	/**
	 * This method compares two tree node objects.
	 * @param otherNode node to be compared to.
	 * @return difference between count.
	 */
	public int compareTo(TreeNode otherNode){
		if (this.count - otherNode.count!=0){
			return (this.count - otherNode.count); //compare count
		}
		else{
			if (this.character!=null && otherNode.character!=null) {//use char to break the tie
				return (this.character - otherNode.character); 
				//same character + same count would be a tie
			}
			else{
				return (this.count - otherNode.count); 
				//null + same count would be a tie				
			}
		}		
	}
	
	/**
	 * This method checks whether two tree node objects are equal.
	 * @return boolean true if equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o){
		if (!(o instanceof TreeNode)){
			return false;
		}
		TreeNode otherNode = (TreeNode) o;
		return (this.compareTo(otherNode) == 0);
	}
	
	/**
	 * String representation of tree node.
	 * @return String representation of tree node.
	 */
	public String toString(){ 
		return "<"+this.character+","+this.count+">";			
	}
}