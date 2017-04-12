package 树与图;

class TreeNode {
	int val;
	TreeNode left = null;
	TreeNode right = null;

	TreeNode(int x) {
		val = x;
	}
}

public class CheckBST {

	/*
	 *  method 1
	 *  中序遍历
	 */
	public static int last_printed = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode root) {
		if (root == null) return true;
		if (!checkBST(root.left)) return false;
		if (root.val <= last_printed) return false;
		last_printed = root.val;
		if (!checkBST(root.right)) return false;
		return true;
	}
	
	
	/*
	 *  method 2
	 *  time  O(N)
	 *  space O(log n)
	 *  good method 
	 */
	public boolean checkBST2(TreeNode root) {
		return checkBST2(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	public boolean checkBST2(TreeNode root, int max, int min) {
		if (root == null) return true;
		if (root.val < min || root.val >= max)
			return false;
		if (!checkBST2(root.left, root.val, min) || !checkBST2(root.right, max, root.val))
			return false;
		return true;
	}
}
