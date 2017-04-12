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

public class CommonAncestor {

	/*
	 *  method 1
	 *  time O(n)
	 *  good
	 */
	// 若p为root的子孙，则返回true
	public boolean covers(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	
	public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		if (root == p || root == q) return root;
		boolean is_p_in_left = covers(root.left, p);
		boolean is_q_in_left = covers(root.left, q);
		
		if (is_p_in_left != is_q_in_left) return root;
		TreeNode childSide = is_p_in_left ? root.left : root.right;
		return commonAncestor(childSide, p, q);
	}
	
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q))
			return null;
		return commonAncestorHelper(root, p, q);
	}
	
	/*
	 *  method 2
	 */
	class Result{
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode node, boolean isAnc) {
			this.node = node;
			isAncestor = isAnc;
		}
	}
	
	Result commonAncestorHelper2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return new Result(null, false);
		if (root == p && root == q)
			return new Result(root, true);
		
		Result rx = commonAncestorHelper2(root.left, p, q);
		if (rx.isAncestor) return rx;
		
		Result ry = commonAncestorHelper2(root.right, p, q);
		if (ry.isAncestor) return ry;
		
		if (rx.node != null && ry.node != null)
			return new Result(root, true);
		else if (root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null ? true : false;
			return new Result(root, isAncestor);
		} else
			return new Result(rx.node != null ? rx.node : ry.node, false);
	}
	
	TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncestorHelper2(root, p, q);
		if (r.isAncestor)
			return r.node;
		return null;
	}
}
