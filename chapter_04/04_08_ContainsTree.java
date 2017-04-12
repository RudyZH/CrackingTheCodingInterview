Method 1
最规模较小的简单问题中，可以创建一个字符串，表示中序和前序遍历，若t2前序遍历是t1前序遍历的子串，并且t2中序遍历是t1中序遍历的子串，
则t2为t1的子树，null值记为特殊字符

Method 2
boolean containTree(TreeNode t1, TreeNode t2) {
	if (t2 == null) return true;
	return subTree(t1, t2);
}

boolean subTree(TreeNode r1, TreeNode r2) {
	if (r1 == null) return false;
	if (r1.data == r2.data) {
		if (matchTree(r1, r2))
			return true;
	}
	return subTree(r1.left, r2) || subTree(r1.right, r2);
}

boolean matchTree(TreeNode r1, TreeNode r2) {
	if (r2 == null && r1 == null)
		return true;
	
	if (r1 == null || r2 == null)
		return false;
	
	if (r1.data != r2.data) return false;
	return (matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right));
}
