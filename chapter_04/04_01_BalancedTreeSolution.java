package 树与图;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BalancedTreeSolution {
	
	public boolean isBalanced(TreeNode root) {
		return checkHeight(root) != -1;
	}
	
	public int checkHeight(TreeNode root) {
		if (root == null) return 0;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) return -1;
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) return -1;
		
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
