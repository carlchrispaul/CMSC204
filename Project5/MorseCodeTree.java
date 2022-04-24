package Project5;

import java.util.ArrayList;

/**
 * Data Structure. A generic linked binary tree which inherits from the LinkedConverterTreeInterface
 * @author CCPaulHipolito
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	protected TreeNode<String> root = new TreeNode<>("");
	
	/**
	 * Calls the buildTree method
	 */
	public MorseCodeTree() { buildTree(); }
	
	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
	 */
	@Override
	public void buildTree() {
																																											//rootNode
																		//																																														\\	
																	insert(".", "e");																						 																				insert("-", "t");
									//																				\\																									//																						\\
							insert("..", "i");																	insert(".-", "a");																				insert("-.", "n");																			insert("--", "m");
				//										\\											//										\\														//										\\													//										\\
		insert("...", "s");							insert("..-", "u");						insert(".-.", "r");							insert(".--", "w");									insert("-..", "d");							insert("-.-", "k");								insert("--.", "g");							insert("---", "o");
        //				\\							//										//											//				\\									//				\\							//				\\								//				\\
insert("....", "h");insert("...-", "v");   insert("..-.", "f");						insert(".-..", "l");						insert(".--.", "p");insert(".---", "j");			insert("-...", "b");insert("-..-", "x");	insert("-.-.", "c");insert("-.--", "y");		insert("--..", "z");insert("--.-", "q");
	}
	
	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code.
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.equals("."))
				root.left = new TreeNode<>(letter);
			else if(code.equals("-")) 
				root.right = new TreeNode<>(letter);
		} else if(code.length() > 1){
			if(code.charAt(0) == '.')
				addNode(root.left, code.substring(1), letter);
			else if(code.charAt(0) == '-')
				addNode(root.right, code.substring(1), letter);
		}
	}
	
	/**
	 * Fetch the data in the tree based on the code 
	 * This method will call the recursive method fetchNode
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that corresponds with the code 
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String fetched = "";
		if(code.length() == 1) {
			if(code.equals("."))
				fetched = root.left.data;
			else if(code.equals("-"))
				fetched = root.right.data;
		} else if(code.length() > 1) {
			if(code.charAt(0) == '.')
				fetched = fetchNode(root.left, code.substring(1));
			else if(code.charAt(0) == '-')
				fetched = fetchNode(root.right, code.substring(1));
	    }
	    return fetched;
	}
	
	/**
	 * Returns reference to root
	 */
	@Override
	public TreeNode<String> getRoot() { return root; }
	
	/**
	 * Sets its parameter to be the root of MorseCodeTree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) { root = new TreeNode<>(newNode); }

	/**
	 * Adds element to the correct position in the tree based on the code This method will call the recursive method addNode
	 */
	@Override
	public MorseCodeTree insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root == null)
			return;
		else {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			LNRoutputTraversal(root.right, list);
		}
	}

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> arrList = new ArrayList<>();
		LNRoutputTraversal(root, arrList);
		return arrList;
	}

	/**
	 * Unsupported operation
	 */
	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not supported");
	}

	/**
	 * Unsupported operation
	 */
	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Operation not supported");
	}
}
