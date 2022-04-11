/**
 * @author Yassin Yassin
 */

public class TreeNode<T> {

	protected T data;
	protected TreeNode<T> left;
	protected TreeNode<T> right;
	
	/**
	 * Constructor that sets left and right nodes to null
	 * @param data
	 */
	TreeNode(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Constructor that uses node to set the TreeNode fields
	 * @param node
	 */
	TreeNode(TreeNode<T> node){
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
		
	}

	/**
	 * This method will return the data
	 * @returns data
	 */
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

}