package Project5;

/**
 * Data element. A generic class used in the MorseCodeTree classes
 * @author CCPaulHipolito
 */

public class TreeNode<T> {

	protected T data;
	protected TreeNode<T> left, right;
	
	/**
	 * Constructor to create a new TreeNode with left and right child set
	 * to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {
		left = null;
		data = dataNode;
		right = null;
	}
	
	/**
	 * Constructor used for making deep copies
	 * @param node: node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		left = new TreeNode<>(node.left);
		data = node.data;
		right = new TreeNode<>(node.right);
	}
	
	/**
	 * Get method for data
	 * @return the data within this TreeNode
	 */
	public T getData() { return data; }
}
