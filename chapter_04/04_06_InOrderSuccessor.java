package 树与图;

class TreeNode {
	int val;
	TreeNode parent = null;
	TreeNode left = null;
	TreeNode right = null;

	TreeNode(int x) {
		val = x;
	}
}

public class InOrderSuccessor {

	public TreeNode inorderSucc(TreeNode node) {
		if (node == null) return null;
		if (node.right != null) 
			return leftMostChild(node.right);
		
		TreeNode p = node.parent;
		while (p != null && node == p.right) {
			node = p;
			p = p.parent;
		}	
		return p;
	}
	
	public TreeNode leftMostChild(TreeNode root) {
		if (root == null) return null;
		while (root.left != null)
			root = root.left;
		return root;
			
	}
}
